package com.springboot.logger_file.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @Author: QiDing
 * @DateTime: 2020/6/8 0008 11:46
 * @Description: TODO
 */

@RestController
public class Index {

    private static final Logger logger = LoggerFactory.getLogger(Index.class);

    @RequestMapping("/info")
    public String info() {
           logger.info("info 日记打印");
        return "success";
    }
    @RequestMapping("/err")
    public String error() {
           logger.error("error 日记打印");
        return "success";
    }





    @RequestMapping("log")
    public void log(HttpServletRequest httpServletRequest) throws IOException {
        logger.info(httpServletRequest.toString());
        BufferedReader bufferedReader = httpServletRequest.getReader();
        String str, wholeStr = "";
        while ((str = bufferedReader.readLine()) != null) {
            wholeStr += str;
        }
        System.out.println("logger>>>>>>>>>>>>>>>>>>>>>>>" + wholeStr);
        if (wholeStr.contains("DEBUG")) {
            logger.debug(wholeStr);
        } else if (wholeStr.contains("ERROR")) {
            logger.error(wholeStr);
        } else if (wholeStr.contains("WARN")) {
            logger.warn(wholeStr);
        } else {
            logger.info(wholeStr);
        }
    }

}
