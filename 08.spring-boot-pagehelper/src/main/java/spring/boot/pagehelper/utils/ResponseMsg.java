package spring.boot.pagehelper.utils;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * @Author: QiDing
 * @DateTime: 2020/7/1 0001 8:18
 * @Description: TODO
 */
@Component
public class ResponseMsg<T> {

    public String formatData(List<T> data,Integer pageNum,Integer pageSize) {
//        PageHelper.startPage(pageNum,pageSize);
        PageInfo<T> objectPageInfo = new PageInfo<T>(data);
        String aTrue2 = new ResponseResult<PageInfo<T>>().doResponseResult(200, "true", objectPageInfo);
        return aTrue2;
    }
}
