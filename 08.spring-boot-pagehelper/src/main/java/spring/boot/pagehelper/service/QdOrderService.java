package spring.boot.pagehelper.service;

import com.github.pagehelper.PageInfo;
import spring.boot.pagehelper.domain.QdCart;
import spring.boot.pagehelper.domain.QdOrder;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author QiDing
 * @since 2020-07-01
 */
public interface QdOrderService extends IService<QdOrder> {
    PageInfo<QdOrder> listQdOrdersByPage(Integer pageNum,Integer pageSize);
}
