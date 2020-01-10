package software.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import software.spring.scope.config.MainConfig;

public class ScopeTest {

    @Test
    public void test() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("=================");

        Object bean1 = ac.getBean("person");
        Object bean2 = ac.getBean("person");
        System.out.println(bean1 == bean2);
    }
}
