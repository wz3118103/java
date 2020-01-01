package software.mybatis.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import software.mybatis.spring.service.UserService;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:software/mybatis/spring/applicationContext.xml")
public class MybatisSpringTest {

	@Resource
	private UserService us;
	
	@Test
	public void TestSpringMybatis(){
		System.out.println(us.getUserById(1).toString());
	}
	
}
