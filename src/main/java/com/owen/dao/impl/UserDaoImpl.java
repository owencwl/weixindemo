package com.owen.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.owen.dao.UserDao;
import com.owen.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	@Override
	public boolean login(User user) {

		System.out.println("chenwanlin DAO DAO DAO");

		//
		// try {
		// String hql = "from User where name=? and password=?";
		// System.out.println(hql);
		// @SuppressWarnings("unchecked")
		// List<User> list = (List<User>) hibernateTemplate.find(hql, new
		// String[]{user.getName(),user.getPassword()});
		//
		// if (list.size() > 0) {
		//
		// return true;
		// } else {
		//
		// return false;
		// }
		// } catch (RuntimeException e) {
		// // TODO: handle exception
		// throw e;
		// }
		return false;
	}

	@Override
	public void save(User user) {

		hibernateTemplate.save(user);
		
		
		
		
	}

	@Override
	public boolean find(String openid) {

		
		String hql="from User where openid=?";
		List<User> list = (List<User>)hibernateTemplate.find(hql, openid);
		if (list.size() > 0) {

			return true;
		} else {

			return false;
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
