package com.owen.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.owen.service.UserService;
import com.owen.util.CheckUtil;
import com.owen.util.MessageUtil;
import com.owen.util.WeixinUtil;

@Controller
@RequestMapping("/connect")
public class WeixinController {

	@Autowired
	private UserService userService;
	
	
	
	@RequestMapping(value="/connected",method=RequestMethod.GET)
	public void connection(HttpServletRequest req,HttpServletResponse resp)
			throws IOException {
		String signature = req.getParameter("signature");// 微信加密签名
		String timestamp = req.getParameter("timestamp");// 时间戳
		String nonce = req.getParameter("nonce");// 随机数
		String echostr = req.getParameter("echostr");// 随机字符串

		PrintWriter out = resp.getWriter();
		// 与加密字符串对比
		if (CheckUtil.checkSignature(signature, timestamp, nonce)) {

			out.print(echostr);// 原样返回echostr 表示链接成功
		}else{
			out.print("error");
		}

	}

	
	@RequestMapping(value="/connected",method=RequestMethod.POST)
	public void dopost(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		
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
	@RequestMapping(value="/oauth")
	public String oauth2(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		
		//通过微信用户点击按钮 产生一个获取用户的请求, 此请求中包含的有重定向网页路径, 就是此/oauth下 
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		//返回的数据中获取code
		String code=req.getParameter("code");
		
		System.out.println("code:"+code);
		
		//还需要获取用户的openid，必须使用code值
		String openid_url="https://api.weixin.qq.com/sns/oauth2/access_token?appid="+"wx86f151e75314bbb2"
		+"&secret="+"abd8842cccf59c64906a98c9e9e0537c"+"&code="+code+"&grant_type=authorization_code";
		
		//产生请求 获取openid
		JSONObject openJson=WeixinUtil.doGetStr(openid_url);
		//解析openid
		String openid=openJson.getString("openid");
		String accesstoken=openJson.getString("access_token");
		
		System.out.println("openid: "+openid);
		
		//还需要获取用户个人信息 必须使用accesstoken+openid值
		String userinfo_url="https://api.weixin.qq.com/sns/userinfo?access_token="+accesstoken+"&openid="+openid+"&lang=zh_CN";
		//产生获取信息的请求
		JSONObject userinfo=WeixinUtil.doGetStr(userinfo_url);
		
		//获取用户信息完毕 输出打印
		
		System.out.println(userinfo.toString());
		
		userService.find(userinfo);
		
		
		return "../customer/showshop";
	}
}
