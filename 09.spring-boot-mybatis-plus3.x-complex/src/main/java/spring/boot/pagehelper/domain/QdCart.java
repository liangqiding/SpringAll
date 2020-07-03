package spring.boot.pagehelper.domain;

import java.math.BigDecimal;
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
public class QdCart extends Model<QdCart> {

    private static final long serialVersionUID=1L;

      @TableId(value = "cart_id", type = IdType.AUTO)
    private Integer cartId;

    /**
     * 商品名
     */
    private String cartName;

    /**
     * 时间
     */
    private Date cartTime;

    /**
     * 状态
     */
    private String cartStatus;

    /**
     * 数量
     */
    private Integer cartSum;

    /**
     * 价格
     */
    private BigDecimal cartPrice;

    /**
     * 关联 d_order表
     */
    private Integer orderId;

    /**
     * 买家id
     */
    private Integer userId;

    /**
     * 卖家id
     */
    private Integer cartUserId;


    @Override
    protected Serializable pkVal() {
        return this.cartId;
    }

}
