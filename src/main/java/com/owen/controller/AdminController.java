package com.owen.controller;


import com.owen.entity.Shop;
import com.owen.entity.Shoptype;
import com.owen.util.MD5Builder;
import com.owen.util.UUIDBuilder;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.owen.entity.Admin;
import com.owen.service.AdminService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping(value = "/admin")
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;


    @RequestMapping(value = "/adminloginpage")
    public String adminLoginPage() {
        return "adminlogin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Admin adminLogin(Admin admin) {


        if (adminService.login(admin) != null) {

            System.out.println("admin login success!!!!");

            return admin;
        } else {
            System.out.println("admin login failed!!!!");
            return null;
        }

    }

    @RequestMapping(value = "/showshoptype", method = RequestMethod.GET)
    @ResponseBody
    public List<Shoptype> showshoptype() {

        List<Shoptype> shoptypeList = adminService.showshoptype();

        if (shoptypeList.isEmpty()) {
            return null;
        } else {
            return shoptypeList;
        }
    }

    @RequestMapping(value = "/addshoptype", method = RequestMethod.POST)
    @ResponseBody
    public void addshoptypename(Shoptype typename) {


        System.out.println("新增的类型：" + typename.getShoptypename());


        adminService.addshoptype(typename);
    }

    @RequestMapping(value = "/delshoptype", method = RequestMethod.POST)
    @ResponseBody
    public void delshoptypename(@RequestBody ArrayList<String> list) {


        for (String ss : list
                ) {

            System.out.println(ss + " ");

        }


        adminService.delshoptype(list);


    }

    @RequestMapping(value = "/addshop")
    @ResponseBody
    public String addshop(@RequestParam(value = "file", required = false) MultipartFile file,
                          String shopname,
                          String typeselect,
                          String shoptel,
                          String shopmail,
                          String shopaddress,
                          String shopdetail,
                          HttpServletRequest request
    ) throws IOException {


        if (file.isEmpty()) {
            System.out.println("file is null!!!!");
            return "no";
        } else {
            String message = System.currentTimeMillis() + file.getOriginalFilename();//现在的文件名是时间戳加原文件名，出现图片相同时，读取不出来的bug
            String realPath = request.getSession().getServletContext().getRealPath("/uploadshoplogo/");//将文件保存在当前工程下的一个upload文件

            System.out.println(realPath + message);

            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPath, message));

            String logosrc = "uploadshoplogo/" + message;


            //提交的数据用实体类保存
            Shop shop = new Shop();
            shop.setShopid(UUIDBuilder.getUUID());
            shop.setShopname(shopname);
            shop.setShopimagename(logosrc);
            shop.setShopdescript(shopdetail);
            shop.setShoptel(shoptel);
            shop.setShopemail(shopmail);
            shop.setShopaddress(shopaddress);
            shop.setShoptypename(typeselect);
            //进入service层
            adminService.addshop(shop);
            return "yes";
        }

    }


    @RequestMapping(value = "/showshop", method = RequestMethod.GET)
    @ResponseBody
    public List<Shop> showshop(HttpServletRequest request) {


        List<Shop> shop = adminService.showshop();
        String realPath = request.getSession().getServletContext().getRealPath("/uploadshoplogo/");

        System.out.println("realPath:" + realPath);


        if (shop.isEmpty()) {

            return null;
        } else {

//
//            for (Shop ss : shop
//                    ) {
//                System.out.println(ss.getShopname() + " " + ss.getShopimagename() + " " + ss.getShoptypeByShoptypename().getShoptypename());
//            }


            return shop;

        }

    }

    @RequestMapping(value = "/delshop", method = RequestMethod.POST)
    @ResponseBody
    public void delshop(@RequestBody ArrayList<Shop> listshop, HttpServletRequest request) {


//        for (Shop ss : listshop
//                ) {
//
//            System.out.println(ss.getShopname()+ " "+ss.getShopemail()+" "+ss.getShopaddress());
//
//        }

        String contextPath = request.getServletContext().getRealPath("/");
        System.out.println("contextPath:" + contextPath);

        adminService.delshop(listshop, contextPath);


    }

    @RequestMapping(value = "/updateshop")
    @ResponseBody
    public String updateshop(@RequestParam(value = "file_modal", required = false) MultipartFile file,
                             String shopid,
                             String shopname,
                             String typeselect,
                             String shoptel,
                             String shopaddress,
                             String shopemail,
                             HttpServletRequest request
    ) throws IOException {

        //  String shopkeeperid = (String) request.getSession().getAttribute("shopkeeperid");

        Shop shop = adminService.findshop(shopid);

        shop.setShopname(shopname);
        shop.setShoptel(shoptel);
        shop.setShopemail(shopemail);
        shop.setShopaddress(shopaddress);
        shop.setShoptypename(typeselect);
        //Shoptype shoptype = new Shoptype();
       // shoptype.setShoptypename(typeselect);

        // shop.setShoptypeByShoptypename(shoptype);

        if (!file.isEmpty()) {

            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String str = sdf.format(date);


            String message = str + file.getOriginalFilename();//现在的文件名是时间戳加原文件名，出现图片相同时，读取不出来的bug
            String realPath = request.getSession().getServletContext().getRealPath("/uploadshoplogo/");//将文件保存在当前工程下的一个upload文件

            System.out.println(realPath + message);

            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPath, message));

            String logosrc = "uploadshoplogo/" + message;

            //提交的数据用实体类保存

            shop.setShopimagename(logosrc);

        }
        adminService.updateshop(shop);
        return "yes";
    }
}
