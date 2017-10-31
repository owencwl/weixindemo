package com.owen.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.owen.entity.*;
import com.owen.util.DeleteLogo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.owen.dao.ShopkeeperDao;

@Repository
public class ShopkeeperDaoImpl implements ShopkeeperDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Shopkeeper login(Shopkeeper shopkeeper) {


        try {
            String hql = "from Shopkeeper where shopkeepername=? and shopkeeperpwd=?";
            System.out.println(hql);
            @SuppressWarnings("unchecked")
            List<Shopkeeper> list = (List<Shopkeeper>) hibernateTemplate.find(hql, new String[]{shopkeeper.getShopkeepername(), shopkeeper.getShopkeeperpwd()});

            if (list.size() > 0) {


                return list.get(0);
            } else {

                return null;
            }
        } catch (RuntimeException e) {
            // TODO: handle exception
            throw e;
        }

    }

    @Override
    public boolean register(Shopkeeper shopkeeper) {

        hibernateTemplate.save(shopkeeper);

        return true;
    }

    @Override
    public Shop findshop(String shopkeeperid) {

        String hql = "from Shop where shopboss=?";

        List<Shop> list = (List<Shop>) hibernateTemplate.find(hql, new String[]{shopkeeperid});


        return list.get(0);


    }

    @Override
    public boolean updateshop(Shop shop) {

        //Session session=sessionFactory.getCurrentSession();
        //Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        //session.beginTransaction();
        //session.update(shop);
        //session.getTransaction().commit();


        hibernateTemplate.update(shop);
        //hibernateTemplate.merge(shop);
        //hibernateTemplate.saveOrUpdate(shop);
        return true;
    }

    @Override
    public List<Goods> showgoods() {


        try {
            String hql = "from Goods ";
            @SuppressWarnings("unchecked")
            List<Goods> list = (List<Goods>) hibernateTemplate.find(hql);

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
    public void addgoods(Goods goods) {


        hibernateTemplate.save(goods);

    }

    @Override
    public boolean delgoods(ArrayList<Goods> listgoods, String contextPath) {

        String delhql = "delete Goods where goodsid=? ";
        String findlogohql = "from Goods where goodsid=? ";
        //获取logo地址
        List<String> imgsrclist = new ArrayList<>();


        for (Goods ss : listgoods
                ) {

            List<Goods> singlegoods = (List<Goods>) hibernateTemplate.find(findlogohql, new String[]{ss.getGoodsid()});

            imgsrclist.add(singlegoods.get(0).getGoodsimagename());

            //删除数据库中的记录
            hibernateTemplate.bulkUpdate(delhql, new String[]{ss.getGoodsid()});

        }
/**
 *
 删除logo文件
 */
        DeleteLogo deleteLogo = new DeleteLogo();

        try {
            deleteLogo.dellogo(imgsrclist, contextPath);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Goodstype> showgoodstype() {


        try {
            String hql = "from Goodstype ";
            @SuppressWarnings("unchecked")
            List<Goodstype> list = (List<Goodstype>) hibernateTemplate.find(hql);

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
    public void save(Shopkeeper shopkeeper) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Shopkeeper shopkeeper) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(String ids) {
        // TODO Auto-generated method stub

    }

    @Override
    public void roleEdit(Shopkeeper shopkeeper) {
        // TODO Auto-generated method stub

    }

    @Override
    public void editUserInfo(Shopkeeper shopkeeper) {
        // TODO Auto-generated method stub

    }


}
