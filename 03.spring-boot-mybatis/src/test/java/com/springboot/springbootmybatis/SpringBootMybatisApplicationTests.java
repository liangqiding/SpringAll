package com.springboot.springbootmybatis;

import com.springboot.springbootmybatis.dao.UserMapper;
import com.springboot.springbootmybatis.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootMybatisApplicationTests {
    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void UserMapper_fillAll() {
        User user = userMapper.fineAll();
        System.out.println(user);
    }
    @Test
    void UserMapper_update() {

        User user = new User();
        user.setId(1);
        user.setDate("2020.05.24");
        user.setName("admin");
        user.setUsername("llll");
        user.setPassword("123456");
        System.out.println(userMapper.updateUser(user));
    }
    @Test
    void UserMapper_delete() {
        System.out.println(userMapper.delUser(2));
    }

    @Test
    void UserMapper_insert() {
        User user = new User();
        user.setDate("2020.05.24");
        user.setName("aaa");
        user.setUsername("llll");
        user.setPassword("123456");
        int i = userMapper.InsertUser(user);
        System.out.println(i);
    }
}
