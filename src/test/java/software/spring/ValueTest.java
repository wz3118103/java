package software.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import software.spring.value.bean.Bird;
import software.spring.value.config.MainConfig;

public class ValueTest {
    @Test
    public void test() {
        AnnotationConfigApplicationContext acc = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] names = acc.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        Bird bird = (Bird) acc.getBean("bird");
        System.out.println(bird);
    }
}
