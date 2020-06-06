package com.springboot.springbootmybatis.service.imp;

import com.springboot.springbootmybatis.domain.User;
import com.springboot.springbootmybatis.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2020/5/30/030 10:48
 * @descriptio
 */
@Service
public class UserServiceImp implements UserService {

    @Override
    public User fineAll() {
        return null;
    }

    @Override
    public int updateUser(User user) {
        return 0;
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
