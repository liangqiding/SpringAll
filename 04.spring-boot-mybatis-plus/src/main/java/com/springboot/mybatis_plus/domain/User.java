package com.springboot.mybatis_plus.domain;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 梁其定
 * @since 2020-06-04
 */
@TableName("user")
@Data
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;
    @TableField("user_account")
    private String userAccount;
    @TableField("user_passwd")
    private String userPasswd;
    @TableField("user_name")
    private String userName;
    @TableField("user_mail")
    private String userMail;
    @TableField("user_lv")
    private Integer userLv;
    @TableField("user_enable")
    private Integer userEnable;
    @TableField("user_create_datetime")
    private Date userCreateDatetime;
    @TableField("user_phone")
    private String userPhone;

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

    @Override
    public String toString() {
        return "User{" +
        ", userId=" + userId +
        ", userAccount=" + userAccount +
        ", userPasswd=" + userPasswd +
        ", userName=" + userName +
        ", userMail=" + userMail +
        ", userLv=" + userLv +
        ", userEnable=" + userEnable +
        ", userCreateDatetime=" + userCreateDatetime +
        ", userPhone=" + userPhone +
        "}";
    }
}
