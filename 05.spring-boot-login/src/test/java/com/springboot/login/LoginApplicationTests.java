package com.springboot.login;

import com.springboot.login.dao.UserMapper;
import com.springboot.login.domain.User;
import com.springboot.login.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LoginApplicationTests {
@Autowired
    UserServiceImpl userService;

@Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
        System.out.println();
    }
    @Test
     void Test() {
        List<User> all = userMapper.findAll();
        System.out.println(all);
    }

    @Test
     void Check() {
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    }

}
