package com.springboot.mybatis_plus.dao;

import com.springboot.mybatis_plus.domain.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author QiDing
 * @since 2020-06-08
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
       List<User> findAll();
}
