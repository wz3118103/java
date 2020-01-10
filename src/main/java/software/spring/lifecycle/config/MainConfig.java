package software.spring.lifecycle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import software.spring.lifecycle.bean.Bike;

@ComponentScan("software.spring.lifecycle.bean")
@Configuration
public class MainConfig {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Bike bike() {
        return new Bike();
    }
}
