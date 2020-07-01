package spring.boot.pagehelper.domain;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author QiDing
 * @since 2020-06-30
 */
@TableName("maintain_repair")
@Data
public class MaintainRepair extends Model<MaintainRepair> {

    private static final long serialVersionUID = 1L;

    /**
     * 维保单号
     */
    @TableId(value = "maintain_id", type = IdType.AUTO)
    private String maintainId;
    /**
     * 产品名
     */
    @TableField("product_name")
    private String productName;
    /**
     * 故障类型
     */
    @TableField("hitch_type")
    private String hitchType;
    /**
     * 故障说明
     */
    @TableField("hitch_info")
    private String hitchInfo;
    /**
     * 手机
     */
    @TableField("address_phone")
    private String addressPhone;
    /**
     * 图片或视频资源外键
     */
    @TableField("maintain_file_id")
    private Integer maintainFileId;
    /**
     * 省
     */
    @TableField("address_province")
    private String addressProvince;
    /**
     * 市
     */
    @TableField("address_city")
    private String addressCity;
    /**
     * 区
     */
    @TableField("address_town")
    private String addressTown;
    /**
     * 地址详情
     */
    @TableField("address_detailed")
    private String addressDetailed;
    /**
     * 邮编
     */
    @TableField("address_post")
    private String addressPost;
    /**
     * 是否被删除
     */
    @TableField("is_delete")
    private Integer isDelete;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;
    /**
     * 审核状态
     */
    @TableField("check_status")
    private Integer checkStatus;
    /**
     * 维保公司处理单号
     */
    @TableField("repair_order_id")
    private String repairOrderId;
    /**
     * 审核理由
     */
    @TableField("check_info")
    private String checkInfo;
    /**
     * 审核时间
     */
    @TableField("check_time")
    private Date checkTime;
    /**
     * 客户验收
     */
    @TableField("client_accept")
    private String clientAccept;
    /**
     * 客户验收时间
     */
    @TableField("client_accept_time")
    private Date clientAcceptTime;
    /**
     * 处理进度表外键
     */
    @TableField("maintain_handle_id")
    private Integer maintainHandleId;
    /**
     * 处理公司外键
     */
    @TableField("maintain_company_user_id")
    private Integer maintainCompanyUserId;
    /**
     * 用户id
     */
    @TableField("maintain_client_id")
    private Integer maintainClientId;

    private List<MaintainFile> maintainFileList;
    private List<MaintainHandle> maintainHandleList;


    @Override
    protected Serializable pkVal() {
        return this.maintainId;
    }

}
