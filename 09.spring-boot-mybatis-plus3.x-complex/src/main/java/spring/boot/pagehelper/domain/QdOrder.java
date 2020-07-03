package spring.boot.pagehelper.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author qiDing
 * @since 2020-07-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class QdOrder extends Model<QdOrder> {

    private static final long serialVersionUID=1L;

    /**
     * 订单号
     */
      @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    /**
     * 日期
     */
    private Date orderTime;

    /**
     * 状态
     */
    private String orderStatus;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 卖家id
     */
    private Integer orderUserId;


    @Override
    protected Serializable pkVal() {
        return this.orderId;
    }

}
