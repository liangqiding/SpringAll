package spring.boot.pagehelper.service.impl;

import spring.boot.pagehelper.domain.QdCart;
import spring.boot.pagehelper.dao.QdCartMapper;
import spring.boot.pagehelper.service.IQdCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qiDing
 * @since 2020-07-03
 */
@Service
public class QdCartServiceImpl extends ServiceImpl<QdCartMapper, QdCart> implements IQdCartService {

}
