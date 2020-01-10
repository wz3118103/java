package software.spring.postprocessor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import software.spring.postprocessor.bean.Moon;

@Configuration
@ComponentScan("software.spring.postprocessor.processor")
public class MainConfig {
    @Bean
    public Moon getMoon() {
        return new Moon();
    }
}
