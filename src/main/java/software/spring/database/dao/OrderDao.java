package software.spring.database.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	//操作数据的方法
	public void insert(){
		String sql = "insert into `t_user` (user_name, real_name, sex) values(?,?,?)";
		jdbcTemplate.update(sql,"wang", "king", 1);
	}
}
