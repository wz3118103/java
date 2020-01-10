package software.spring.aop.xml;

public interface HelloServiceBo {

    public void sayHello(String content);

    public String sayHelloAround(String content);

    public String sayHelloAfterReturn(String content);

    public void sayHelloThrowExecption();

    public void sayHelloAdvisor(String content);

}
