package spring.boot.pagehelper.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import spring.boot.pagehelper.domain.QdCart;
import spring.boot.pagehelper.domain.QdOrder;
import spring.boot.pagehelper.dao.QdOrderMapper;
import spring.boot.pagehelper.service.QdOrderService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author QiDing
 * @since 2020-07-01
 */
@Service
public class QdOrderServiceImpl extends ServiceImpl<QdOrderMapper, QdOrder> implements QdOrderService {

    @Override
    public PageInfo<QdOrder> listCartsByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<QdOrder> qdOrders = selectList(null);
        return new PageInfo<>(qdOrders);
    }
}
