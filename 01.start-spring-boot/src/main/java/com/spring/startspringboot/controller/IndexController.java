package com.spring.startspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2020/5/23/023 12:00
 * @descriptio
 */
@Controller
public class IndexController {
    /**
     * @Author : 梁其定
     * @Date : 2020/5/23/023 12:01
     * @Description : TODO
     * @params:
     * @Return : hello work
     */
    @RequestMapping("/index")
    public String index() {
        return "index.html";
    }

    @RequestMapping("/")
    @ResponseBody
    public String get() {
        return "hello work";
    }

}
