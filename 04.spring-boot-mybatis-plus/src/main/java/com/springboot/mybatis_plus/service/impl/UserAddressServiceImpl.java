package com.springboot.mybatis_plus.service.impl;

import com.springboot.mybatis_plus.domain.UserAddress;
import com.springboot.mybatis_plus.dao.UserAddressMapper;
import com.springboot.mybatis_plus.service.UserAddressService;
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
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements UserAddressService {

}
