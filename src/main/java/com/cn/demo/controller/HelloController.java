package com.cn.demo.controller;

import com.cn.demo.mapper.UserMapper;
import com.cn.demo.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/front/*")
public class HelloController {
    @Autowired
    private UserMapper userMapper;


    private Logger logger=Logger.getLogger(HelloController.class);

    /**
     * http://localtion:8080/hello?name=cn.7player
     */
    @RequestMapping("/hello")
    public String greeting(@RequestParam(value = "name",required =false, defaultValue="World") String name , Model model){
        logger.info("hello");
        model.addAttribute("name",name);
        return "hello";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/addregister")
    public String register(HttpServletRequest request){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String password2=request.getParameter("password2");
        if(password.equals(password2)){
            User user=new User();
            user.setName(username);
            user.setPassword(password);
            //userMapper.save(user);
            return "index";
        }else{
            return "register";
        }
    }
}
