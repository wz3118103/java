package software.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import software.spring.componentscan.config.MainConfig;
import software.spring.componentscan.config.MainConfig2;

public class ComponentScanTest {

    @Test
    public void test() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void testCustom() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }
}
