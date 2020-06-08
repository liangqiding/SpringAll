package com.springboot.mybatis_plus;

import com.springboot.mybatis_plus.dao.UserMapper;

import com.springboot.mybatis_plus.domain.User;
import com.springboot.mybatis_plus.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class SpringBootMybatisPlusApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserServiceImpl userService;
    @Test
    void test() {
        List<User> all = userMapper.findAll();
        System.out.println(all);
        User user = userService.selectById(1);
        Date date = user.getDate();
        //        24小时制
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(date);
        System.out.println(format);
    }

}
