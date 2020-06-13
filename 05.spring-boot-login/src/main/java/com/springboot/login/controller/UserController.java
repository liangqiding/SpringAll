package com.springboot.login.controller;



import com.springboot.login.domain.User;
import com.springboot.login.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author QiDing
 * @since 2020-06-13
 */
@Controller
public class UserController {
@Autowired
    UserServiceImpl userService;
    @RequestMapping("/")
    public String login() {
        return "login";
    }
    @RequestMapping("/login")
    public String doLogin(String username, String password, Model model) {
        System.out.println(username+","+password);
        if (userService.checkAccount(new User().setUsername(username).setPassword(password))) {
            return "success";
        }
        model.addAttribute("msg","账号or密码ERROR");
        return "login";
    }
}

