package com.owen.service;

import net.sf.json.JSONObject;

import com.owen.entity.User;

public interface UserService {
	public User login(User user);

	public void save(JSONObject jsonObject);

	public void update(User user);

	public void find(JSONObject jsonObject);

	public void delete(String ids);

	public void roleEdit(User user);

	public void editUserInfo(User user);

}
