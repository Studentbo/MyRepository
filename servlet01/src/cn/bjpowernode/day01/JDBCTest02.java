package cn.bjpowernode.day01;

import java.sql.*;

public class JDBCTest02 {
    public static void main(String[] args) {
//        jdbc对DQL语句的操作
        Connection connection=null;
        Statement statement=null;
        ResultSet result=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode", "root", "311251");
            statement = connection.createStatement();
            String sql="select empno,ename,sal from emp";
            result = statement.executeQuery(sql);
            while(result.next()){
                System.out.println(result.getInt(1)+","+result.getString(2)+","+result.getDouble(3));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
