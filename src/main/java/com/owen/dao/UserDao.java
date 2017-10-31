package com.owen.dao;

import com.owen.entity.User;

public interface UserDao {
	public boolean login(User user);

	public void save(User user);
	
	public boolean find(String openid);







	public void update(User user);

	public void delete(String ids);

	public void roleEdit(User user);

	public void editUserInfo(User user);
}
