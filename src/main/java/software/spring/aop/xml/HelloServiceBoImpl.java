package software.spring.aop.xml;

public class HelloServiceBoImpl implements HelloServiceBo{

    @Override
    public void sayHello(String content) {
        System.out.println("sayHello:" + content);
    }

    @Override
    public String sayHelloAround(String content) {
        System.out.println(" sayHelloAround:" + content);
        return content;
    }

    @Override
    public String sayHelloAfterReturn(String content) {
        System.out.println("sayHelloAround:" + content);
        return content;
    }

    @Override
    public void sayHelloThrowExecption() {
        System.out.println("sayHelloThrowExecption");
        throw new RuntimeException("hello Im an exception");
    }

    @Override
    public void sayHelloAdvisor(String content) {
        System.out.println("hello advisor! " + content);
    }
}