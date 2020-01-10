package software.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import software.spring.condition.config.MainConfig;

public class ConditonTest {

    @Test
    public void test() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }
}
