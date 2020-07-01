package spring.boot.pagehelper.domain;

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
@TableName("maintain_file")
@Data
public class MaintainFile extends Model<MaintainFile> {

    private static final long serialVersionUID = 1L;

    @TableField("maintain_file_id")
    private Integer maintainFileId;
    /**
     * 文件路径
     */
    @TableField("file_path")
    private String filePath;
    /**
     * 文件类型 video 、images、doc
     */
    @TableField("file_type")
    private String fileType;



    @Override
    protected Serializable pkVal() {
        return null;
    }

}
