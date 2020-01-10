package software.spring.condition.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import software.spring.condition.entity.Person;


@Configuration
public class MainConfig {

    @Bean
    public Person person() {
        return new Person("wang", 20);
    }

    @Conditional(WindowsCondition.class)
    @Bean
    public Person lison() {
        return new Person("lison", 20);
    }

    @Conditional(LinuxCondition.class)
    @Bean
    public Person james() {
        return new Person("james", 20);
    }
}
