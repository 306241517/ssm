package com.cn.demo.mapper;

import com.cn.demo.model.User;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserMapperTest extends TestCase {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private UserMapper userMapper;

    @Test
    public void testFindUserInfo() throws Exception {
        User user=new User();
        user=userMapper.findUserInfo();
        System.out.println(user.toString());
    }


    @Test
    public void testFindUserById()throws Exception{
        User user=new User();
        int id=1;
        user=userMapper.findUserById(id);
        System.out.println("user对象中的所有的值："+user.toString());

    }

}