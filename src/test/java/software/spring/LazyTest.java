package software.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import software.spring.lazy.config.MainConfig;

public class LazyTest {

        @Test
        public void test() {
            ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class);
            System.out.println("IOC容器创建完成");
            ac.getBean("person");
        }
}
