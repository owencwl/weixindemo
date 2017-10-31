package com.owen.controller;

import javax.json.Json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.owen.entity.User;
import com.owen.service.UserService;
import com.owen.service.impl.UserServiceImpl;

@RequestMapping(value = "/user")
@Controller
public class UserController {



    @RequestMapping(value = "/showshop/shop")
    public String showshop(String shopid){



        return "shop";
    }

	
	
}
