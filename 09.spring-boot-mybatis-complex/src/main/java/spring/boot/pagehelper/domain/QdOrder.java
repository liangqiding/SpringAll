package spring.boot.pagehelper.domain;

import com.baomidou.mybatisplus.enums.IdType;
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
@TableName("qd_order")
public class QdOrder extends Model<QdOrder> {

    private static final long serialVersionUID = 1L;

    /**
     * 订单号
     */
    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;
    /**
     * 日期
     */
    @TableField("order_time")
    private Date orderTime;
    /**
     * 状态
     */
    @TableField("order_status")
    private String orderStatus;
    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer userId;


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    protected Serializable pkVal() {
        return this.orderId;
    }

    @Override
    public String toString() {
        return "QdOrder{" +
        ", orderId=" + orderId +
        ", orderTime=" + orderTime +
        ", orderStatus=" + orderStatus +
        ", userId=" + userId +
        "}";
    }
}
