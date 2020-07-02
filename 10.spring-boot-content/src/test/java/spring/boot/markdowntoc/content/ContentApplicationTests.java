package spring.boot.markdowntoc.content;

import com.github.houbb.markdown.toc.core.impl.AtxMarkdownToc;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
