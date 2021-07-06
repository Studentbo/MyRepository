package cn.bjpowernode.servlet.day02;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet01 extends HttpServlet {//1.首先继承HttpServlet类

    //必须要有一个无参构造方法，保证服务器用反射（无参构造）可以成功创建对象
    public Servlet01() {
        System.out.println("胡汉三回来啦");
    }
    //2.重写doGet和doPost方法
    //因为这两个方法需要处理浏览器发送的get和post请求
    //3.配置xml文件

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("胡汉三的doGet方法");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("胡汉三的doGet方法");
    }
}
