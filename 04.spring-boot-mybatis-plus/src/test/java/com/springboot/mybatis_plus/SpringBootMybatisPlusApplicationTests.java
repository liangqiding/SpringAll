package com.springboot.mybatis_plus;

import com.springboot.mybatis_plus.dao.UserMapper;
import com.springboot.mybatis_plus.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootMybatisPlusApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Test
    void test() {
        List<User> all = userMapper.findAll();
        System.out.println(all);
    }

}
