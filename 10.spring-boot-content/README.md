#  github markdown 文件生成目录(toc)

## 目录


## 介绍
Github Markdown 文件一键生成目录

* 支持 fluent 优雅的写法

* 支持多次生成

* 支持重复标题的生成

* 支持特殊字符的过滤

* 支持指定不同的文件编码

* 支持文件夹的文件批量处理(可指定是否包含子文件夹文件)

* 支持是否写入文件，可返回目录的内容，便于用户自行处理

## 1 起步
### 1.1 配置pom
>引入markdown-toc依赖
```xml
<!--        md 文件目录自动生成-->
        <dependency>
            <groupId>com.github.houbb</groupId>
            <artifactId>markdown-toc</artifactId>
            <version>1.0.2</version>
        </dependency>
```
### 1.2 编写测试类
```java
@SpringBootTest
class ContentApplicationTests {


   final String path="E:\\myGitHub\\FormatMD\\README.md";

    /**
     * @Author QiDing
     * @Description //TODO 文件会自动生成并添加到该md文件中
     * @Date 11:25 2020/7/2 0002
    **/
    @Test
    void contextLoads() {
        AtxMarkdownToc.newInstance()
                .charset("UTF-8")
                .write(true)
                .subTree(true)
        .genTocFile(path);
    }
}
```
### 1.3 运行生成目录
> 指定README.md 文件存放路径，运行测试类，成功运行后再次打开该文件，效果如下

![目录效果](https://gitee.com/liangqiding/static/raw/master/SpringAll/10/01.png)

### 1.4 markdown-toc参数说明

| 序号        | 属性   |  默认值   |  说明 |
| --------    | ----- | -----  | -----    |
| 1      | charset  |   UTF-8   |  文件编码      |
| 2        |   write  |   true  |    是否将 toc 写入文件(默认写入)    |
| 3        |   subTree  |   true  |   是否包含子文件夹的文件(默认包含)   |
| 4        |   genTocFile()  |     |   读取单个文件   |
| 5        |   genTocDir()  |     |   读取文件夹多个文件   |