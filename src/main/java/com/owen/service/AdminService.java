package com.owen.service;

import com.owen.entity.Admin;
import com.owen.entity.Shop;
import com.owen.entity.Shoptype;

import java.util.ArrayList;
import java.util.List;

public interface AdminService {
	public Admin login(Admin admin);

	public List<Shoptype> showshoptype();

	public boolean addshoptype(Shoptype shoptype);

	public boolean delshoptype(ArrayList<String> list);

	public  boolean addshop(Shop shop);
	public List<Shop> showshop();
	public void delshop(ArrayList<Shop> listshop,String logopath);

	public void updateshop(Shop shop);


	public Shop findshop(String shopid);

	public void save(Admin admin);

	public void update(Admin admin);

	public void delete(String ids);

	public void roleEdit(Admin admin);

	public void editUserInfo(Admin admin);

}
