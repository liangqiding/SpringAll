package com.springboot.mybatis_plus.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.springboot.mybatis_plus.domain.UserDevice;
import com.springboot.mybatis_plus.dao.UserDeviceMapper;
import com.springboot.mybatis_plus.service.UserDeviceService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author QiDing
 * @since 2020-06-08
 */
@Service
public class UserDeviceServiceImpl extends ServiceImpl<UserDeviceMapper, UserDevice> implements UserDeviceService {

    @Override
    public List<UserDevice> selectList(Wrapper<UserDevice> wrapper) {

        super.selectList(wrapper);
        return super.selectList(wrapper);
    }
}
