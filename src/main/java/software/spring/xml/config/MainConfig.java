package software.spring.xml.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.spring.xml.Person;

@Configuration
public class MainConfig {
    @Bean("aPerson")
    public Person person() {
        return new Person("wang", 20);
    }
}
