package software.spring.di.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import software.spring.di.dao.TestDao;

@Service
public class TestService {
    @Qualifier("testDao")//指定名称来加载
	@Autowired
	private TestDao testDao;//如果使用Autowired, testDao2, 找到TestDao类型的
	
	public void println(){
		System.out.println("Service...dao...."+testDao);
	}
}
