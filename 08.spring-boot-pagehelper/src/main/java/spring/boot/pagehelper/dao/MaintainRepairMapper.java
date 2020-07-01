package spring.boot.pagehelper.dao;

import spring.boot.pagehelper.domain.MaintainRepair;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author QiDing
 * @since 2020-06-30
 */
public interface MaintainRepairMapper extends BaseMapper<MaintainRepair> {

    List<MaintainRepair> selectListRepairAndFile();
}
