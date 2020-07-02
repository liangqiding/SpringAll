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


    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public String getCartName() {
        return cartName;
    }

    public void setCartName(String cartName) {
        this.cartName = cartName;
    }

    public Date getCartTime() {
        return cartTime;
    }

    public void setCartTime(Date cartTime) {
        this.cartTime = cartTime;
    }

    public String getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(String cartStatus) {
        this.cartStatus = cartStatus;
    }

    public Integer getCartSum() {
        return cartSum;
    }

    public void setCartSum(Integer cartSum) {
        this.cartSum = cartSum;
    }

    public BigDecimal getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(BigDecimal cartPrice) {
        this.cartPrice = cartPrice;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    protected Serializable pkVal() {
        return this.cartId;
    }

    @Override
    public String toString() {
        return "QdCart{" +
        ", cartId=" + cartId +
        ", cartName=" + cartName +
        ", cartTime=" + cartTime +
        ", cartStatus=" + cartStatus +
        ", cartSum=" + cartSum +
        ", cartPrice=" + cartPrice +
        ", orderId=" + orderId +
        "}";
    }
}
