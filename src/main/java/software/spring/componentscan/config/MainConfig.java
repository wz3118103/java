package software.spring.componentscan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import software.spring.componentscan.entity.Person;

@Configuration
@ComponentScan(value = "software.spring.componentscan", includeFilters = {
        @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = {Controller.class})
}, useDefaultFilters = false)
public class MainConfig {
    @Bean
    public Person person() {
        return new Person("wang", 20);
    }
}
