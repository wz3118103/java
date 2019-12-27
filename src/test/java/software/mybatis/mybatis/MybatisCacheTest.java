package software.mybatis.mybatis;

import software.mybatis.entity.TUser;
import software.mybatis.mapper.TJobHistoryMapper;
import software.mybatis.mapper.TUserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class MybatisCacheTest {
	
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void init() throws IOException {
		
		String resource = "software/mybatis/mybatis-demo-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 1.读取mybatis配置文件创SqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		inputStream.close();
	}

	@Test
	public void Test1LevelCache(){
		SqlSession session1 = sqlSessionFactory.openSession();
		TUserMapper userMapper1 = session1.getMapper(TUserMapper.class);
		String email = "qq.com";
		Byte sex = 1;
		List<TUser> list1 = userMapper1.selectByEmailAndSex2(email, sex);
		System.out.println(list1.size());
		
		
		//增删改操作会清空一级缓存和二级缓存
//		TUser userInsert = new TUser();
//		userInsert.setUserName("test1");
//		userInsert.setRealName("realname1");
//		userInsert.setEmail("myemail1");
//		userMapper1.insert1(userInsert);
		
		
		List<TUser> list2 = userMapper1.selectByEmailAndSex2(email, sex);
		System.out.println(list2.toString());
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("email", email);
		map.put("sex", sex);
		
		List<TUser> list3 = userMapper1.selectByEmailAndSex1(map);
		System.out.println(list3.toString());
		
		
		session1.close();
		
		
		SqlSession session2 = sqlSessionFactory.openSession();
		TUserMapper userMapper2 = session2.getMapper(TUserMapper.class);
		List<TUser> list4 = userMapper2.selectByEmailAndSex2(email, sex);
		System.out.println(list2.toString());
		session1.close();
		
		
	}
	
	
	@Test
	public void Test2LevelCache(){
		SqlSession session1 = sqlSessionFactory.openSession();
		TUserMapper userMapper1 = session1.getMapper(TUserMapper.class);
		String email = "qq.com";
		Byte sex = 1;
		List<TUser> list1 = userMapper1.selectByEmailAndSex2(email, sex);
		System.out.println(list1.size());
		
		
//		TUser userInsert = new TUser();
//		userInsert.setUserName("test1");
//		userInsert.setRealName("realname1");
//		userInsert.setEmail("myemail1");
//		userMapper1.insert1(userInsert);
		
		List<TUser> list2 = userMapper1.selectByEmailAndSex2(email, sex);
		System.out.println(list2.toString());
		session1.close();
		
		
		SqlSession session2 = sqlSessionFactory.openSession();
		TUserMapper userMapper2 = session2.getMapper(TUserMapper.class);
		List<TUser> list3 = userMapper2.selectByEmailAndSex2(email, sex);
		System.out.println(list3.toString());
		session2.close();
		
		SqlSession session3 = sqlSessionFactory.openSession();
		TJobHistoryMapper userMapper3 = session3.getMapper(TJobHistoryMapper.class);
		List<TUser> list4 = userMapper3.selectByEmailAndSex2(email, sex);
		System.out.println(list4.toString());
		session3.close();
	}

	@Test
	public void Test2LevelCacheConsistence(){
		SqlSession session1 = sqlSessionFactory.openSession();
		TUserMapper userMapper1 = session1.getMapper(TUserMapper.class);
		String email = "qq.com";
		Byte sex = 1;
		List<TUser> list1 = userMapper1.selectByEmailAndSex2(email, sex);
		System.out.println(list1.size());


		SqlSession session3 = sqlSessionFactory.openSession();
		TJobHistoryMapper userMapper3 = session3.getMapper(TJobHistoryMapper.class);
		List<TUser> list4 = userMapper3.selectByEmailAndSex2(email, sex);
		System.out.println(list4.toString());
		session3.close();

		TUser userInsert = new TUser();
		userInsert.setUserName("test1");
		userInsert.setRealName("realname1");
		userInsert.setEmail("myemail1");
		userMapper1.insert1(userInsert);

		List<TUser> list2 = userMapper1.selectByEmailAndSex2(email, sex);
		System.out.println(list2.toString());
		session1.close();


		SqlSession session2 = sqlSessionFactory.openSession();
		TUserMapper userMapper2 = session2.getMapper(TUserMapper.class);
		List<TUser> list3 = userMapper2.selectByEmailAndSex2(email, sex);
		System.out.println(list3.toString());
		session2.close();


		SqlSession session4 = sqlSessionFactory.openSession();
		TJobHistoryMapper userMapper4 = session4.getMapper(TJobHistoryMapper.class);
		List<TUser> list5 = userMapper4.selectByEmailAndSex2(email, sex);
		System.out.println(list5.toString());
		session4.close();
	}
}
