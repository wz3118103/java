package software.mybatis.jdbc;


import org.junit.Test;
import software.mybatis.entity.TUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemo {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://119.3.135.196:3306/mybatis?" +
            "useUnicode=true&characterEncoding=utf8";

    static final String USER = "work";
    static final String PASS = "Wz3118103y!";

    @Test
    public void queryStatementDemo() {
        Connection conn = null;
        Statement stmt = null;
        List<TUser> users = new ArrayList<>();
        try {
            // step1.注册mysql驱动
            Class.forName(JDBC_DRIVER);

            // step2.获取一个连接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // step3.创建一个查询
            stmt = conn.createStatement();
            String userName = "lison";
            String sql = "select * from t_user where user_name='" + userName + "'";
            ResultSet rs = stmt.executeQuery(sql);

            // step4.从ResultSet中获取数据并转换成bean
            while (rs.next()) {
                TUser user = new TUser();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("user_name"));
                user.setRealName(rs.getString("real_name"));
                user.setSex(rs.getByte("sex"));
                user.setMobile(rs.getString("mobile"));
                user.setEmail(rs.getString("email"));
                user.setNote(rs.getString("note"));
                users.add(user);
            }

            // step5.关闭连接
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {

            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
