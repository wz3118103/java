package software.mybatis.jdbc;


import org.junit.Test;
import software.mybatis.demo.entity.TUser;

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


    @Test
    public void QueryPreparedStatementDemo() {
        Connection conn = null;
        PreparedStatement stmt = null;
        List<TUser> users = new ArrayList<>();
        try {
            // STEP 2: 注册mysql的驱动
            Class.forName(JDBC_DRIVER);

            // STEP 3: 获得一个连接
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // STEP 4: 创建一个查询
            System.out.println("Creating statement...");
            String sql;
            sql = "SELECT * FROM t_user where user_name= ? ";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "lison");
            System.out.println(stmt.toString());//打印sql
            ResultSet rs = stmt.executeQuery();


            // STEP 5: 从resultSet中获取数据并转化成bean
            while (rs.next()) {
                System.out.println("------------------------------");
                // Retrieve by column name
                TUser user = new TUser();
//				user.setId(rs.getInt("id"));
//				user.setUserName(rs.getString("user_name"));
                user.setRealName(rs.getString("real_name"));
                user.setSex(rs.getByte("sex"));
                user.setMobile(rs.getString("mobile"));
                user.setEmail(rs.getString("email"));
                user.setNote(rs.getString("note"));

                System.out.println(user.toString());

                users.add(user);
            }
            // STEP 6: 关闭连接
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("-------------------------");
        System.out.println("there are "+users.size()+" users in the list!");
    }

    @Test
    public void updateDemo(){
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // STEP 2: 注册mysql的驱动
            Class.forName(JDBC_DRIVER);

            // STEP 3: 获得一个连接
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // STEP 4: 启动手动提交
            conn.setAutoCommit(false);


            // STEP 5: 创建一个更新
            System.out.println("Creating statement...");
            String sql = "update t_user  set mobile= ? where user_name= ? ";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "186995587411");
            stmt.setString(2, "lison");
            System.out.println(stmt.toString());//打印sql
            int ret = stmt.executeUpdate();
            System.out.println("此次修改影响数据库的行数为："+ret);

            // STEP 6: 手动提交数据
            conn.commit();

            // STEP 7: 关闭连接
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            try {
                conn.rollback();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            se.printStackTrace();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
