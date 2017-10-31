package com.owen.dao;

import com.owen.entity.Admin;
import com.owen.entity.Shop;
import com.owen.entity.Shoptype;

import java.util.ArrayList;
import java.util.List;

public interface AdminDao {
    public boolean login(Admin admin);

    public List<Shoptype> showshoptype();

    public boolean addshoptype(Shoptype shoptype);

    public boolean delshoptyoe(ArrayList<String> list);

    public boolean addshop(Shop shop);
    public Shop findshop(String shopid);
    public List<Shop> showshop();

    public boolean delshop(ArrayList<Shop> listshop, String logopath);

    public boolean updateshop(Shop shop);

    public void save(Admin admin);

    public void update(Admin admin);

    public void delete(String ids);

    public void roleEdit(Admin admin);

    public void editUserInfo(Admin admin);
}
