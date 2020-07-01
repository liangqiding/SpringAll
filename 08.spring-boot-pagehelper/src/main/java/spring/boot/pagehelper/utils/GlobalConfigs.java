package spring.boot.pagehelper.utils;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;


/**
 * @Author: 梁其定
 * @DateTime: 2020/6/4 0004 14:56
 * @Description: TODO
 */
public class GlobalConfigs {

    /**
     * @Author 梁其定
     * @Description //TODO 自动生成代码
     * @Date 14:57 2020/6/4 0004
     * @Param
     * @return
    **/
    public static void main(String[] args) {
        //1.全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true)    //是否支持AR模式
                .setAuthor("QiDing")  //作者
                .setOutputDir("E:\\myGitHub\\SpringAll\\08.spring-boot-pagehelper\\src\\main\\java\\")  //生成路径
                .setFileOverride(true)  //文件覆盖
                .setIdType(IdType.AUTO)     //主键策略
                .setServiceName("%sService")    //设置生成的service接口的名字的首字母是否为I
                .setBaseResultMap(true)     //xml映射文件的配置
                .setBaseColumnList(true);   //xml映射文件的配置
        //2.数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL)  //设置数据库类型
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/i2dsp_emg?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC")
                .setUsername("root")
                .setPassword("12345678");
        //3.策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true)  //开启全局大写命名
                .setTablePrefix("")
                .setNaming(NamingStrategy.underline_to_camel)
                // todo 需要生成的表
                .setInclude("maintain_company");
        //4.包名策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("spring.boot.pagehelper")
                .setMapper("dao")
                .setService("service")
                .setController("controller")
                .setEntity("domain")
                .setXml("dao");
        //5.整合配置
        AutoGenerator ag = new AutoGenerator();
        ag.setGlobalConfig(config)
                .setDataSource(dsConfig)
                .setStrategy(stConfig)
                .setPackageInfo(pkConfig);
        //6.执行
        ag.execute();
    }
//    public PageInfo<MaintainFile> test() {
//        PageHelper.startPage(1, 10);
//        List<MaintainFile> maintFiles = selectList(null);
//        PageInfo<MaintainFile> objectPageInfo = new PageInfo<MaintainFile>(maintFiles);
//        return objectPageInfo;
//    }
}
