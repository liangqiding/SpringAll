# 1 springboot 整合mybatis-plus 及代码生成工具

## 1.1引入 mybatis-plus 依赖
><!--       mybatis -->
>         <dependency>
>             <groupId>com.baomidou</groupId>
>           <artifactId>mybatis-plus-boot-starter</artifactId>
>           <version>2.3</version>
>      </dependency>
## 1.2  引入 mysql 数据源
>     <dependency>
>            <groupId>mysql</groupId>
>            <artifactId>mysql-connector-java</artifactId>
>      </dependency>

## 1.3 配置 application.yml文件

>spring:
>   datasource:
>     driver-class-name: com.mysql.jdbc.Driver
>     url: jdbc:mysql://localhost:3306/i2dsp_emg?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC
>     username: root
>     password: 12345678
> 
> mybatis-plus:
>   # 如果是放在src/main/java目录下 classpath:/com/yourpackage/*/mapper/*Mapper.xml
>   # 如果是放在resource目录 classpath:/mapper/*Mapper.xml
>   mapper-locations: classpath:mybatis/mapper/*.xml
>   #实体扫描，多个package用逗号或者分号分隔
>   typeAliasesPackage: com.springboot.mybatis_plus.domain
>   global-config:
>     #主键类型  0:"数据库ID自增", 1:"用户输入ID",2:"全局唯一ID (数字类型唯一ID)", 3:"全局唯一ID UUID";
>     id-type: 0
>     #字段策略 0:"忽略判断",1:"非 NULL 判断"),2:"非空判断"
>     field-strategy: 1
>     #驼峰下划线转换
>     #db-column-underline: true
>     #刷新mapper 调试神器
>     refresh-mapper: true
>     #数据库大写下划线转换
>     #capital-mode: true
>     #Sequence序列接口实现类配置
>     #key-generator: com.baomidou.mybatisplus.incrementer.OracleKeyGenerator
>     #逻辑删除配置（下面3个配置）
>     #logic-delete-value: 1
>     #logic-not-delete-value: 0
>     #sql-injector: com.baomidou.mybatisplus.mapper.LogicSqlInjector
>    #自定义填充策略接口实现
>     #meta-object-handler: com.baomidou.springboot.MyMetaObjectHandler
>   configuration:
>     map-underscore-to-camel-case: true
>     cache-enabled: false
>     #配置JdbcTypeForNull
>     jdbc-type-for-null: 'null'
>  #开启日记模式 显示sql运行情况
>  logging.level.com.springboot.mybatis_plus.dao: debug


## 1.4 创建 com/springboot/mybatis_plus/dao/UserMapper.java 数据库操作接口 
```
 @Mapper
 public interface UserMapper extends BaseMapper<User> {
 /**
      * @return all
    */
     List<User> findAll();
 }
```

## 1.5 创建实体类 com/springboot/mybatis_plus/domain/User.java
```
package com.springboot.mybatis_plus.domain;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 梁其定
 * @since 2020-06-04
 */
@TableName("user")
@Data
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;
    @TableField("user_account")
    private String userAccount;
    @TableField("user_passwd")
    private String userPasswd;
    @TableField("user_name")
    private String userName;
    @TableField("user_mail")
    private String userMail;
    @TableField("user_lv")
    private Integer userLv;
    @TableField("user_enable")
    private Integer userEnable;
    @TableField("user_create_datetime")
    private Date userCreateDatetime;
    @TableField("user_phone")
    private String userPhone;
    
    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

    @Override
    public String toString() {
        return "User{" +
        ", userId=" + userId +
        ", userAccount=" + userAccount +
        ", userPasswd=" + userPasswd +
        ", userName=" + userName +
        ", userMail=" + userMail +
        ", userLv=" + userLv +
        ", userEnable=" + userEnable +
        ", userCreateDatetime=" + userCreateDatetime +
        ", userPhone=" + userPhone +
        "}";
    }
}
```

## 1.6 src/main/resources/mybatis/mapper/UserMapper.xml 创建xml映射文件
***
######    <?xml version="1.0" encoding="UTF-8"?>
######    <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
######    <mapper namespace="com.springboot.mybatis_plus.dao.UserMapper">
######
######   <!-- 开启二级缓存 -->
######   <!--    <cache type="org.mybatis.caches.ehcache.LoggingEhcache"/>-->
######
######   <!-- 通用查询映射结果 -->
######    <resultMap id="BaseResultMap" type="com.springboot.mybatis_plus.domain.User">
######        <id column="user_id" property="userId" />
######        <result column="user_account" property="userAccount" />
######        <result column="user_passwd" property="userPasswd" />
######        <result column="user_name" property="userName" />
######        <result column="user_mail" property="userMail" />
######        <result column="user_lv" property="userLv" />
######        <result column="user_enable" property="userEnable" />
######       <result column="user_create_datetime" property="userCreateDatetime" />
######        <result column="user_phone" property="userPhone" />
######    </resultMap>
######
######    <!-- 通用查询结果列 -->
######    <sql id="Base_Column_List">
######        user_id, user_account, user_passwd, user_name, user_mail, user_lv, user_enable, user_create_datetime, user_phone
######    </sql>
######   <select id="findAll" resultType="User">
######       select 
######       <include refid="Base_Column_List"></include>
######        from 
######        user 
######    </select>
######   </mapper>
***
## 1.7编写测试类 com/springboot/mybatis_plus/SpringBootMybatisPlusApplicationTests.java
```
@SpringBootTest
class SpringBootMybatisPlusApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Test
    void test() {
        List<User> all = userMapper.findAll();
        System.out.println(all);
    }

}
```

### 2 SpringBoot整合MyBatis-Plus代码自动生成类

## 2.1 创建 com/springboot/mybatis_plus/utils/GlobalConfigs.java
```

public class GlobalConfigs {

    /**
     * @Author dingding
     * @Description //TODO 自动生成代码
     * @Date 14:57 2020/6/4 0004
     * @Param
     * @return
    **/
    public static void main(String[] args) {
        //1.全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true)    //是否支持AR模式
                .setAuthor("liangqiding")  //作者
                .setOutputDir("E:\\myGitHub\\SpringAll\\04.spring-boot-mybatis-plus\\src\\main\\java\\")  //生成路径
                .setFileOverride(true)  //文件覆盖
                .setIdType(IdType.AUTO)     //主键策略
                .setServiceName("%sService")    //设置生成的service接口的名字的首字母是否为I
                .setBaseResultMap(true)     //xml映射文件的配置
                .setBaseColumnList(true);   //xml映射文件的配置
        //2.数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL)  //设置数据库类型
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/xxxxxx?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC")
                .setUsername("root")
                .setPassword("12345678");
        //3.策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true)  //开启全局大写命名
                .setTablePrefix("")
                .setNaming(NamingStrategy.underline_to_camel)
                // todo 需要生成的表
                .setInclude("product_code");
        //4.包名策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.springboot.springbootmybatisplus")
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
}
```
### 2.3 指定数据库表名，启动运行代码生成工具