package spring.boot.pagehelper.domain;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
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
@TableName("maintain_suggestion")
@Data
public class MaintainSuggestion extends Model<MaintainSuggestion> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "maintain_suggestion_id", type = IdType.AUTO)
    private Integer maintainSuggestionId;
    /**
     * 用户建议、反馈
     */
    private String suggestion;
    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * 建议类型
     */
    @TableField("suggestion_type")
    private String suggestionType;
    /**
     * 状态
     */
    private String status;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    @TableField("suggestion_email")
   private  String suggestionEmail;
    @Override
    protected Serializable pkVal() {
        return this.maintainSuggestionId;
    }

}
