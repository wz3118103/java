package software.mybatis.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import software.mybatis.service.UserService;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:software/mybatis/applicationContext.xml")
public class MybatisSpringTest {

	@Resource
	private UserService us;
	
	@Test
	public void TestSpringMybatis(){
		System.out.println(us.getUserById(1).toString());
	}
	
}
