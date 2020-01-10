package software.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
    public void beforeAdvice(String content) {
        System.out.println("---before advice "+ content + "---");
    }

    public void afterAdvice(JoinPoint jp) {
        System.out.println("---after advice " + jp.getArgs()[0].toString()+"---");
    }

    public Object afterReturningAdvice(Object value) {
        System.out.println("---afterReturning advice " + value+"---");
        return value + " ha";
    }

    public void afterThrowingAdvice(Exception e) {
        System.out.println("---after throwing advice exception:" + e+"---");
    }

    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {

        Object[] obj = pjp.getArgs();
        String content = (String) obj[0];
        System.out.println("---before sayHelloAround execute---");
        String  retVal = (String) pjp.proceed();
        System.out.println("---after sayHelloAround execute---");

        return retVal+ " suffix";
    }
}
