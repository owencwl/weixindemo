package com.owen.service.impl;

import com.owen.entity.Goods;
import com.owen.entity.Goodstype;
import com.owen.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owen.dao.ShopkeeperDao;
import com.owen.entity.Shopkeeper;
import com.owen.service.ShopKeeperService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopKeeperServiceImpl implements ShopKeeperService {

	

	@Autowired
	private ShopkeeperDao shopkeeperDao;

	@Override
	public Shopkeeper login(Shopkeeper shopkeeper) {

		Shopkeeper ss=shopkeeperDao.login(shopkeeper);

		if (ss!=null) {

			return ss;
		} else {

			return null;
		}

	}
	@Override
	public boolean register(Shopkeeper shopkeeper) {

		shopkeeperDao.register(shopkeeper);
		
		return true;
		
	}

	@Override
	public Shop findshop(String shopkeeperid) {


		return  shopkeeperDao.findshop(shopkeeperid);

	}

	@Override
	public boolean updateshop(Shop shop) {


		shopkeeperDao.updateshop(shop);


		return true;
	}

	@Override
	public List<Goods> showgoods() {


		return shopkeeperDao.showgoods();
	}

	@Override
	public void addgoods(Goods goods) {

		shopkeeperDao.addgoods(goods);


	}

	@Override
	public void delgoods(ArrayList<Goods> listgoods, String contextPath) {
		shopkeeperDao.delgoods(listgoods,contextPath);
	}

	@Override
	public List<Goodstype> showgoodstype() {


		return shopkeeperDao.showgoodstype();
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
