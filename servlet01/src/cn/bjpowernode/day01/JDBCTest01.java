package cn.bjpowernode.day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest01 {
    public static void main(String[] args) {
//        使用JDBC技术对DML语句进行操作
        Connection connection=null;
        Statement statement=null;
        try {
            // 1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
//            2.获取连接
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bjpowernode", "root", "311251");
//            3.获取数据库操作对象
            statement = connection.createStatement();
//            4.执行sql语句
            String sql="update emp set ename='SMITH' where empno=7369";
            int i = statement.executeUpdate(sql);//返回值是执行sql语句之后，影响的字段数！
            System.out.println(i==1 ? "操作成功" : "操作失败");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
//            5.关闭流
//            注意：关闭流的顺序：先开的后关，后开的先关！！
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
