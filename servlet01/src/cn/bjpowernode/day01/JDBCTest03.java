package cn.bjpowernode.day01;

import java.sql.*;
import java.util.Scanner;

public class JDBCTest03 {
    public static void main(String[] args) {
        //statement存在的问题
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的账号：");
        String user = sc.nextLine();
        System.out.println("请输入您的密码：");
        String password = sc.nextLine();
        Connection connection=null;
        Statement statement=null;
        ResultSet result=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","311251");
            statement=connection.createStatement();
            String sql="select*from s1 where id='"+user+"' and password='"+password+"'";
            System.out.println(sql);
            result=statement.executeQuery(sql);
            System.out.println(result.next() ? "登录成功":"用户名或密码错误");
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
