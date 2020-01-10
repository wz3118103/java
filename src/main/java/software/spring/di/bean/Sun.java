package software.spring.di.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sun {
	//@Autowired
	private Moon moon;
	
	public Sun(@Autowired Moon moon){
		this.moon = moon;
		System.out.println("..Constructor................");
	}
	public Moon getMoon() {
		return moon;
	}

	//@Autowired
	public void setMoon(Moon moon) {
		this.moon = moon;
	}

	@Override
	public String toString() {
		return "Sun [moon=" + moon + "]";
	}
}
