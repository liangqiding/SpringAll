package com.springboot.springbootmybatis.domain;

import lombok.Data;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2020/5/24/024 11:23
 * @descriptio
 */

@Data
public class User {
    private Integer id;
    private String name;
    private String username;
    private String date;
    private String password;
}
