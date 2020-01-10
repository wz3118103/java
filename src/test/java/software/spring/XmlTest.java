package software.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import software.spring.xml.Person;
import software.spring.xml.config.MainConfig;

public class XmlTest {

    @Test
    public void testLoadXml() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:software/spring/xml/beans.xml");
        Person person = (Person) ac.getBean("person");
        System.out.println(person);
    }

    @Test
    public void testLoadConfig() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = (Person) ac.getBean("aPerson");
        System.out.println(person);

        String[] names = ac.getBeanNamesForType(Person.class);
        for (String name : names) {
            System.out.println(name);
        }
    }
}
