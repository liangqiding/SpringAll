package com.springboot.springbootmybatis.dao;

import com.springboot.springbootmybatis.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2020/5/24/024 11:17
 * @descriptio
 */
@Mapper
public interface UserMapper {

       List<User> fineAll();
       int updateUser(User user);
       int delUser(Integer id);
       int InsertUser(User user);

}
