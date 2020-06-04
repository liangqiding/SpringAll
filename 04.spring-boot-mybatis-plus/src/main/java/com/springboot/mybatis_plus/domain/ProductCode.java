package com.springboot.mybatis_plus.domain;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 梁其定
 * @since 2020-06-04
 */
@TableName("product_code")
public class ProductCode extends Model<ProductCode> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "product_key", type = IdType.AUTO)
    private Integer productKey;
    private String tag;
    private String code;
    private Integer count;


    public Integer getProductKey() {
        return productKey;
    }

    public void setProductKey(Integer productKey) {
        this.productKey = productKey;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    protected Serializable pkVal() {
        return this.productKey;
    }

    @Override
    public String toString() {
        return "ProductCode{" +
        ", productKey=" + productKey +
        ", tag=" + tag +
        ", code=" + code +
        ", count=" + count +
        "}";
    }
}
