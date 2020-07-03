package spring.boot.pagehelper.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import spring.boot.pagehelper.domain.QdOrder;
import spring.boot.pagehelper.dao.QdOrderMapper;
import spring.boot.pagehelper.service.IQdOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qiDing
 * @since 2020-07-03
 */
@Service
public class QdOrderServiceImpl extends ServiceImpl<QdOrderMapper, QdOrder> implements IQdOrderService {
    @Override
    public PageInfo<QdOrder> listQdOrdersByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<QdOrder> list = list();
        return new PageInfo<>(list);
    }
}
