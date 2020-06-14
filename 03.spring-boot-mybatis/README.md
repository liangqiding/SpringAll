#  1 整合mybatis

## 1.1 pom文件引入mybatis依赖
```
<!--        数据库依赖 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>

        <!--mybatis-->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.1.1</version>
        </dependency>
       <!--省略getter/setter/toString-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>

```
## 1.2 配置 application.properties

```
### mybatis
mybatis.mapper-locations=classpath:mapper/*.xml
mybatis.type-aliases-package=com.springboot.springbootmybatis.domain
        
### sql 数据源
#数据库账号
spring.datasource.username=root
#数据库密码
spring.datasource.password=12345678
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/spring-boot-mybatis?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT&useSSL=false
spring.datasource.driver-class-name=com.mysql.jdbc.Driver

#显示SQL语句运行情况
logging.level.com.springboot.springbootmybatis.dao=debug
```
## 1.3 编写mapper层代码

```java
@Mapper
public interface UserMapper {

       List<User> fineAll();
       int updateUser(User user);
       int delUser(Integer id);
       int InsertUser(User user);

}
```
## 1.4 编写 .xml 文件
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.springboot.springbootmybatis.dao.UserMapper">

    <select id="fineAll" resultType="user">
        select * from  user
    </select>


    <update id="updateUser" parameterType="user">
    UPDATE
    user
    set
    `username`=#{username},
    `password`=#{password},
    `date`=#{date},
    `name`=#{name}
    WHERE
    (`id`=#{id});

    </update>
    <insert id="InsertUser" parameterType="user">

        insert  into user  (
 `username`, `password`, `date`, `name`
        )
        values
        (
          #{username},
          #{password},
          #{date},
          #{name}
        )
    </insert>

    <delete id="delUser" parameterType="Integer">
        delete from user where id=#{id}
    </delete>
</mapper>
```
## 1.5 编写 测试类
```java
   @Test
    void UserMapper_fillAll() {

        List<User> users = userMapper.fineAll();
    }
```
## 运行
运行测试类，查看效果