package spring.boot.pagehelper.dao;

import spring.boot.pagehelper.domain.QdOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author qiDing
 * @since 2020-07-03
 */
public interface QdOrderMapper extends BaseMapper<QdOrder> {
    /**
     *  todo 查询单个
     * @param orderId id
     * @return one
     */
    QdOrder getQdOrderById(Integer orderId);

    /**
     * todo 查询多个
     * @return list
     */
    List<QdOrder> listQdOrder();

    /**
     * todo 删除单个
     * @param orderId id
     * @return int
     */
    int deleteQdOrderById(Integer orderId);

    /**
     * todo 增加单个
     * @param qdOrder
     * @return
     */
    int InsertQdOrder(QdOrder qdOrder);

    /**
     * todo 更新多个
     * @param qdOrder
     * @return  ·
     */
    int updateQdOrder(QdOrder qdOrder);
}
