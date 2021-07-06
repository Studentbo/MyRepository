package cn.bjpowernode.day01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DemoTest {
    public static void main(String[] args) {
        try {
            Connection connection = JDBCUtile.getConnection();
            String sql="update emp set ename=? where ename=?";
            PreparedStatement ps = connection.prepareStatement(sql);
           /* ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getString("ename"));
            }*/
           ps.setString(1,"123");
           ps.setString(2,"smith");
           int i = ps.executeUpdate();
            System.out.println(i);
            System.out.println(i==1 ? "修改成功":"失败");
            JDBCUtile.closeAll(connection,ps,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
