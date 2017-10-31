package com.owen.controller;

import com.owen.entity.Goods;
import com.owen.entity.Goodstype;
import com.owen.entity.Shop;
import com.owen.util.UUIDBuilder;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.owen.entity.Shopkeeper;
import com.owen.service.ShopKeeperService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "/shopkeeper")
public class ShopController {

    @Autowired
    private ShopKeeperService shopKeeperService;

    @RequestMapping(value = "/shopkeeperreg")
    public String userReg() {
        return "shopkeeperreg";
    }

    @RequestMapping(value = "/shopkeeperlogin")
    public String userlogin() {

        return "shopkeeperlogin";
    }

    @RequestMapping(value = "/shopkeeperResetPwd")
    public String userResetPwd() {
        return "shopkeeperResetPwd";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Shopkeeper userlogin(Shopkeeper shopkeeper, HttpServletRequest request, HttpServletResponse response) {

        Shopkeeper ss = shopKeeperService.login(shopkeeper);
        if (ss != null) {

            System.out.println("login success!!!!!");

            request.getSession().setAttribute("username", shopkeeper.getShopkeepername());

            request.getSession().setAttribute("shopkeeperid", ss.getShopkeeperid());

            return ss;

        } else {
            System.out.println("login failed!!!!!");
            request.getSession().setAttribute("username", null);
            request.getSession().setAttribute("shopkeeperid", null);
            return null;
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Shopkeeper userRegister(Shopkeeper shopkeeper) {

        if (shopKeeperService.register(shopkeeper)) {

            System.out.println("register success!!!");
            return shopkeeper;

        } else {
            System.out.println("register failed!!!");
            return null;

        }

    }


    @RequestMapping(value = "/showshop", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> showshop(HttpServletRequest request, HttpServletResponse response) {

        String name = (String) request.getSession().getAttribute("username");
        String shopkeeperid = (String) request.getSession().getAttribute("shopkeeperid");

        if (name != null) {


            Shop shop = shopKeeperService.findshop(shopkeeperid);


            Map<String, Object> map = new HashMap<String, Object>();

            map.put("username", name);
            map.put("shopname", shop.getShopname());
            map.put("shoptel", shop.getShoptel());
            map.put("shopemail", shop.getShopemail());
            map.put("shopaddress", shop.getShopaddress());
            map.put("shopdescript", shop.getShopdescript());
            map.put("shopimagename", shop.getShopimagename());
            map.put("shopnotice", shop.getShopnotice());


            return map;
        } else {

            System.out.println("session username is null");

            return null;
        }


    }

    @RequestMapping(value = "/updateshop")
    @ResponseBody
    public String updateshop(@RequestParam(value = "file", required = false) MultipartFile file,
                             String shoptel,
                             String shopemail,
                             String shopaddress,
                             String shopdescript,
                             String shopnotice,

                             HttpServletRequest request
    ) throws IOException {

        String shopkeeperid = (String) request.getSession().getAttribute("shopkeeperid");
        Shop shop = shopKeeperService.findshop(shopkeeperid);

        shop.setShopdescript(shopdescript);
        shop.setShoptel(shoptel);
        shop.setShopemail(shopemail);
        shop.setShopaddress(shopaddress);
        shop.setShopnotice(shopnotice);


        if (!file.isEmpty()) {

            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String str = sdf.format(date);

            // String message = System.currentTimeMillis() + file.getOriginalFilename();//现在的文件名是时间戳加原文件名，出现图片相同时，读取不出来的bug
            String message = str + file.getOriginalFilename();
            String realPath = request.getSession().getServletContext().getRealPath("/uploadshoplogo/");//将文件保存在当前工程下的一个upload文件

            System.out.println(realPath + message);

            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPath, message));

            String logosrc = "uploadshoplogo/" + message;

            //提交的数据用实体类保存

            shop.setShopimagename(logosrc);

        }
        shopKeeperService.updateshop(shop);
        return "yes";
    }


    @RequestMapping(value = "/showshopgoods", method = RequestMethod.GET)
    @ResponseBody
    public List<Goods> showshopgoods() {


        return shopKeeperService.showgoods();

    }


    @RequestMapping(value = "/showgoodstype", method = RequestMethod.GET)
    @ResponseBody
    public List<Goodstype> showgoodstype() {

        return shopKeeperService.showgoodstype();


    }


    @RequestMapping(value = "/addgoods")
    @ResponseBody
    public String addgoods(@RequestParam(value = "file_modal", required = false) MultipartFile file,
                           String goodsname,
                           String goodsdescript,
                           Double goodsprice,
                           String goodscount,
                           String goodstype,
                           HttpServletRequest request
    ) throws IOException {

        if (file.isEmpty()) {
            System.out.println("file is null!!!!");
            return "no";
        } else {

            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String str = sdf.format(date);
            String message = str+ file.getOriginalFilename();//现在的文件名是时间戳加原文件名，出现图片相同时，读取不出来的bug
            String realPath = request.getSession().getServletContext().getRealPath("/uploadshoplogo/");//将文件保存在当前工程下的一个upload文件

            //System.out.println(realPath + message);

            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPath, message));

            String logosrc = "uploadshoplogo/" + message;

            Goods goods = new Goods();

            goods.setGoodsid(UUIDBuilder.getUUID());
            goods.setGoodsname(goodsname);
            goods.setGoodscount(Integer.parseInt(goodscount));
            goods.setGoodsdescript(goodsdescript);
            goods.setGoodsimagename(logosrc);
            goods.setGoodstype(goodstype);
            goods.setGoodsprice(goodsprice);

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            goods.setGoodsdate(timestamp);

            shopKeeperService.addgoods(goods);

            return "yes";

        }

    }


    @RequestMapping(value = "/delgoods")
    @ResponseBody
    public String delgoods(@RequestBody ArrayList<Goods> listgoods, HttpServletRequest request) {

        String contextPath = request.getServletContext().getRealPath("/");
        //System.out.println("contextPath:" + contextPath);

        shopKeeperService.delgoods(listgoods, contextPath);

        return "yes";

    }
}
