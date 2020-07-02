package spring.boot.pagehelper.domain;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
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
@TableName("qd_order")
@Accessors(chain = true)
@Data
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

    @TableField("order_user_id")
    private Integer orderUserId;

    @Override
    protected Serializable pkVal() {
        return this.orderId;
    }

}
