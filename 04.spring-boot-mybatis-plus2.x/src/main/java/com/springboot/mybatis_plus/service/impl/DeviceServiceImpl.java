package com.springboot.mybatis_plus.service.impl;

import com.springboot.mybatis_plus.domain.Device;
import com.springboot.mybatis_plus.dao.DeviceMapper;
import com.springboot.mybatis_plus.service.DeviceService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author QiDing
 * @since 2020-06-08
 */
@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {

}
