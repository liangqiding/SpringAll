package com.springboot.springbootmybatis.service;

import com.springboot.springbootmybatis.domain.User;
import org.springframework.stereotype.Service;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2020/5/30/030 10:48
 * @descriptio
 */

public interface UserService {
    User fineAll();
    int updateUser(User user);
    int delUser(Integer id);
    int InsertUser(User user);
}
