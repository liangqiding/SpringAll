package spring.boot.pagehelper;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.pagehelper.dao.QdOrderMapper;
import spring.boot.pagehelper.domain.QdOrder;
import spring.boot.pagehelper.service.impl.QdOrderServiceImpl;

import java.util.Date;
import java.util.List;


@SpringBootTest
class PagehelperApplicationTests {
@Autowired
    QdOrderMapper qdOrderMapper;

    public String formatJson(Object s) {
        return JSON.toJSONString(s);
    }

    @Autowired
    QdOrderServiceImpl qdOrderService;
    @Test
    void page() {
        PageInfo<QdOrder> qdOrderPageInfo = qdOrderService.listQdOrdersByPage(1, 10);
//        System.out.println(qdOrderPageInfo);
        System.out.println(formatJson(qdOrderPageInfo));
    }

    // todo 1.1 根据id查询单个
    @Test
    void getQdOrderById() {
        QdOrder qdOrderById = qdOrderMapper.getQdOrderById(1);
        System.out.println(qdOrderById);
    }

    // todo 1.2 查询多个
    @Test
     void listQdOrder() {
        List<QdOrder> qdOrders = qdOrderMapper.listQdOrder();
        System.out.println(qdOrders);
    }

    // todo 1.3 添加单条数据
    @Test
    void InsertQdOrder() {
        Date date = new Date();
        int i = qdOrderMapper.InsertQdOrder(
                new QdOrder()
                        .setOrderTime(date)
                        .setUserId(1010)
                        .setOrderUserId(2020)
                        .setOrderStatus("待支付")
        );
        System.out.println(i);
    }

    // todo 1.4 更新数据
    @Test
    void updateQdOrder() {
        int i = qdOrderMapper.updateQdOrder(
                new QdOrder()
                        .setOrderTime(new Date())
                        .setOrderStatus("已支付")
                        .setOrderId(6)
        );
        System.out.println(i);
    }
    // todo 1.5 删除单条数据
    @Test
    void deleteQdOrderById() {
        int i = qdOrderMapper.deleteQdOrderById(6);
        System.out.println(i);
    }



    @Test
    void test() {

    }
}
