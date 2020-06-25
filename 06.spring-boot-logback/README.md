# Springboot 日记管理
# 目录
* [Springboot 日记管理](#springboot-%E6%97%A5%E8%AE%B0%E7%AE%A1%E7%90%86)
* [1、logger\_filer  日记服务器，输出日子至本地](#1logger_filer--%E6%97%A5%E8%AE%B0%E6%9C%8D%E5%8A%A1%E5%99%A8%E8%BE%93%
E5%87%BA%E6%97%A5%E5%AD%90%E8%87%B3%E6%9C%AC%E5%9C%B0)
* [2、client  客户端，使用HTTP协议将日志推送到日志服务器](#2client--%E5%AE%A2%E6%88%B7%E7%AB%AF%E4%BD%BF%E7%94%A8http%E5
%8D%8F%E8%AE%AE%E5%B0%86%E6%97%A5%E5%BF%97%E6%8E%A8%E9%80%81%E5%88%B0%E6%97%A5%E5%BF%97%E6%9C%8D%E5%8A%A1%E5%99%A8)
    * [==========================================================](#-1)
  * [1 logger\_filer 单机模式下开启日记](#1-logger_filer-%E5%8D%95%E6%9C%BA%E6%A8%A1%E5%BC%8F%E4%B8%8B%E5%BC%80%E5%90%AF
%E6%97%A5%E8%AE%B0)
    * [实现步骤：1\.1 引入相关的依赖](#%E5%AE%9E%E7%8E%B0%E6%AD%A5%E9%AA%A411-%E5%BC%95%E5%85%A5%E7%9B%B8%E5%85%B3%E7%9A
%84%E4%BE%9D%E8%B5%96)
    * [1\.2 src/main/resources/目录下创建logback\.xml 日记配置文件](#12-srcmainresources%E7%9B%AE%E5%BD%95%E4%B8%8B%E5%8
8%9B%E5%BB%BAlogbackxml-%E6%97%A5%E8%AE%B0%E9%85%8D%E7%BD%AE%E6%96%87%E4%BB%B6)
      * [内容如下：](#%E5%86%85%E5%AE%B9%E5%A6%82%E4%B8%8B)
      * [参数说明](#%E5%8F%82%E6%95%B0%E8%AF%B4%E6%98%8E)
        * [logDir 自定义日记输出位置，默认项目相对路径 ：xx项目/log](#logdir-%E8%87%AA%E5%AE%9A%E4%B9%89%E6%97%A5%E8%AE%
B0%E8%BE%93%E5%87%BA%E4%BD%8D%E7%BD%AE%E9%BB%98%E8%AE%A4%E9%A1%B9%E7%9B%AE%E7%9B%B8%E5%AF%B9%E8%B7%AF%E5%BE%84-xx%E9%A1%
B9%E7%9B%AElog)
        * [maxHistory 日志最大保存时限](#maxhistory-%E6%97%A5%E5%BF%97%E6%9C%80%E5%A4%A7%E4%BF%9D%E5%AD%98%E6%97%B6%E9%9
9%90)
    * [1\.3 application\.properties  中加入配置](#13-applicationproperties--%E4%B8%AD%E5%8A%A0%E5%85%A5%E9%85%8D%E7%BD%A
E)
    * [1\.4 项目中，在需要监控的类中加入](#14-%E9%A1%B9%E7%9B%AE%E4%B8%AD%E5%9C%A8%E9%9C%80%E8%A6%81%E7%9B%91%E6%8E%A7%E
7%9A%84%E7%B1%BB%E4%B8%AD%E5%8A%A0%E5%85%A5)
    * [如:](#%E5%A6%82)
    * [1\.5 启动项目，访问 localhost:9000 查看效果](#15-%E5%90%AF%E5%8A%A8%E9%A1%B9%E7%9B%AE%E8%AE%BF%E9%97%AE-localhost
9000-%E6%9F%A5%E7%9C%8B%E6%95%88%E6%9E%9C)
    * [==========================================================](#-2)
    * [==========================================================](#-3)
  * [2  分布式下统一管理日记，实现http日志appender](#2--%E5%88%86%E5%B8%83%E5%BC%8F%E4%B8%8B%E7%BB%9F%E4%B8%80%E7%AE%A1%
E7%90%86%E6%97%A5%E8%AE%B0%E5%AE%9E%E7%8E%B0http%E6%97%A5%E5%BF%97appender)
    * [2\.1 创建需要生成日记的客户端，导入依赖](#21-%E5%88%9B%E5%BB%BA%E9%9C%80%E8%A6%81%E7%94%9F%E6%88%90%E6%97%A5%E8%A
E%B0%E7%9A%84%E5%AE%A2%E6%88%B7%E7%AB%AF%E5%AF%BC%E5%85%A5%E4%BE%9D%E8%B5%96)
    * [2\.2 src/main/resources/ 目录下创建logback\-spring\.xml](#22-srcmainresources-%E7%9B%AE%E5%BD%95%E4%B8%8B%E5%88%9
B%E5%BB%BAlogback-springxml)
      * [参数说明  lqd\.log\.url 日记发送到的远程日记服务器IP\+端口](#%E5%8F%82%E6%95%B0%E8%AF%B4%E6%98%8E--lqdlogurl-%E
6%97%A5%E8%AE%B0%E5%8F%91%E9%80%81%E5%88%B0%E7%9A%84%E8%BF%9C%E7%A8%8B%E6%97%A5%E8%AE%B0%E6%9C%8D%E5%8A%A1%E5%99%A8ip%E7
%AB%AF%E5%8F%A3)
    * [2\.3 application\.properties  中加入配置](#23-applicationproperties--%E4%B8%AD%E5%8A%A0%E5%85%A5%E9%85%8D%E7%BD%A
E)
    * [2\.4 建立测试方法](#24-%E5%BB%BA%E7%AB%8B%E6%B5%8B%E8%AF%95%E6%96%B9%E6%B3%95)
    * [2\.5 改造logger\_filer ，用于接收 client发送的日记](#25-%E6%94%B9%E9%80%A0logger_filer-%E7%94%A8%E4%BA%8E%E6%8E%A
5%E6%94%B6-client%E5%8F%91%E9%80%81%E7%9A%84%E6%97%A5%E8%AE%B0)
    * [创建controller 数据接收接口](#%E5%88%9B%E5%BB%BAcontroller-%E6%95%B0%E6%8D%AE%E6%8E%A5%E6%94%B6%E6%8E%A5%E5%8F%A3
)
    * [2\.6启动测试](#26%E5%90%AF%E5%8A%A8%E6%B5%8B%E8%AF%95)
    * [2\.7 发送端数据过滤](#27-%E5%8F%91%E9%80%81%E7%AB%AF%E6%95%B0%E6%8D%AE%E8%BF%87%E6%BB%A4)
      * [并在logback\-spring\.xml文件中替换appender标签内容](#%E5%B9%B6%E5%9C%A8logback-springxml%E6%96%87%E4%BB%B6%E4%B
8%AD%E6%9B%BF%E6%8D%A2appender%E6%A0%87%E7%AD%BE%E5%86%85%E5%AE%B9)
    * [2\.8 完成配置](#28-%E5%AE%8C%E6%88%90%E9%85%8D%E7%BD%AE)
	
### ==========================================================

# 1、logger_filer  日记服务器，输出日子至本地
# 2、client  客户端，使用HTTP协议将日志推送到日志服务器

### ==========================================================


##  1 logger_filer 单机模式下开启日记
### 实现步骤：1.1 引入相关的依赖
```
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

### 1.2 src/main/resources/目录下创建logback.xml 日记配置文件
#### 内容如下：
#### 参数说明
##### logDir 自定义日记输出位置，默认项目相对路径 ：xx项目/log
##### maxHistory 日志最大保存时限

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <include resource="org/springframework/boot/logging/logback/base.xml"/>
    <logger name="org.springframework.web" level="debug"/>

    <!-- 定义日志文件 输入位置 -->
    <property name="logDir" value="log"/>
    <!-- 日志最大的历史 30天 -->
    <property name="maxHistory" value="30"/>

    <!-- 控制台输出日志 -->
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger -%msg%n</pattern>
            <charset class="java.nio.charset.Charset">UTF-8</charset>
        </encoder>
    </appender>

    <!-- ERROR级别日志 -->
    <appender name="ERROR" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <filter class="ch.qos.logback.classic.filter.LevelFilter">
            <level>ERROR</level>
            <onMatch>ACCEPT</onMatch>
            <onMismatch>DENY</onMismatch>
        </filter>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>${logDir}\%d{yyyyMMdd}\error.log</fileNamePattern>
            <maxHistory>${maxHistory}</maxHistory>
        </rollingPolicy>
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger - %msg%n</pattern>
            <charset class="java.nio.charset.Charset">UTF-8</charset>
        </encoder>
        <append>false</append>
        <prudent>false</prudent>
    </appender>

    <!-- WARN级别日志 -->
    <appender name="WARN" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <filter class="ch.qos.logback.classic.filter.LevelFilter">
            <level>WARN</level>
            <onMatch>ACCEPT</onMatch>
            <onMismatch>DENY</onMismatch>
        </filter>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>${logDir}\%d{yyyyMMdd}\warn.log</fileNamePattern>
            <maxHistory>${maxHistory}</maxHistory>
        </rollingPolicy>
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger - %msg%n</pattern>
            <charset class="java.nio.charset.Charset">UTF-8</charset>
        </encoder>
        <append>false</append>
        <prudent>false</prudent>
    </appender>

    <!-- INFO级别日志 -->
    <appender name="INFO" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <filter class="ch.qos.logback.classic.filter.LevelFilter">
            <level>INFO</level>
            <onMatch>ACCEPT</onMatch>
            <onMismatch>DENY</onMismatch>
        </filter>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>${logDir}\%d{yyyyMMdd}\info.log</fileNamePattern>
            <maxHistory>${maxHistory}</maxHistory>
        </rollingPolicy>
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger - %msg%n</pattern>
            <charset class="java.nio.charset.Charset">UTF-8</charset>
        </encoder>
        <append>false</append>
        <prudent>false</prudent>
    </appender>

    <!-- DEBUG级别日志 -->
    <appender name="DEBUG" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <filter class="ch.qos.logback.classic.filter.LevelFilter">
            <level>DEBUG</level>
            <onMatch>ACCEPT</onMatch>
            <onMismatch>DENY</onMismatch>
        </filter>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>${logDir}\%d{yyyyMMdd}\debug.log</fileNamePattern>
            <maxHistory>${maxHistory}</maxHistory>
        </rollingPolicy>
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger - %msg%n</pattern>
            <charset class="java.nio.charset.Charset">UTF-8</charset>
        </encoder>
        <append>false</append>
        <prudent>false</prudent>
    </appender>

    <!-- root级别  DEBUG -->
    <root level="INFO">
        <!-- 控制台输出 -->
        <appender-ref ref="STDOUT" />
        <!-- 文件输出 -->
        <appender-ref ref="ERROR" />
        <appender-ref ref="INFO" />
        <appender-ref ref="WARN" />
        <appender-ref ref="DEBUG" />
    </root>
</configuration>
```
### 1.3 application.properties  中加入配置
```
#指定日记配置文件位置
logging.config=classpath:logback.xml
server.port=9000
```

### 1.4 项目中，在需要监控的类中加入
```java
private static final Logger logger = LoggerFactory.getLogger(XXXX.class);
```
### 如:
```java
@RestController
public class Index {
    private static final Logger logger = LoggerFactory.getLogger(Index.class);
    @RequestMapping("/")
    public void test() {

        System.out.println("测试");
        logger.info("测试");
    }
}
```
### 1.5 启动项目，访问 localhost:9000 查看效果

### ==========================================================
### ==========================================================



## 2  分布式下统一管理日记，实现http日志appender

### 2.1 创建需要生成日记的客户端，导入依赖
```
<!--日记-->
        <dependency>
            <groupId>org.logback-extensions</groupId>
            <artifactId>logback-ext-loggly</artifactId>
            <version>0.1.5</version>
        </dependency>
```
### 2.2 src/main/resources/ 目录下创建logback-spring.xml
#### 参数说明  lqd.log.url 日记发送到的远程日记服务器IP+端口
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!--启用debug模式后，将在`spring-boot 大LOG`上方打印中logBack的配置信息-->
<configuration debug="true">
    <!--包含配置文件 org/springframework/boot/logging/logback/defaults.xml-->
    <include resource="org/springframework/boot/logging/logback/defaults.xml" />

    <!--定义变量LOG_FILE，值为${LO...}-->
    <property name="LOG_FILE" value="${LOG_FILE:-${LOG_PATH:-${LOG_TEMP:-${java.io.tmpdir:-/tmp}}}/spring.log}"/>

    <!--包含配置文件，该配置文件中，定义了 控制台日志是按什么规则，什么形式输出的-->
    <include resource="org/springframework/boot/logging/logback/console-appender.xml" />

    <!--包含配置文件，该配置文件中，定义了 文件日志是按什么规则，什么形式输出的-->
    <include resource="org/springframework/boot/logging/logback/file-appender.xml" />


    <springProperty scope="context" name="logUrl" source="lqd.log.url"
                    defaultValue="localhost"/>
    <!--引入第三方appender, 起名为http-->
    <appender name="HTTP" class="ch.qos.logback.ext.loggly.LogglyAppender">
        <!--请求的地址-->
        <endpointUrl>${logUrl}</endpointUrl>

<!--        定义过滤器-->
        <filter class="com.springboot.logback.config.Filter"/>
        <!--定义输出格式JSON-->
<!--        <layout class="ch.qos.logback.contrib.json.classic.JsonLayout">-->
<!--            <jsonFormatter-->
<!--                    class="ch.qos.logback.contrib.jackson.JacksonJsonFormatter">-->
<!--                <prettyPrint>true</prettyPrint>-->
<!--            </jsonFormatter>-->
<!--            <timestampFormat>yyyy-MM-dd' 'HH:mm:ss.SSS</timestampFormat>-->
<!--        </layout>-->

    </appender>
    <!--定义日志等级-->
    <root level="INFO">
        <!--启用第一个appender为CONSOLE, 该名称定义于org/springframework/boot/logging/logback/console-appender.xml中-->
        <appender-ref ref="CONSOLE" />

        <!--启用第二个appender为FILE, 该名称定义于org/springframework/boot/logging/logback/file-appender.xml中-->
        <appender-ref ref="FILE" />

        <!--启用第三个appender为HTTP-->
        <appender-ref ref="HTTP" />
    </root>
</configuration>
```
### 2.3 application.properties  中加入配置
```
lqd.log.url=http://localhost:9000/log

```
### 2.4 建立测试方法
```java

@RestController
public class Index {
    private static final Logger logger = LoggerFactory.getLogger(Index.class);
    @RequestMapping("/")
    public void test() {

        System.out.println("测试");
        logger.info("测试");
    }

    @RequestMapping("/send")
    public void send() {
        logger.info("info");
        logger.warn("warn>>>>>>>>>>"+"测试");
        logger.error("error>>>>>>>>>>"+"测试");
    }

}

```

### 2.5 改造logger_filer ，用于接收 client发送的日记
### 创建controller 数据接收接口
```java

@RestController
public class Index {
    private static final Logger logger = LoggerFactory.getLogger(Index.class);

    @RequestMapping("log")
    public void log(HttpServletRequest httpServletRequest) throws IOException {
        logger.info(httpServletRequest.toString());
        BufferedReader bufferedReader = httpServletRequest.getReader();
        String str, wholeStr = "";
        while ((str = bufferedReader.readLine()) != null) {
            wholeStr += str;
        }
        System.out.println("logger>>>>>>>>>>>>>>>>>>>>>>>" + wholeStr);
        if (wholeStr.contains("DEBUG")) {
            logger.debug(wholeStr);
        } else if (wholeStr.contains("ERROR")) {
            logger.error(wholeStr);
        } else if (wholeStr.contains("WARN")) {
            logger.warn(wholeStr);
        } else {
            logger.info(wholeStr);
        }
    }
}

```

### 2.6启动测试
使用debug模式来启动两个项目，项目启动后，打开浏览器，输入：http://localhost:8080/send，并在9000端口服务器上查询日记生成效果。

### 2.7 发送端数据过滤
```java
public class Filter extends AbstractMatcherFilter {

    @Override
    public FilterReply decide(Object event) {
        if (!isStarted()) {
            return FilterReply.NEUTRAL;
        }

        LoggingEvent loggingEvent = (LoggingEvent) event;

        // 当级别为warn或error，时触发日志。
        List<Level> eventsToKeep = Arrays.asList(Level.WARN, Level.ERROR);
        if (eventsToKeep.contains(loggingEvent.getLevel())) {
            return FilterReply.NEUTRAL;
        } else {
            return FilterReply.DENY;
        }
    }

}
```
#### 并在logback-spring.xml文件中替换appender标签内容
```xml

<appender name="HTTP" class="ch.qos.logback.ext.loggly.LogglyAppender">
        <!--请求的地址-->
        <endpointUrl>${logUrl}</endpointUrl>
<!--        定义过滤器-->
        <filter class="com.springboot.logback.config.Filter"/>
        <!--定义输出格式JSON-->
<!--        <layout class="ch.qos.logback.contrib.json.classic.JsonLayout">-->
<!--            <jsonFormatter-->
<!--                    class="ch.qos.logback.contrib.jackson.JacksonJsonFormatter">-->
<!--                <prettyPrint>true</prettyPrint>-->
<!--            </jsonFormatter>-->
<!--            <timestampFormat>yyyy-MM-dd' 'HH:mm:ss.SSS</timestampFormat>-->
<!--        </layout>-->
    </appender>
```

### 2.8 完成配置
在分布式系统中，这样我们就可以统一对日记进行管理了。