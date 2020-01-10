package software.spring.createbean.config;

import org.springframework.beans.factory.FactoryBean;
import software.spring.createbean.bean.Monkey;

public class WangFactoryBean implements FactoryBean<Monkey> {
    @Override
    public Monkey getObject() throws Exception {
        return new Monkey();
    }

    @Override
    public Class<?> getObjectType() {
        return Monkey.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
