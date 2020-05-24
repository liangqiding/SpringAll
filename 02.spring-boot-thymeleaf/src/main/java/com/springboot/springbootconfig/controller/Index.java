package com.springboot.springbootconfig.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2020/5/24/024 10:29
 * @descriptio
 */
@Controller
public class Index {

    /**
     * @Author : 梁其定
     * @Date : 2020/5/24/024 10:30
     * @Description : TODO thymeleaf 使用
     * @params:
     * @Return :
     */
    @RequestMapping("/")
    public String thymeleaf(Model model,HttpSession session) {
        model.addAttribute("msg", "Hello thymeleaf");
        session.setAttribute("session", "Hello session");

        return "index";
    }

    @RequestMapping("/home")
    public String home(Model model) {
        return "home";
    }
}
