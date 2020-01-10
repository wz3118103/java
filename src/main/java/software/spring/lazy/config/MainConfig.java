package software.spring.lazy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import software.spring.lazy.entity.Person;

/**
 * 懒加载: 主要针对单实例bean:默认在容器启动的时候创建对象
 * 懒加载:容器启动时候不创建对象, 仅当第一次使用(获取)bean的时候才创建被初始化
 */
@Configuration
public class MainConfig {

    //@Lazy
    @Bean
    public Person person() {
        System.out.println("添加person");
        return new Person("wang", 20);
    }
}
