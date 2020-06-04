package com.springboot.mybatis_plus.controller;


import com.springboot.mybatis_plus.dao.ProductCodeMapper;
import com.springboot.mybatis_plus.domain.ProductCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 梁其定
 * @since 2020-06-04
 */
@Controller
public class UserController {
    @Autowired
    ProductCodeMapper productCodeMapper;
    @RequestMapping("/")
    public String test() {
        System.out.println(1);
        return "index";
    }
    @RequestMapping("/getProduct_codeList")
    @ResponseBody
    public List<ProductCode> getProduct_codeList() {
        return productCodeMapper.selectList();
    }

}

