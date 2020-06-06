package com.springboot.springbootmybatis.service.imp;

import com.springboot.springbootmybatis.dao.UserMapper;
import com.springboot.springbootmybatis.domain.User;
import com.springboot.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2020/5/30/030 10:48
 * @descriptio
 */
@Service
public class UserServiceImp implements UserService {
@Autowired
    UserMapper userMapper;


    @Override
    public List<User> fineAll() {
        return null;
    }

    @Override
    public int updateUser(User user) {
        List<User> users = userMapper.fineAll();
        User user1 = users.get(1);
        user1.setUsername("test");
         userMapper.updateUser(user1);
        return userMapper.updateUser(user1);
    }

    @Override
    public int delUser(Integer id) {
        return 0;
    }

    @Override
    public int InsertUser(User user) {
        return 0;
    }
}
