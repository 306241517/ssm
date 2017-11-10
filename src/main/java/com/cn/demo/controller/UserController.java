package com.cn.demo.controller;


import com.cn.demo.model.User;
import com.cn.demo.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {


    private Logger logger=Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    /**
     * http://localhost:8080/getUserInfo
     */
    public User getUserInfo(){
        User user=userService.getUserInfo();
        if(user!=null){
            System.out.println("user.getName()"+user);
        }
        return user;
    }

}
