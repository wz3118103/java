package software.spring.lifecycle.bean;

public class Bike {
	public Bike(){
		System.out.println("Bike constructor..............");
	}
	public void init(){
		System.out.println("Bike .....init.....");
	}
	public void destroy(){
		System.out.println("Bike.....destroy");
	}
}
