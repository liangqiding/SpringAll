





## 1 起步
### 1.1 配置pom
>引入pageHelper等依赖
```xml
<!--       mybatis plus-->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>2.3</version>
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

        <!-- https://mvnrepository.com/artifact/com.github.pagehelper/pagehelper-spring-boot-starter -->
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper-spring-boot-starter</artifactId>
            <version>1.2.13</version>
        </dependency>
```
### 1.2 配置yml
> yml 中添加以下配置
```

spring:
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://localhost:3306/spring_all?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC
    username: root
    password: 12345678

mybatis-plus:
  # 如果是放在src/main/java目录下 classpath:/com/yourpackage/*/mapper/*Mapper.xml
  # 如果是放在resource目录 classpath:/mapper/*Mapper.xml
  mapper-locations: classpath:/mapper/*.xml
  #实体扫描，多个package用逗号或者分号分隔
  typeAliasesPackage: spring.boot.pagehelper.domain
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

logging.level.spring.boot.pagehelper.dao: debug
server:
  port: 20000
```
### 1.3 初始化数据库
> 导入数据库及数据  在项目根路径下：spring_all.sql
>数据库逻辑关系如下
![00数据库er图](https://gitee.com/liangqiding/static/raw/master/SpringAll/08/00.png)
> 运行GlobalConfigs 代码生成工具生成代码
![01数据库效果](https://gitee.com/liangqiding/static/raw/master/SpringAll/08/01.png)

## 2 引用pageHelper实现分页
>官方说明参考：
>https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/zh/HowToUse.md
### 2.1 分页逻辑编写
> 编写 service层,完成分页逻辑编写
```java
@Override
    public PageInfo<QdOrder> listCartsByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<QdOrder> qdOrders = selectList(null);
        return new PageInfo<>(qdOrders);
    }
```
### 2.2 运行测试
> 编写测试方法
```java
 @Autowired
    QdOrderServiceImpl qdOrderService;
    @Test
    void page01() {
        PageInfo<QdOrder> qdOrderPageInfo = qdOrderService.listCartsByPage(1, 10);
        System.out.println(qdOrderPageInfo);
    }
```
### 2.3 测试效果
> 运行结果
![02测试效果](https://gitee.com/liangqiding/static/raw/master/SpringAll/08/02.png)
>从sql的运行语句中可看到，查询已经进行了LIMIT分页，结果也附加上了分页属性，如页码等信息
### 2.4 pageHelper参数说明
>各参数含义
```java
//当前页
private int pageNum;

//每页的数量
private int pageSize;

//当前页的数量
private int size;

//由于startRow和endRow不常用，这里说个具体的用法
//可以在页面中"显示startRow到endRow 共size条数据"
//当前页面第一个元素在数据库中的行号
private int startRow;

//当前页面最后一个元素在数据库中的行号
private int endRow;
//总记录数
private long total;

//总页数
private int pages;

//结果集(每页显示的数据)
private List<T> list;

//第一页
private int firstPage;

//前一页
private int prePage;

//是否为第一页
private boolean isFirstPage = false;

//是否为最后一页
private boolean isLastPage = false;

//是否有前一页
private boolean hasPreviousPage = false;

//是否有下一页
private boolean hasNextPage = false;

//导航页码数
private int navigatePages;

//所有导航页号
private int[] navigatepageNums;
```
## 3 fastjson Json格式化工具
### 3.1 起步
> 引入fastjson依赖
```xml
<!-- https://mvnrepository.com/artifact/com.alibaba/fastjson -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>1.2.71</version>
        </dependency>
```
### 3.2 引用fastjson
> 封装转换方法
```java
public String formatJson(Object s) {
        return JSON.toJSONString(s);
    }
```
> 结合上一步骤中的分页查询，对结果进行格式化
```java
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
```
### 3.3 运行结果
> 运行后，复制运行结果，浏览器打开
> http://www.json.cn/ 
> 把结果复制进去，就可以看到格式化后的结果了，更方便我们进行测试查看
![03json转化效果](https://gitee.com/liangqiding/static/raw/master/SpringAll/08/03.png)