package cn.bjpowernode.servlet.day03;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/Servlet01")
public class Servlet01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("呵呵呵呵呵。。。。");
//        获取servletContext作用域对象
        ServletContext servletContext = this.getServletContext();
//        通过作用域对象获取到全局初始化参数
        String s1 = servletContext.getInitParameter("1");
        String s2 = servletContext.getInitParameter("2");
        Enumeration<String> names = servletContext.getInitParameterNames();
        while (names.hasMoreElements()) {
            String s = names.nextElement();
            System.out.println(s+","+servletContext.getInitParameter(s));
        }
        System.out.println(names);
        System.out.println(s1 + "--------" + s2);
        servletContext.setAttribute("number", 0);
    }
}
