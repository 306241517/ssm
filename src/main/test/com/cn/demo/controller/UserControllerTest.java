package com.cn.demo.controller;

import com.cn.demo.model.User;
import com.cn.demo.service.UserService;
import junit.framework.TestCase;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


public class UserControllerTest extends TestCase {


    @Autowired
    private UserService userService;
    public void testGetUserInfo() throws Exception {
        User user=new User();
        user=userService.getUserInfo();
        System.out.println(user.toString());
    }

}