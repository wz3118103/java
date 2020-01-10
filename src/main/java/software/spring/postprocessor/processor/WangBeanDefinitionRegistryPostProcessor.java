package software.spring.postprocessor.processor;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.stereotype.Component;
import software.spring.postprocessor.bean.Moon;

@Component
public class WangBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("WangBeanDefinitionProcessor..postProcessBeanFactory(),Bean的数量"+beanFactory.getBeanDefinitionCount());
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("WangBeanDefinition.postProcessBeanDefinitionRegistry()...bean的数量"+registry.getBeanDefinitionCount());
//		RootBeanDefinition rbd = new RootBeanDefinition(Moon.class);
		AbstractBeanDefinition rbd = BeanDefinitionBuilder.rootBeanDefinition(Moon.class).getBeanDefinition();
		registry.registerBeanDefinition("hello", rbd);
	}

}
