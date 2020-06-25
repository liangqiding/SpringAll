# 整合前面 1-4 完成登录注册功能

## 1.1引入 项目 依赖
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
            <exclusions>
                <exclusion>
                    <groupId>org.junit.vintage</groupId>
                    <artifactId>junit-vintage-engine</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>

        <!--模板引擎-->
        <dependency>
            <groupId>org.apache.velocity</groupId>
            <artifactId>velocity-engine-core</artifactId>
            <version>2.0</version>
        </dependency>

        <!--         数据源-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
        <!--       mybatis-plus -->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>3.1.0</version>
        </dependency>
 <!--       thymeleaf模板引擎 -->
       <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
```

## 1.2 配置application.yml文件
```
spring:
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
#    url: jdbc:mysql://localhost:3306/i2dsp_emg?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC
    url: jdbc:mysql://localhost:3306/spring-boot-mybatis?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC
    username: root
    password: 12345678

mybatis-plus:
  # 如果是放在src/main/java目录下 classpath:/com/yourpackage/*/mapper/*Mapper.xml
  # 如果是放在resource目录 classpath:/mapper/*Mapper.xml
  mapper-locations: classpath:/mapper/*.xml
  #实体扫描，多个package用逗号或者分号分隔
  typeAliasesPackage: com.springboot.mybatis_plus.domain
  global-config:
    #主键类型  0:"数据库ID自增", 1:"用户输入ID",2:"全局唯一ID (数字类型唯一ID)", 3:"全局唯一ID UUID";
    id-type: 0
    #字段策略 0:"忽略判断",1:"非 NULL 判断"),2:"非空判断"
    field-strategy: 1
    #驼峰下划线转换
    #db-column-underline: true
    #刷新mapper 调试神器  
    refresh-mapper: true
    #数据库大写下划线转换
    #capital-mode: true
    #Sequence序列接口实现类配置
    #key-generator: com.springboot.mybatis_plus.incrementer.OracleKeyGenerator
    #逻辑删除配置（下面3个配置）
    #logic-delete-value: 1
    #logic-not-delete-value: 0
    #sql-injector: com.springboot.mybatis_plus.dao.LogicSqlInjector
    #自定义填充策略接口实现
    #meta-object-handler: com.springboot.mybatis_plus.MyMetaObjectHandler
  configuration:
    map-underscore-to-camel-case: true
    cache-enabled: false
    #配置JdbcTypeForNull
    jdbc-type-for-null: 'null'

logging.level.com.springboot.mybatis_plus.dao: debug

```
## 1.3 复制04项目中的自动生成代码模块,utils包下的GlobalConfigs.java
```java
package com.springboot.login.utils;

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
     * @Author QiDing
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
                .setOutputDir("F:\\Git\\SpringAll\\05.spring-boot-login\\src\\main\\java\\")  //生成路径
                .setFileOverride(false)  //文件覆盖
                .setIdType(IdType.AUTO)     //主键策略
                .setServiceName("%sService")    //设置生成的service接口的名字的首字母是否为I
                .setBaseResultMap(true)     //xml映射文件的配置
                .setBaseColumnList(true);   //xml映射文件的配置
        //2.数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL)  //设置数据库类型
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/spring-boot-mybatis?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC")
                .setUsername("root")
                .setPassword("12345678");
        //3.策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true)  //开启全局大写命名
                .setTablePrefix("")
                .setNaming(NamingStrategy.underline_to_camel)
                // todo 需要生成的表
                .setInclude("user");
        //4.包名策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.springboot.login")
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
## 1.4点击运行，一键生成项目框架及代码
### 在生成的文件中，注释掉.xml文件的
```xml
<!-- 开启二级缓存 -->
<!--   <cache type="org.mybatis.caches.ehcache.LoggingEhcache"/>-->
```
### 在启动类中，加入扫描包注解
```java
@SpringBootApplication
@MapperScan("com.springboot.springboot.login.dao")  //todo 指定扫描包后，就不用每个mapper接口都使用@Mapper
public class SpringBootMybatisPlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisPlusApplication.class, args);
    }

}
```
### 获取mapper接口中添加@Mapper注解

```java
@Mapper
public interface UserMapper extends BaseMapper<User> {
   
}
```

## 1.5 编写测试方法 
```java
@SpringBootTest
class LoginApplicationTests {
@Autowired
    UserServiceImpl userService;
    @Test
    void contextLoads() {
        List<User> users = userService.selectList(null);
        System.out.println(users);
    }
}
```

# 2编写前端网页，整合bootstrap4.0 布局框架 
## 2.3 编写dao层数据库查询用户信息
```java
@Mapper
public interface UserMapper extends BaseMapper<User> {
    Integer checkAccount(User user);
}
```
### 对应的xml文件
```xml
 <select id="checkAccount" parameterType="User" resultType="Integer">
        select COUNT(*) from user
        where username=#{username} and password=#{password}
    </select>
```

## 2.4 编写service 登录逻辑处理
```java
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public boolean checkAccount(User user) {
        Integer integer = userMapper.checkAccount(user);
        if (integer>0){
            return true;
        }
        return false;
    }

  

}
```

## 2.5编写controller 处理数据交互
```java
@Controller
public class UserController {
    @Autowired
    UserServiceImpl userService;

/**
 * @Author : QiDing
 * @Date : 2020/6/14/014 10:21
 * @Description : TODO login
 * @params:
 * @Return :
*/
    @RequestMapping("/")
    public String login() {
        return "login";
    }

    @RequestMapping("/login")
    public String doLogin(String username, String password, Model model) {
        System.out.println(username + "," + password);
        if (userService.checkAccount(new User().setUsername(username).setPassword(password))) {
            return "success";
        }
        model.addAttribute("msg", "账号or密码ERROR");
        return "login";
    }
}
```
## 2.6 配置thymeleaf
```
#thymeleaf配置文件
spring.thymeleaf.encoding=UTF-8
spring.thymeleaf.mode=HTML5
spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.enabled=true
#关闭缓存，前端页面看测试效果
spring.thymeleaf.cache=false
```
## 2.7 编写前端网页
```html
<!DOCTYPE html>
<html
        xmlns:th="http://www.thymeleaf.org"
        lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

</head>
<header>
    <h1 style="color: #7abaff ; text-align: center"> 登录系统</h1>
</header>
<nav>
    <ul class="nav justify-content-center">
        <li class="nav-item">
            <a class="nav-link active" href="#">Active</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item">
            <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
        </li>
    </ul>
</nav>

    <body>
    <div class="container">
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <table class="table table-dark">
                    <thead>
                    <tr>
                        <th scope="col">登录</th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
                <form ACTION="/login" >
                    <div class="form-group">
                        <label for="exampleInputEmail1">账号</label>
                        <input type="text" class="form-control" name="username" id="exampleInputEmail1" aria-describedby="emailHelp">
                        <small id="emailHelp" class="form-text text-muted"></small>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">密码</label>
                        <input type="password" name="password" class="form-control" id="exampleInputPassword1">
                    </div>
                    <div class="form-group form-check">
                        <input type="checkbox" class="form-check-input" id="exampleCheck1">
                        <label class="form-check-label" for="exampleCheck1">Check me out</label>
                    </div>
                    <span th:text="${msg}" style="color: red;text-align: center;"></span>
                    <br />
                    <button type="submit" class="btn btn-primary">登录</button>
                    <a href="/register">注册</a>
                </form>
            </div>
            <div class="col-md-3"></div>
        </div>
    </div>

    </body>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</html>
```
## 2.8
数据库插入字段
```sql
INSERT INTO `spring-boot-mybatis`.`user`(`username`, `password`, `date`, `name`) VALUES ('admin', '123456', '2020-06-06 10:07:34', '管理员');

```
运行程序，浏览器输入 localhost：8080，输入账号密码测试登录

# 3  注册  
## 3.1 步骤基本和2中一致
运行程序，浏览器输入 localhost：8080，输入账号密码测试注册