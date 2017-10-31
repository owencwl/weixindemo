package com.owen.test;

import com.owen.po.AccessToken;
import com.owen.util.WeixinUtil;

import net.sf.json.JSONObject;


public class WeixinTest {
	public static void main(String[] args) {
		try {
			AccessToken token = WeixinUtil.getAccessToken();
			System.out.println("获取到的凭证"+token.getToken());
			System.out.println("凭证有效时间:"+token.getExpiresIn());
			
			//String path = "D:/imooc.jpg";
			//String mediaId = WeixinUtil.upload(path, token.getToken(), "thumb");
			//System.out.println(mediaId);
			
			//String result = WeixinUtil.translate("my name is laobi");
			//String result = WeixinUtil.translateFull("");
			
			String menu=JSONObject.fromObject(WeixinUtil.initMenu()).toString();
			int result=WeixinUtil.createMenu(token.getToken(), menu);
			
			if(result==0){
				
				System.out.println("创建菜单返回值："+result+"  成功创建菜单！！！！！");
			}else{
				System.out.println("创建菜单返回值："+result+"菜单创建失败，请查询微信开发者文档错误返回代码~~~~");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
