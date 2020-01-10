package software.spring.value.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import software.spring.value.bean.Bird;

@Configuration
@PropertySource(value = "classpath:software/spring/value/test.properties")
public class MainConfig {
    @Bean
    public Bird bird() {
        return new Bird();
    }
}
