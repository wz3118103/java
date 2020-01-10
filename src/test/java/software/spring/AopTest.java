package software.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import software.spring.aop.Calculator;
import software.spring.aop.config.MainConfig;
import software.spring.aop.xml.HelloServiceBo;

public class AopTest {
    @Test
    public void test() {
        AnnotationConfigApplicationContext acc = new AnnotationConfigApplicationContext(MainConfig.class);
        Calculator calculator = acc.getBean(Calculator.class);
        calculator.div(1, 1);
    }

    @Test
    public void testXmlAop() {
        ClassPathXmlApplicationContext cpxa =
                new ClassPathXmlApplicationContext("classpath:software/spring/aop/xml/beanaop.xml");
        HelloServiceBo serviceBo = cpxa.getBean("helloService", HelloServiceBo.class);
        serviceBo.sayHello(" I love you");
        System.out.println();

        String result = serviceBo.sayHelloAround("I love you");
        System.out.println(result);
        System.out.println();

        result = serviceBo.sayHelloAfterReturn("I love you");
        System.out.println(result);
        System.out.println();

        serviceBo.sayHelloAdvisor("I love you");
        System.out.println();

        serviceBo.sayHelloThrowExecption();
    }
}
