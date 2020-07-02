package spring.boot.pagehelper.domain;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
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
 * @since 2020-07-01
 */
@TableName("qd_cart")
@Accessors(chain = true)
@Data
public class QdCart extends Model<QdCart> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "cart_id", type = IdType.AUTO)
    private Integer cartId;
    /**
     * 商品名
     */
    @TableField("cart_name")
    private String cartName;
    /**
     * 时间
     */
    @TableField("cart_time")
    private Date cartTime;
    /**
     * 状态
     */
    @TableField("cart_status")
    private String cartStatus;
    /**
     * 数量
     */
    @TableField("cart_sum")
    private Integer cartSum;
    /**
     * 价格
     */
    @TableField("cart_price")
    private BigDecimal cartPrice;
    /**
     * 关联 d_order表
     */
    @TableField("order_id")
    private Integer orderId;



    @Override
    protected Serializable pkVal() {
        return this.cartId;
    }

}
