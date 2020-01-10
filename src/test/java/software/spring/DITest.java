package software.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import software.spring.di.bean.Moon;
import software.spring.di.bean.Sun;
import software.spring.di.config.MainConfig;
import software.spring.di.dao.TestDao;
import software.spring.di.service.TestService;

public class DITest {
    @Test
    public void test() {
        AnnotationConfigApplicationContext acc = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] names = acc.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("====================");

        TestService testService = acc.getBean(TestService.class);
        testService.println();
        TestDao testDao = acc.getBean(TestDao.class);
        System.out.println(testDao);
        System.out.println("====================");

        Moon monn = acc.getBean(Moon.class);
        System.out.println(monn);
        Sun sun = acc.getBean(Sun.class);
        System.out.println(sun.getMoon());

        acc.close();
    }
}
