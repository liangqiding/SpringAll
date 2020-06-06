# 1 启动springboot

## 1.1 pom.xml文件中引入 spring-boot-starter-web 依赖
```
      <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
```

## 1.2 创建 controller/IndexController.java ,Controller（控制器）是应用程序中处理用户交互的部分
```java
@Controller
public class IndexController {
    @RequestMapping("/")
        @ResponseBody
        public String get() {
            return "hello work";
        }
}
```
## 1.3 运行程序
浏览器输入 localhost:8080 查看效果