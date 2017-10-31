package com.owen.service.impl;

import com.owen.dao.AdminDao;
import com.owen.entity.Admin;
import com.owen.entity.Shop;
import com.owen.entity.Shoptype;
import com.owen.service.AdminService;
import com.owen.util.UUIDBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;


    @Override
    public List<Shoptype> showshoptype() {

        List<Shoptype> shoptypeList = adminDao.showshoptype();

        if (shoptypeList.isEmpty()) {

            return null;
        } else {
            return shoptypeList;
        }


    }

    @Override
    public boolean delshoptype(ArrayList<String> list) {

        if (adminDao.delshoptyoe(list)) {
            return true;
        } else {

            return false;

        }


    }

    @Override
    public boolean addshoptype(Shoptype shoptype) {


        //String str = MD5Builder.build(shoptype.getShoptypename(), "UTF-8");
        String str = UUIDBuilder.getUUID();
        shoptype.setShoptypeid(str);

//       String name= shoptype.getShoptypename();
//        try {
//            name=new String(name.getBytes("UTF-8"),"utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        shoptype.setShoptypename(name);

        adminDao.addshoptype(shoptype);


        return true;
    }

    @Override
    public Admin login(Admin admin) {

        if (adminDao.login(admin)) {
            return admin;
        } else {
            return null;
        }

    }

    @Override
    public boolean addshop(Shop shop) {


        if (adminDao.addshop(shop)) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public List<Shop> showshop() {

        List<Shop> shop = adminDao.showshop();


        if (shop.isEmpty()) {

            return null;
        } else {

            return shop;

        }
    }

    @Override
    public void delshop(ArrayList<Shop> listshop, String logopath) {

        adminDao.delshop(listshop, logopath);


    }

    @Override
    public void updateshop(Shop shop) {

        adminDao.updateshop(shop);

    }

    @Override
    public Shop findshop(String shopid) {




        return  adminDao.findshop(shopid);
    }

    @Override
    public void save(Admin admin) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Admin admin) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(String ids) {
        // TODO Auto-generated method stub

    }

    @Override
    public void roleEdit(Admin admin) {
        // TODO Auto-generated method stub

    }

    @Override
    public void editUserInfo(Admin admin) {
        // TODO Auto-generated method stub

    }

}
