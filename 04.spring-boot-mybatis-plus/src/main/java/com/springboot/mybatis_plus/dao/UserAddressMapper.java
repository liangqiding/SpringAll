package com.springboot.mybatis_plus.dao;

import com.springboot.mybatis_plus.domain.UserAddress;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 梁其定
 * @since 2020-06-04
 */
@Mapper
public interface UserAddressMapper extends BaseMapper<UserAddress> {

}
