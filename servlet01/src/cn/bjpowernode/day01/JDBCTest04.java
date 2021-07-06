package cn.bjpowernode.day01;

import java.sql.*;
import java.util.Scanner;

public class JDBCTest04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的账号：");
        String user = sc.nextLine();
        System.out.println("请输入您的密码：");
        String password = sc.nextLine();
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet result=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","311251");
            String sql="select*from s1 where id=? and password=?";
            ps=connection.prepareStatement(sql);
            ps.setString(1,user);
            ps.setString(2,password);
            System.out.println(sql);
            result=ps.executeQuery();
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
            if (ps != null) {
                try {
                    ps.close();
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
