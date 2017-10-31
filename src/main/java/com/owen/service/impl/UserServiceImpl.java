package com.owen.service.impl;

import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owen.dao.UserDao;
import com.owen.dao.impl.UserDaoImpl;
import com.owen.entity.User;
import com.owen.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private User user;
	
	@Autowired
	private UserDao userDao;
	
	
	@Override
	public User login(User user) {

		return null;
	}

	@Override
	public void save(JSONObject userinfo) {

		user =new User();
		String openid = userinfo.getString("openid");
		String nickname = userinfo.getString("nickname");
		String sex = userinfo.getString("sex");
		String headimage = userinfo.getString("headimgurl");

		user.setNickname(nickname);
		user.setImage(headimage);
		user.setOpenid(openid);

		//user.setSex(1);
		
		userDao.save(user);
		
		
	}

	@Override
	public void find(JSONObject userinfo) {

		user =new User();
		String openid = userinfo.getString("openid");
		String nickname = userinfo.getString("nickname");
		String sex = userinfo.getString("sex");
		String headimage = userinfo.getString("headimgurl");

		user.setNickname(nickname);
		user.setImage(headimage);
		user.setOpenid(openid);
		//user.setSex((short)Integer.parseInt(sex));

		if(userDao.find(openid)){
			
			
			
		}else{
			
			userDao.save(user);
			
		}
		
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void roleEdit(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void editUserInfo(User user) {
		// TODO Auto-generated method stub

	}

}
