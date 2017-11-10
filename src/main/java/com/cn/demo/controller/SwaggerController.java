//package com.cn.demo.controller;
//
//import com.cn.demo.model.User;
//import com.wordnik.swagger.annotations.ApiOperation;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "/users")
//public class SwaggerController {
//
//    /**
//     * http://localhost:8080/swagger/index.html
//     */
//    @ApiOperation(value = "Get all users",notes = "requires noting")
//    @RequestMapping(method = RequestMethod.GET)
//    public List<User> getUsers(){
//        List<User> list=new ArrayList<User>();
//
//        User user =new User();
//        user.setName("hello");
//        list.add(user);
//
//        User user1=new User();
//        user.setName("world");
//        list.add(user1);
//        return list;
//    }
//    @ApiOperation(value = "Get all users",notes = "requires the id of user")
//    @RequestMapping(value = "/{name}",method = RequestMethod.GET)
//    public User getUserById(String name){
//        User user=new User();
//        user.setName("hello world");
//        return user;
//    }
//
//}
