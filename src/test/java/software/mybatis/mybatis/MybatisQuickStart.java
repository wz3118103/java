package software.mybatis.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import software.mybatis.entity.TUserQuickStart;
import software.mybatis.mapper.TUserMapperQuickStart;

import java.io.IOException;
import java.io.InputStream;

public class MybatisQuickStart {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        String resource = "software/mybatis/mybatis-quickstart-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
    }

    @Test
    public void quickStart() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TUserMapperQuickStart mapper = sqlSession.getMapper(TUserMapperQuickStart.class);
        TUserQuickStart user = mapper.selectByPrimaryKey(1);
        System.out.println(user);
    }
}
