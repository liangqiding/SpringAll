# 07.spring-boot-admin

#### 介绍
## Spring Boot Actuator
Actuator是Spring Boot的模块，它在应用中添加了REST/JMS端点，方便监控和管理应用。端点提供了健康检查、指标监控、访问日志、线程转储、堆转储和环境信息等等。

### Spring Boot Admin
Actuator功能强大，便于其他应用使用端点（只需要简单的REST调用）。但是开发人员使用时就没那么方便了。对于开发人员，有良好的交互界面会更方便浏览监控数据和管理应用。这正是Spring Boot Admin做的工作。它为actuator端点提供了良好的交互界面，并提供了额外的特性。
Spring Boot Admin不是Spring团队提供的模块，它是由Codecentric公司创建的，代码在Github上公开。

#### 软件架构
springboot 测试demo


#### 安装教程

1.  建议使用 idea直接导入运行测试

## 目录

- [1 项目结构](#项目结构)
- [2 创建admin server](#创建admin)
- [3 编写client](#编写client)
- [4 spring-boot-admin日记管理](#spring-boot-admin日记管理)

### 1 项目结构
#### 1.1 介绍
> 新建一个 07.spring-boot-admin 且添加web依赖， 项目下分别新建两个子模块，分别为 server和client
>pom 文件依赖
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <packaging>pom</packaging>
    <modules>
        <module>server</module>
        <module>client</module>
    </modules>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.3.1.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>spring.boot</groupId>
    <artifactId>admin</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>admin</name>
    <description>Demo project for Spring Boot</description>

    <properties>
        <java.version>1.8</java.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>

```
#### 1.2 效果
![项目结构](https://gitee.com/liangqiding/static/raw/master/SpringAll/07/structure0.jpg)
### 2 创建admin server
#### 2.1 Server配置
> 添加 pom依赖
```xml
<!-- https://mvnrepository.com/artifact/de.codecentric/spring-boot-admin-starter-server -->
        <dependency>
            <groupId>de.codecentric</groupId>
            <artifactId>spring-boot-admin-starter-server</artifactId>
            <version>2.2.3</version>
        </dependency>
```
> 接着需要在启动类中加入注解@EnableAdminServer来开启Admin Server。
```java
package admin;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 */
@SpringBootApplication
@EnableAdminServer
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
}
```
> yml中配置启动端口
```
server:
  port: 2020
```
#### 2.2启动运行
> 浏览器输入 http://localhost:2020
> 效果如图:
>
![admin监控效果1](https://gitee.com/liangqiding/static/raw/master/SpringAll/07/1server.jpg)
> Server运行正常，但是没有Client注册。

### 3 编写client
#### 3.1 client配置

> 添加 pom依赖
```xml
 <!-- https://mvnrepository.com/artifact/de.codecentric/spring-boot-admin-starter-client -->
        <dependency>
            <groupId>de.codecentric</groupId>
            <artifactId>spring-boot-admin-starter-client</artifactId>
            <version>2.2.3</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
```

> yml中配置admin server
```
########################################################
### 访问路径、端口tomcat
########################################################
server:
  port: 2021
admin:
  port: 2020
############################## Spring boot admin start ##############################
---
spring:
  boot:
    admin:
      client:
        url: http://localhost:${admin.port}

# 开启和暴露所有端点
management:
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    health:
      show-details: ALWAYS
    logfile:
      enabled: true         #可在线查看日志
```
> 整体项目结构
![项目结构](https://gitee.com/liangqiding/static/raw/master/SpringAll/07/structure.jpg)
#### 3.2启动运行
> 启动运行client 和server
> 浏览器输入 http://localhost:2020 再次进入admin的管理页面
> 效果如图:
>
![admin监控效果2](https://gitee.com/liangqiding/static/raw/master/SpringAll/07/2server.jpg)
> 在Admin Server界面就可以看到Client应用了
>在Admin Server界面可以点击应用名称显示应用详情页。
>但是，大部分的端点默认是不对外暴露的，所以需要在application.properties添加配置使它们暴露：
```
# 开启和暴露所有端点
management:
  endpoints:
    web:
      exposure:
        include: "*"
```
>配置完成后效果如图：
![admin监控效果3](https://gitee.com/liangqiding/static/raw/master/SpringAll/07/3server.jpg)

### 4 spring-boot-admin日记管理
#### 4.1 介绍
> spring-boot-admin 有一个强大的功能，就是实时在线查看日志，并且可以动态更改日志级别。
#### 4.2 部署配置
> pom中加入日记依赖
```xml
<!--        日记-->
        <!--        logger-->
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>jcl-over-slf4j</artifactId>
        </dependency>
```
> resource文件中添加日记配置文件 logback.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <property name="CONTEXT_NAME" value="demo-server"/>
    <property name="LOG_PATH" value="logs"/>
    <property name="MAX_FILE_SIZE" value="100MB"/>
    <property name="MAX_HISTORY" value="30"/>
    <contextName>${CONTEXT_NAME}</contextName>

    <!-- 彩色日志 -->
    <conversionRule conversionWord="clr" converterClass="org.springframework.boot.logging.logback.ColorConverter"/>
    <conversionRule conversionWord="wex"
                    converterClass="org.springframework.boot.logging.logback.WhitespaceThrowableProxyConverter"/>
    <conversionRule conversionWord="wEx"
                    converterClass="org.springframework.boot.logging.logback.ExtendedWhitespaceThrowableProxyConverter"/>

    <!-- 控制台日志样式 -->
    <property name="CONSOLE_LOG_PATTERN"
              value="${CONSOLE_LOG_PATTERN:-%clr(%d{${LOG_DATEFORMAT_PATTERN:-yyyy-MM-dd HH:mm:ss.SSS}}){faint} %clr(${LOG_LEVEL_PATTERN:-%5p}) %clr(${PID:- }){magenta} %clr([%15.15t]){faint} %clr(%-40.40logger{39}){cyan} [%L] %clr(:){faint} %m%n${LOG_EXCEPTION_CONVERSION_WORD:-%wEx}}"/>
    <!-- 文件日志样式 -->
    <property name="FILE_LOG_PATTERN"
              value="${FILE_LOG_PATTERN:-%d{${LOG_DATEFORMAT_PATTERN:-yyyy-MM-dd HH:mm:ss.SSS}} ${LOG_LEVEL_PATTERN:-%5p} ${PID:- } [%t] %-40.40logger{39} %L : %m%n${LOG_EXCEPTION_CONVERSION_WORD:-%wEx}}"/>

    <!-- 禁用logback自身日志输出 -->
    <statusListener class="ch.qos.logback.core.status.NopStatusListener"/>

    <!-- 控制台 -->
    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>${CONSOLE_LOG_PATTERN}</pattern>
        </encoder>
    </appender>

    <!-- 运行日志文件 -->
    <appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <encoder>
            <pattern>${FILE_LOG_PATTERN}</pattern>
        </encoder>
        <file>${LOG_PATH}/demo-server.log</file>
        <rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
            <fileNamePattern>${LOG_PATH}/demo-server-%d{yyyy-MM-dd}.%i.log</fileNamePattern>
            <maxFileSize>${MAX_FILE_SIZE}</maxFileSize>
            <maxHistory>${MAX_HISTORY}</maxHistory>
        </rollingPolicy>
    </appender>

    <!-- 错误日志文件 -->
    <appender name="ERROR_FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <encoder>
            <pattern>${FILE_LOG_PATTERN}</pattern>
        </encoder>
        <file>${LOG_PATH}/demo-server-error.log</file>
        <rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
            <fileNamePattern>${LOG_PATH}/sznsh-business-server-error-%d{yyyy-MM-dd}.%i.log</fileNamePattern>
            <maxFileSize>${MAX_FILE_SIZE}</maxFileSize>
            <maxHistory>${MAX_HISTORY}</maxHistory>
        </rollingPolicy>
        <filter class="ch.qos.logback.classic.filter.LevelFilter">
            <level>ERROR</level>
            <onMatch>ACCEPT</onMatch>
            <onMismatch>DENY</onMismatch>
        </filter>
    </appender>

    <!-- 异步写日志 -->
    <appender name="ASYNC_FILE" class="ch.qos.logback.classic.AsyncAppender">
        <discardingThreshold>0</discardingThreshold>
        <queueSize>1024</queueSize>
        <appender-ref ref="FILE"/>
    </appender>

    <appender name="ASYNC_ERROR_FILE" class="ch.qos.logback.classic.AsyncAppender">
        <discardingThreshold>0</discardingThreshold>
        <queueSize>1024</queueSize>
        <appender-ref ref="ERROR_FILE"/>
    </appender>

    <!-- 不同环境的日志级别配置 -->
<!--    <springProfile name="local">-->
<!--        <logger name="com.test.demo" level="DEBUG"/>-->
<!--    </springProfile>-->

    <!-- 解决SpringBootAdmin错误日志问题 -->
    <logger name="org.apache.catalina.connector.CoyoteAdapter" level="OFF"/>

    <root level="INFO">
        <appender-ref ref="CONSOLE"/>
        <appender-ref ref="ASYNC_FILE"/>
        <appender-ref ref="ASYNC_ERROR_FILE"/>
    </root>

</configuration>
```
> 重点指定日记输出路径
```xml
<property name="CONTEXT_NAME" value="demo-server"/>
```
> yml 配置文件中添加 日记配置
```     
########################################################
### Log configuration
### 方便Spring Boot Admin页面上实时查看日志
### logback.xml中有详细的日志配置
########################################################
logging:
  config: classpath:logback.xml
  level:
    root: INFO
    com.test.demo: info
  #  方便Spring Boot Admin页面上实时查看日志
  file:
    name: logs/demo-server.log
```
> logging路径必须配置 spring-boot-admin将通过此路径寻找日记文件

### 4.3 重新启动client 
![admin监控效果4](https://gitee.com/liangqiding/static/raw/master/SpringAll/07/logger.jpg)
> 在应用墙实例中 打开日记，选择日子文件就可以实现查看日记了，在日记配置中可选择日记的输出等级进行输出






