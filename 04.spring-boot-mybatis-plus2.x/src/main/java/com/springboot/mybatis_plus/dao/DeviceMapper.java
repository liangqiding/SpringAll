package com.springboot.mybatis_plus.dao;

import com.springboot.mybatis_plus.domain.Device;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author QiDing
 * @since 2020-06-08
 */
@Mapper
public interface DeviceMapper extends BaseMapper<Device> {

}
