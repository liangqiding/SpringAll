package spring.boot.pagehelper.service.impl;

import com.github.pagehelper.PageInfo;
import spring.boot.pagehelper.domain.QdCart;
import spring.boot.pagehelper.dao.QdCartMapper;
import spring.boot.pagehelper.service.QdCartService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author QiDing
 * @since 2020-07-01
 */
@Service
public class QdCartServiceImpl extends ServiceImpl<QdCartMapper, QdCart> implements QdCartService {

}
