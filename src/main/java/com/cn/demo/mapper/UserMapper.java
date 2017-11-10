package com.cn.demo.mapper;

import com.cn.demo.model.User;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@EntityScan("/userMapper")
public interface UserMapper{
    public User findUserInfo();
    public User findUserById(int id);
    public User findUsernameAndPassword(String name,String password);
}
