package com.springboot.login.service.impl;

import com.springboot.login.domain.User;
import com.springboot.login.dao.UserMapper;
import com.springboot.login.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author QiDing
 * @since 2020-06-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public boolean checkAccount(User user) {
        Integer integer = userMapper.checkAccount(user);
        if (integer>0){
            return true;
        }
        return false;
    }
}
