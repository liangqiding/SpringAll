package com.springboot.springbootmybatis;




import com.springboot.springbootmybatis.dao.UserMapper;
import com.springboot.springbootmybatis.domain.User;
import com.springboot.springbootmybatis.service.UserService;
import com.springboot.springbootmybatis.service.imp.UserServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootMybatisApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserServiceImp userServiceImp;
//    public SpringBootMybatisApplicationTests(UserMapper userMapper) {
//        this.userMapper=userMapper;
//    }

    @Test
    void contextLoads() {
//        System.out.println(userMapper);
        int i = userServiceImp.updateUser(null);
    }

    @Test
    void UserMapper_fillAll() {

        List<User> users = userMapper.fineAll();
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
