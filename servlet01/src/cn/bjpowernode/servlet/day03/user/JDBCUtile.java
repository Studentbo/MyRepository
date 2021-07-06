package cn.bjpowernode.servlet.day03.user;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtile {
//因为连接数据库的驱动只需要运行一次就可以了，所以在类加载的过程
    private static Connection connection=null;
    private static String driver ;
    private static String url ;
    private static String user ;
    private static String password ;
    //注册驱动
    static{
        //注册驱动只需要一次，所以在类加载的执行就可以了
//如果放在方法或者其他地方，那每调用一次方法就需要注册驱动一次
//        ResourceBundle jdbc = ResourceBundle.getBundle("JDBC");
        Properties properties = new Properties();

        try {
            properties.load(JDBCUtile.class.getClassLoader().getResourceAsStream("JDBC.properties"));
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //建立连接，获取连接对象
    public static Connection getConnection() throws SQLException {
        connection= DriverManager.getConnection(url,user,password);
        return connection;
    }
    //关闭资源
    public static void closeAll(Connection connection, Statement statement, ResultSet result){
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
