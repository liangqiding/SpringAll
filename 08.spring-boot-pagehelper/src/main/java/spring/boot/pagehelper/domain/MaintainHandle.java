package spring.boot.pagehelper.domain;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author QiDing
 * @since 2020-06-30
 */
@TableName("maintain_handle")
@Data
public class MaintainHandle extends Model<MaintainHandle> {

    private static final long serialVersionUID = 1L;

    /**
     * 维保进度外键
     */
    @TableField("maintain_handle_id")
    private Integer maintainHandleId;
    /**
     * 处理时间
     */
    @TableField("handle_time")
    private Date handleTime;
    /**
     * 处理步骤（未开始->受理中->进行中->维保完成->待客户验收->已验收->维保单取消->异常）
     */
    @TableField("handle_step")
    private String handleStep;
    /**
     * 处理说明，进行中步骤（需包括处理人名和电话）
     */
    @TableField("handle_info")
    private String handleInfo;



    @Override
    protected Serializable pkVal() {
        return null;
    }

}
