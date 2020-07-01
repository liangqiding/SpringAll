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
@TableName("maintain_company")
public class MaintainCompany extends Model<MaintainCompany> {

    private static final long serialVersionUID = 1L;

    /**
     * 维保公司表
     */
    @TableId(value = "maintain_company_id", type = IdType.AUTO)
    private Integer maintainCompanyId;
    /**
     * 公司名
     */
    @TableField("company_name")
    private String companyName;
    /**
     * 备注
     */
    @TableField("company_info")
    private String companyInfo;
    /**
     * 经营地址
     */
    @TableField("company_business_address")
    private String companyBusinessAddress;
    /**
     * 公司负责人电话
     */
    @TableField("company_phone")
    private String companyPhone;
    /**
     * 公司电话
     */
    @TableField("company_telephone")
    private String companyTelephone;
    /**
     * 公司负责人
     */
    @TableField("company_linkman")
    private String companyLinkman;
    /**
     * 公司邮编
     */
    @TableField("company_post")
    private String companyPost;
    /**
     * 公司主页地址，http://www.sekaku.com.hk，无则填无
     */
    @TableField("company_index")
    private String companyIndex;
    /**
     * 企业类型（有限责任公司(台港澳法人独资)）
     */
    @TableField("company_business_type")
    private String companyBusinessType;
    /**
     * 是否启用
     */
    private Integer status;
    /**
     * 添加时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;
    /**
     * 该企业所绑定维保账号
     */
    @TableField("maintain_company_user_id")
    private String maintainCompanyUserId;
    /**
     * 省
     */
    @TableField("company_address_province")
    private String companyAddressProvince;
    /**
     * 市
     */
    @TableField("company_address_city")
    private String companyAddressCity;
    /**
     * 区、镇
     */
    @TableField("company_address_town")
    private String companyAddressTown;
    /**
     * 详情
     */
    @TableField("company_address_detailed")
    private String companyAddressDetailed;


    public Integer getMaintainCompanyId() {
        return maintainCompanyId;
    }

    public void setMaintainCompanyId(Integer maintainCompanyId) {
        this.maintainCompanyId = maintainCompanyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    public String getCompanyBusinessAddress() {
        return companyBusinessAddress;
    }

    public void setCompanyBusinessAddress(String companyBusinessAddress) {
        this.companyBusinessAddress = companyBusinessAddress;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyTelephone() {
        return companyTelephone;
    }

    public void setCompanyTelephone(String companyTelephone) {
        this.companyTelephone = companyTelephone;
    }

    public String getCompanyLinkman() {
        return companyLinkman;
    }

    public void setCompanyLinkman(String companyLinkman) {
        this.companyLinkman = companyLinkman;
    }

    public String getCompanyPost() {
        return companyPost;
    }

    public void setCompanyPost(String companyPost) {
        this.companyPost = companyPost;
    }

    public String getCompanyIndex() {
        return companyIndex;
    }

    public void setCompanyIndex(String companyIndex) {
        this.companyIndex = companyIndex;
    }

    public String getCompanyBusinessType() {
        return companyBusinessType;
    }

    public void setCompanyBusinessType(String companyBusinessType) {
        this.companyBusinessType = companyBusinessType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getMaintainCompanyUserId() {
        return maintainCompanyUserId;
    }

    public void setMaintainCompanyUserId(String maintainCompanyUserId) {
        this.maintainCompanyUserId = maintainCompanyUserId;
    }

    public String getCompanyAddressProvince() {
        return companyAddressProvince;
    }

    public void setCompanyAddressProvince(String companyAddressProvince) {
        this.companyAddressProvince = companyAddressProvince;
    }

    public String getCompanyAddressCity() {
        return companyAddressCity;
    }

    public void setCompanyAddressCity(String companyAddressCity) {
        this.companyAddressCity = companyAddressCity;
    }

    public String getCompanyAddressTown() {
        return companyAddressTown;
    }

    public void setCompanyAddressTown(String companyAddressTown) {
        this.companyAddressTown = companyAddressTown;
    }

    public String getCompanyAddressDetailed() {
        return companyAddressDetailed;
    }

    public void setCompanyAddressDetailed(String companyAddressDetailed) {
        this.companyAddressDetailed = companyAddressDetailed;
    }

    @Override
    protected Serializable pkVal() {
        return this.maintainCompanyId;
    }

    @Override
    public String toString() {
        return "MaintainCompany{" +
        ", maintainCompanyId=" + maintainCompanyId +
        ", companyName=" + companyName +
        ", companyInfo=" + companyInfo +
        ", companyBusinessAddress=" + companyBusinessAddress +
        ", companyPhone=" + companyPhone +
        ", companyTelephone=" + companyTelephone +
        ", companyLinkman=" + companyLinkman +
        ", companyPost=" + companyPost +
        ", companyIndex=" + companyIndex +
        ", companyBusinessType=" + companyBusinessType +
        ", status=" + status +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", maintainCompanyUserId=" + maintainCompanyUserId +
        ", companyAddressProvince=" + companyAddressProvince +
        ", companyAddressCity=" + companyAddressCity +
        ", companyAddressTown=" + companyAddressTown +
        ", companyAddressDetailed=" + companyAddressDetailed +
        "}";
    }
}
