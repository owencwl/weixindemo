package com.owen.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import com.owen.util.CheckUtil;
import com.owen.util.MessageUtil;
import com.owen.util.WeixinUtil;

public class WeixinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	/**
	 * 开发者通过检验signature对请求进行校验（下面有校验方式）。若确认此次GET请求来自微信服务器，
	 * 请原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败。加密/校验流程如下：
		1）将token、timestamp、nonce三个参数进行字典序排序
		2）将三个参数字符串拼接成一个字符串进行sha1加密
		3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String signature = req.getParameter("signature");//微信加密签名
		String timestamp = req.getParameter("timestamp");//时间戳
		String nonce = req.getParameter("nonce");//随机数
		String echostr = req.getParameter("echostr");//随机字符串
		
		PrintWriter out = resp.getWriter();
		//与加密字符串对比
		if(CheckUtil.checkSignature(signature, timestamp, nonce)){
			
			out.print(echostr);//原样返回echostr 表示链接成功
		}
	}
	
	/**
	 * 当普通微信用户向公众账号发消息时，微信服务器将POST消息的XML数据包到开发者填写的URL上。
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		try {
			
			Map<String, String> map = MessageUtil.xmlToMap(req);
			
			
			String fromUserName = map.get("FromUserName");
			String toUserName = map.get("ToUserName");
			String msgType = map.get("MsgType");
			String content = map.get("Content");
			
			String message = null;
			
			if(MessageUtil.MESSAGE_TEXT.equals(msgType)){//文本消息
				if("1".equals(content)){
					
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.firstMenu());
				
				}else if("2".equals(content)){
					message = MessageUtil.initNewsMessage(toUserName, fromUserName);
				
				}else if("3".equals(content)){
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.threeMenu());
				
				
				}else if("?".equals(content) || "？".equals(content)){
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.menuText());
				}
				
				
			}else if(MessageUtil.MESSAGE_EVNET.equals(msgType)){//点击菜单事件
				String eventType = map.get("Event");
				
				if(MessageUtil.MESSAGE_SUBSCRIBE.equals(eventType)){//关注公众号
					
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.menuText());
				
				}else if(MessageUtil.MESSAGE_CLICK.equals(eventType)){//点击按钮
					
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.menuText());
				
				
				}else if(MessageUtil.MESSAGE_VIEW.equals(eventType)){//跳转网页
					
					String url = map.get("EventKey");
					message = MessageUtil.initText(toUserName, fromUserName, url);
				
				
				}else if(MessageUtil.MESSAGE_SCANCODE.equals(eventType)){//扫描二维码
				
					
					String key = map.get("EventKey");
					message = MessageUtil.initText(toUserName, fromUserName, key);
				}
			
			
			}else if(MessageUtil.MESSAGE_LOCATION.equals(msgType)){//地理位置
				String label = map.get("Label");
				message = MessageUtil.initText(toUserName, fromUserName, label);
			}
			
			
			System.out.println(message);
			
			out.print(message);//传送给微信服务器 发给微信用户。
			
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
