package com.owen.dao.impl;

import com.owen.dao.AdminDao;
import com.owen.entity.Admin;
import com.owen.entity.Shop;
import com.owen.entity.Shoptype;
import com.owen.entity.User;
import com.owen.util.DeleteLogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AdminDaoImpl implements AdminDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public boolean login(Admin admin) {
        System.out.println("adminname:" + admin.getAdminname() + "   " + "adminpwd:" + admin.getAdminpwd());

        try {
            String hql = "from Admin where adminname=? and adminpwd=?";
            System.out.println(hql);
            @SuppressWarnings("unchecked")
            List<User> list = (List<User>) hibernateTemplate.find(hql, new String[]{admin.getAdminname(), admin.getAdminpwd()});

            if (list.size() > 0) {

                return true;
            } else {

                return false;
            }
        } catch (RuntimeException e) {
            // TODO: handle exception
            throw e;
        }


    }

    @Override
    public List<Shoptype> showshoptype() {

        try {
            String hql = "from Shoptype ";
            List<Shoptype> list = (List<Shoptype>) hibernateTemplate.find(hql);

            if (list.size() > 0) {
                return list;
            } else {
                return null;
            }
        } catch (RuntimeException e) {
            // TODO: handle exception
            throw e;
        }

    }

    @Override
    public boolean addshoptype(Shoptype shoptype) {


        System.out.println("在shoptype表中 增加类型 !!!!! " + shoptype.getShoptypename());

        try {
            hibernateTemplate.save(shoptype);

        } catch (RuntimeException e) {

            throw e;
        }
        return true;
    }

    @Override
    public boolean delshoptyoe(ArrayList<String> list) {

        String hql = "delete Shoptype where shoptypename=? ";

        for (String str : list
                ) {

            hibernateTemplate.bulkUpdate(hql, new String[]{str});

        }

        return true;
    }

    @Override
    public boolean addshop(Shop shop) {

        System.out.println("DAOShopid:"+shop.getShopid());
        hibernateTemplate.save(shop);
        return true;
    }

    @Override
    public List<Shop> showshop() {

        try {
            String hql = "from Shop";
            @SuppressWarnings("unchecked")
            List<Shop> list = (List<Shop>) hibernateTemplate.find(hql);

            if (list.size() > 0) {

                return list;
            } else {

                return null;
            }
        } catch (RuntimeException e) {
            // TODO: handle exception
            throw e;
        }

    }

    @Override
    public boolean delshop(ArrayList<Shop> list, String logopath) {

        String delhql = "delete Shop where shopid=? ";

        String findlogohql = "from Shop where shopname=? and shopemail=? and shopaddress=?";


        //获取logo地址
        List<String> imgsrclist = new ArrayList<>();

        for (Shop ss : list
                ) {

            List<Shop> singleshop = (List<Shop>) hibernateTemplate.find(findlogohql, new String[]{ss.getShopname(), ss.getShopemail(), ss.getShopaddress()});

            imgsrclist.add(singleshop.get(0).getShopimagename());

            //删除数据库中的记录
            hibernateTemplate.bulkUpdate(delhql, new String[]{singleshop.get(0).getShopid()});

        }
/**
 *
 删除店铺logo文件
 */
        DeleteLogo deleteLogo = new DeleteLogo();

        try {
            deleteLogo.dellogo(imgsrclist, logopath);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean updateshop(Shop shop) {

        hibernateTemplate.update(shop);

//        if (shop.getShopimagename() != null) {
//
//            hibernateTemplate.update(shop);
//
//        } else {
//
//            String hql = "update Shop set shopname=?,shoptype=?,shoptel=?,shopemail=?,shopaddress=?,shopdescript=? where shopid=?";
//
//            Object[] value={shop.getShopname(),shop.getShoptypeByShoptypename(),shop.getShoptel(),shop.getShopemail(),shop.getShopaddress(),shop.getShopdescript(),shop.getShopid()};
//
//            hibernateTemplate.bulkUpdate(hql,value);
//        }


        return true;
    }

    @Override
    public Shop findshop(String shopid) {


        String hql = "from Shop where shopid=?";

        List<Shop> list = (List<Shop>) hibernateTemplate.find(hql, new String[]{shopid});


        return  list.get(0);

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
