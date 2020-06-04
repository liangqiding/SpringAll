package com.springboot.mybatis_plus.dao;

import com.springboot.mybatis_plus.domain.ProductCode;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 梁其定
 * @since 2020-06-04
 */
@Mapper
public interface ProductCodeMapper extends BaseMapper<ProductCode> {
       List<ProductCode> selectList();
}
