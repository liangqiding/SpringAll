package com.springboot.mybatis_plus.service.impl;

import com.springboot.mybatis_plus.domain.ProductCode;
import com.springboot.mybatis_plus.dao.ProductCodeMapper;
import com.springboot.mybatis_plus.service.ProductCodeService;
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
public class ProductCodeServiceImpl extends ServiceImpl<ProductCodeMapper, ProductCode> implements ProductCodeService {

}
