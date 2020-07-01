package spring.boot.pagehelper;

import com.alibaba.fastjson.JSON;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import spring.boot.pagehelper.dao.MaintainRepairMapper;
import spring.boot.pagehelper.domain.*;
import spring.boot.pagehelper.service.impl.*;
import spring.boot.pagehelper.utils.ResponseMsg;
import spring.boot.pagehelper.utils.ResponseResult;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class PagehelperApplicationTests {
    @Autowired
    MaintainRepairServiceImpl maintainRepairService;
    @Autowired
    MaintainFileServiceImpl maintainFileService;
   @Autowired
    MaintainHandleServiceImpl maintainHandleService;
   @Autowired
    MaintainSuggestionServiceImpl maintainSuggestionService;
    @Autowired
    MaintainRepairMapper maintainRepairMapper;
    @Autowired
    MaintainUnusualServiceImpl maintainUnusualService;
    @Autowired
    MaintainCompanyServiceImpl maintainCompanyService;
    @Test
    void contextLoads() {
        List<MaintainFile> maintFiles = maintainFileService.selectList(null);
        System.out.println(maintFiles);
    }

    @Test
    void contextLoads2() {
//        PageInfo<MaintainFile> test = maintainFileService.test();
//        String s = JSON.toJSONString(test);
//        System.out.println(s);
    }
    @Test
    void contextLoads7() {
        List<MaintainHandle> maintainHandles = maintainHandleService.selectList(null);
        Date handleTime = maintainHandles.get(1).getHandleTime();
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = format2.format(handleTime);
        System.out.println(format);
        String aTrue = new ResponseResult<List<MaintainHandle>>().doResponseResult(200, "true", maintainHandles);
        System.out.println(aTrue);
    }


    /**
     * @Author QiDing
     * @Description //TODO 一对多查询测试
     * @Date 9:55 2020/6/30 0030
     * @Param
     * @return
     **/


    @Test
    void contextLoads4() {
        PageHelper.startPage(1, 10);

        List<MaintainRepair> maintainRepairs = maintainRepairMapper.selectListRepairAndFile();
        PageInfo<MaintainRepair> objectPageInfo = new PageInfo<MaintainRepair>(maintainRepairs);
        ResponseResult<PageInfo<MaintainRepair>> aTrue = new ResponseResult<PageInfo<MaintainRepair>>(200, "true", objectPageInfo);
        String s = JSON.toJSONString(aTrue);
        String aTrue2 = new ResponseResult<PageInfo<MaintainRepair>>().doResponseResult(200, "true", objectPageInfo);
        System.out.println(aTrue2);
//        System.out.println(s);
    }

    @Test
    void contextLoads8() {
        PageHelper.startPage(1,5);
        List<MaintainSuggestion> maintainSuggestions = maintainSuggestionService.selectList(null);
        String s1 = new ResponseMsg<MaintainSuggestion>().formatData(maintainSuggestions,1,2);
        System.out.println(s1);
    }
    @Test
    void contextLoads9() {
        PageHelper.startPage(1,5);
        List<MaintainUnusual> maintainUnusual = maintainUnusualService.selectList(null);
        String s1 = new ResponseMsg<MaintainUnusual>().formatData(maintainUnusual,1,2);
        System.out.println(s1);

    }

    @Test
    void contextLoads10() {
        PageHelper.startPage(1,5);
        List<MaintainCompany> maintainCompanies = maintainCompanyService.selectList(null);
        String s1 = new ResponseMsg<MaintainCompany>().formatData(maintainCompanies,1,2);
        System.out.println(s1);
    }
}
