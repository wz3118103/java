package software.spring.postprocessor.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class WangBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("WangBeanFactoryPostProcessor.....调到了BeanFactoryPostProcessor.postProcessBeanFactory()");
		//所有bean的定义，已经加载到beanFactory, 但是bean实例还没创建
		int count = beanFactory.getBeanDefinitionCount();
		String[] beanDefName = beanFactory.getBeanDefinitionNames();
		System.out.println("当前BeanFactory中有"+count+"个Bean");
		System.out.println(Arrays.asList(beanDefName));
		
	}

}
