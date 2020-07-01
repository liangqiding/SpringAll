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
@TableName("maintain_unusual")
public class MaintainUnusual extends Model<MaintainUnusual> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "maintain_unusual_id", type = IdType.AUTO)
    private Integer maintainUnusualId;
    /**
     * 异常说明
     */
    @TableField("unusual_info")
    private String unusualInfo;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 是否已经解决
     */
    @TableField("unusual_status")
    private String unusualStatus;
    /**
     * 异常类型
     */
    @TableField("unusual_type")
    private String unusualType;
    /**
     * 创建人id
     */
    @TableField("create_user_id")
    private Integer createUserId;
    /**
     * 处理人id
     */
    @TableField("handle_user_id")
    private Integer handleUserId;
    /**
     * 处理时间
     */
    @TableField("handle_time")
    private Date handleTime;
    /**
     * 处理原因说明
     */
    @TableField("handle_info")
    private String handleInfo;
    /**
     * 维保单号
     */
    @TableField("maintain_id")
    private Integer maintainId;


    public Integer getMaintainUnusualId() {
        return maintainUnusualId;
    }

    public void setMaintainUnusualId(Integer maintainUnusualId) {
        this.maintainUnusualId = maintainUnusualId;
    }

    public String getUnusualInfo() {
        return unusualInfo;
    }

    public void setUnusualInfo(String unusualInfo) {
        this.unusualInfo = unusualInfo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUnusualStatus() {
        return unusualStatus;
    }

    public void setUnusualStatus(String unusualStatus) {
        this.unusualStatus = unusualStatus;
    }

    public String getUnusualType() {
        return unusualType;
    }

    public void setUnusualType(String unusualType) {
        this.unusualType = unusualType;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getHandleUserId() {
        return handleUserId;
    }

    public void setHandleUserId(Integer handleUserId) {
        this.handleUserId = handleUserId;
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    public String getHandleInfo() {
        return handleInfo;
    }

    public void setHandleInfo(String handleInfo) {
        this.handleInfo = handleInfo;
    }

    public Integer getMaintainId() {
        return maintainId;
    }

    public void setMaintainId(Integer maintainId) {
        this.maintainId = maintainId;
    }

    @Override
    protected Serializable pkVal() {
        return this.maintainUnusualId;
    }

    @Override
    public String toString() {
        return "MaintainUnusual{" +
        ", maintainUnusualId=" + maintainUnusualId +
        ", unusualInfo=" + unusualInfo +
        ", createTime=" + createTime +
        ", unusualStatus=" + unusualStatus +
        ", unusualType=" + unusualType +
        ", createUserId=" + createUserId +
        ", handleUserId=" + handleUserId +
        ", handleTime=" + handleTime +
        ", handleInfo=" + handleInfo +
        ", maintainId=" + maintainId +
        "}";
    }
}
