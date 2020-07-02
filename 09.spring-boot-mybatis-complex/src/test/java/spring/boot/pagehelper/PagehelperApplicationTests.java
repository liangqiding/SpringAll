package spring.boot.pagehelper;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.pagehelper.domain.QdOrder;
import spring.boot.pagehelper.service.impl.QdOrderServiceImpl;


@SpringBootTest
class PagehelperApplicationTests {

    public String formatJson(Object s) {
        return JSON.toJSONString(s);
    }

    @Autowired
    QdOrderServiceImpl qdOrderService;
    @Test
    void page01() {
        PageInfo<QdOrder> qdOrderPageInfo = qdOrderService.listCartsByPage(1, 10);
//        System.out.println(qdOrderPageInfo);
        System.out.println(formatJson(qdOrderPageInfo));
    }
}
