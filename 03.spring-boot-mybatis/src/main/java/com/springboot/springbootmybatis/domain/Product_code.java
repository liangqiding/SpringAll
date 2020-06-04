package com.springboot.springbootmybatis.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: 梁其定
 * @DateTime: 2020/6/4 0004 11:08
 * @Description: TODO
 */
@Data
@Accessors(chain = true)
public class Product_code {
    private Integer product_key;
    private String tag;
    private String code;
    private Integer count;
}
