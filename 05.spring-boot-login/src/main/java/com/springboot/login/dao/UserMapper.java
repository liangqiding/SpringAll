package com.springboot.login.dao;

import com.springboot.login.domain.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author QiDing
 * @since 2020-06-13
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> findAll();

    /**
     * @param user
     * @return int
     */
    Integer checkAccount(User user);

    Integer checkAccountByUsername(String username);

}
