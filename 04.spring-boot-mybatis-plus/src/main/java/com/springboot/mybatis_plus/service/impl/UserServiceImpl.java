package com.springboot.mybatis_plus.service.impl;

import com.springboot.mybatis_plus.domain.User;
import com.springboot.mybatis_plus.dao.UserMapper;
import com.springboot.mybatis_plus.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 梁其定
 * @since 2020-06-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
