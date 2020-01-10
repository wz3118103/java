package software.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import software.spring.lifecycle.config.MainConfig;

public class LifeCycleTest {
    @Test
    public void test() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class);
        System.out.println("IOC容器创建完成");
        System.out.println("AnnotationConfigApplicationContext: "+ ac);
        ac.close();
    }
}
