package software.spring.aop.xml;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

class TracingInterceptor implements MethodInterceptor {
    public Object invoke(MethodInvocation i) throws Throwable {
        System.out
                .println("---method " + i.getMethod() + " is called on " + i.getThis() + " with args " + i.getArguments()+"---");
        Object ret = i.proceed();
        System.out.println("---method " + i.getMethod() + " returns " + ret+"---");
        return ret;
    }
}
