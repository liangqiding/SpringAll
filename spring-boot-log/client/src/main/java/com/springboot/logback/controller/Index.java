package com.springboot.logback.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: QiDing
 * @DateTime: 2020/6/8 0008 11:21
 * @Description: TODO
 */
@RestController
public class Index {
    private static final Logger logger = LoggerFactory.getLogger(Index.class);
    @RequestMapping("/")
    public void test() {

        System.out.println("测试");
        logger.info("测试");
    }

    @RequestMapping("/send")
    public void send() {
        logger.info("info");
        logger.warn("warn>>>>>>>>>>"+"测试");
        logger.error("error>>>>>>>>>>"+"测试");
    }

}
