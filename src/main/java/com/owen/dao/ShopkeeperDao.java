package com.owen.dao;

import com.owen.entity.Goods;
import com.owen.entity.Goodstype;
import com.owen.entity.Shop;
import com.owen.entity.Shopkeeper;

import java.util.ArrayList;
import java.util.List;

public interface ShopkeeperDao {

    public Shopkeeper login(Shopkeeper shopkeeper);

    public boolean register(Shopkeeper shopkeeper);

    public Shop findshop(String shopkeeperid);

    public boolean updateshop(Shop shop);

    public List<Goods> showgoods();

    public void addgoods(Goods goods);

    public boolean delgoods(ArrayList<Goods> listgoods, String contextPath);

    public List<Goodstype> showgoodstype();

    public void save(Shopkeeper shopkeeper);

    public void update(Shopkeeper shopkeeper);

    public void delete(String ids);

    public void roleEdit(Shopkeeper shopkeeper);

    public void editUserInfo(Shopkeeper shopkeeper);


}
