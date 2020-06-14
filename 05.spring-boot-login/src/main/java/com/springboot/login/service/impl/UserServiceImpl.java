package com.springboot.login.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.springboot.login.domain.User;
import com.springboot.login.dao.UserMapper;
import com.springboot.login.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import javafx.scene.chart.PieChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
    public boolean insert(User user) {
        if (user.getPassword()==null||user.getUsername()==null||
                user.getPassword().equals("")||user.getUsername().equals("")){
            return false;
        }else {
            Date date = new Date();
            user.setDate(date);
            return super.insert(user);
        }
    }

    @Override
    public boolean checkAccount(User user) {
        Integer integer = userMapper.checkAccount(user);
        if (integer>0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean checkAccountByUsername(String username) {
        // todo 判断用户是否存在
        if ( userMapper.checkAccountByUsername(username)>0) {
            return false;
        }
        return true;
    }
}
