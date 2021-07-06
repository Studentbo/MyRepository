package cn.bjpowernode.day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest05 {
    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement  ps1=null;
        PreparedStatement  ps2=null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","311251");
            //获取对象，执行sql语句
            //设置事务提交方式，修改为手动提交方式
            connection.setAutoCommit(false);
            //sql语句，获取操作对象
            //转出
            String sql="update account set balance=balance+500 where aid=?";
            ps1=connection.prepareStatement(sql);
            ps1.setInt(1,1001);
            ps1.executeUpdate();
           /* String s=null;
            s.length();*/
            //收到转账
            sql="update account set balance=balance-500 where aid=?";
            ps2=connection.prepareStatement(sql);
            ps2.setInt(1,1002);
            ps2.executeUpdate();
            //提交事务
            connection.commit();
            System.out.println("转账成功");
        } catch (Exception e) {
            //为什么将这里的异常换为Exception，异常范围越大，只要出现异常就回滚
            //一旦出现异常就回滚
            try {
                System.out.println("转账失败");
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            //关闭资源一定放在finally中，万一出异常就无法关闭资源
            JDBCUtile.closeAll(null,ps2,null);
            JDBCUtile.closeAll(connection,ps1,null);
        }
    }
}
