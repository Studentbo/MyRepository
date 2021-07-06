package cn.bjpowernode.servlet.day02;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class HelloWorldServlet extends HttpServlet {
    public HelloWorldServlet() {
        System.out.println("我胡汉三回来了");

    }
    //第一步.编写servlet类，继承HttpServlet
    //第二步.重写doGet和doPost方法
//    这个就是html之前学习的两种请求方式 get（显示数据）和post（隐藏数据）

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String servletName = this.getServletName();
        System.out.println(servletName);
        //数组   里面都是键的值
        Enumeration<String> names = this.getInitParameterNames();
        while(names.hasMoreElements()){//判断里面是否有元素
            //获取到里面的键
            String s=names.nextElement();
            System.out.println(s);
            //通过 getInitParameter方法，传入键
            System.out.println(this.getInitParameter(s));
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost方法请求");
    }
    // 第三步.写xml文件
}
