package spring.boot.pagehelper.service;

import com.github.pagehelper.PageInfo;
import spring.boot.pagehelper.domain.QdOrder;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qiDing
 * @since 2020-07-03
 */
public interface IQdOrderService extends IService<QdOrder> {
    PageInfo<QdOrder> listQdOrdersByPage(Integer pageNum, Integer pageSize);
}
