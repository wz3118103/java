package software.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import software.spring.postprocessor.config.MainConfig;

public class PostProcessorTest {
    @Test
    public void test() {
        AnnotationConfigApplicationContext acc = new AnnotationConfigApplicationContext(MainConfig.class);
        System.out.println("IOC容器完成");
        acc.close();
    }
}
