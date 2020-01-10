package software.spring.createbean.config;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import software.spring.createbean.bean.Pig;

public class WangImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean containsDog = registry.containsBeanDefinition("software.spring.createbean.bean.Dog");
        boolean containsCat = registry.containsBeanDefinition("software.spring.createbean.bean.Cat");
        if (containsCat && containsDog) {
            RootBeanDefinition beanDefinition = new RootBeanDefinition(Pig.class);
            registry.registerBeanDefinition("pig", beanDefinition);
        }
    }
}
