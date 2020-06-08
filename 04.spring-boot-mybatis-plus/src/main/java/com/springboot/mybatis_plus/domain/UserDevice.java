package com.springboot.mybatis_plus.domain;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author QiDing
 * @since 2020-06-08
 */
@TableName("user_device")
@Data
@Accessors(chain = true)
public class UserDevice extends Model<UserDevice> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_device_id", type = IdType.AUTO)
    private Integer userDeviceId;
    @TableField("user_id")
    private Integer userId;
    @TableField("device_id")
    private Integer deviceId;



    @Override
    protected Serializable pkVal() {
        return this.userDeviceId;
    }

}
