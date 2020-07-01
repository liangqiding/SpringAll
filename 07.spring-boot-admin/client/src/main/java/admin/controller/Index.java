package admin.controller;


import admin.config.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: QiDing
 * @DateTime: 2020/6/24 0024 8:54
 * @Description: TODO
 */
@RestController
public class Index {
   private final static Logger logger= LoggerFactory.getLogger(Index.class);
    @GetMapping("/get")
    public String getMsg() {
        logger.info("getMsg success");
        return "getMsg success";
    }

    @GetMapping("/test")
    public String error() {
        logger.error("error 模拟");
        ResponseResult<Object> objectResponseResult = new ResponseResult<>(200,"","");
        return "test error ";
    }

    @PostMapping("/post")
    public String postMsg() {
        logger.info("postMsg success");
        return "postMsg success";
    }

    @DeleteMapping("/delete")
    public String deleteMsg() {
        logger.info("deleteMsg success");
        return "deleteMsg success";
    }

    @PutMapping
    public String PutMsg() {
        logger.info("PutMsg success");
        return "PutMsg success";
    }
}
