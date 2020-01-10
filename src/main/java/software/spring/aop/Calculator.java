package software.spring.aop;

public class Calculator {
	//业务逻辑方法
	public int div(int i, int j)  {
		System.out.println("正在进行计算--------");
		return i/j;
	}
	
}
