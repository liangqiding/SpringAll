package com.springboot.mybatis_plus.domain;

import com.baomidou.mybatisplus.enums.IdType;
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
@TableName("device")
@Data
@Accessors(chain = true)
public class Device extends Model<Device> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "device_id", type = IdType.AUTO)
    private Integer deviceId;
    @TableField("device_name")
    private String deviceName;
    @TableField("device_Type")
    private String deviceType;
    @TableField("device_info")
    private String deviceInfo;
    @TableField("device_version")
    private String deviceVersion;


    @Override
    protected Serializable pkVal() {
        return this.deviceId;
    }

}
