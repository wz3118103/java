package software.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import software.spring.createbean.bean.Monkey;
import software.spring.createbean.config.MainConfig;
import software.spring.createbean.config.WangFactoryBean;

public class CreateBeanTest {
    @Test
    public void test() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("=================");
        Object bean1 = ac.getBean("monkey1");
        Object bean2 = ac.getBean("monkey1");
        Object bean3 = ac.getBean("monkey2");
        System.out.println(bean1.getClass());
        System.out.println(bean1 == bean2);
        System.out.println(bean2 == bean3);
        System.out.println("namesForMonkey:");
        String[] namesForMonkey = ac.getBeanNamesForType(Monkey.class);
        for (String name : namesForMonkey) {
            System.out.println(name);
        }
        System.out.println("namesForFactory:");
        String[] namesForFactory = ac.getBeanNamesForType(WangFactoryBean.class);
        for (String name : namesForFactory) {
            System.out.println(name);
        }
        System.out.println("&monkey1:");
        Object bean4 = ac.getBean("&monkey1");
        System.out.println(bean4.getClass());
    }
}
