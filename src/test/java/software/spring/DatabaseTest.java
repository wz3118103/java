package software.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import software.spring.database.annotation.config.MainConfig;
import software.spring.database.service.OrderService;


public class DatabaseTest {
    @Test
    public void test() {
        AnnotationConfigApplicationContext acc = new AnnotationConfigApplicationContext(MainConfig.class);
        OrderService orderService = acc.getBean(OrderService.class);
        orderService.addOrder();
        acc.close();
    }

    @Test
    public void testXml() {
        ApplicationContext acc = new ClassPathXmlApplicationContext(
                "classpath:software/spring/database/xml/beanaop.xml");
        OrderService orderService = acc.getBean(OrderService.class);
        orderService.addOrder();
    }
}
