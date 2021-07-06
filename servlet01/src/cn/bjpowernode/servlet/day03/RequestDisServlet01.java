package cn.bjpowernode.servlet.day03;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/requestDisServlet01")
public class RequestDisServlet01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        //在request作用域中设置键值对
        request.setAttribute("1","bobob");
        System.out.println(request.hashCode());
        //使用请求转发,获取请求转发对象
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("requestDisServlet02");
        //请求转发对象调用方法
        requestDispatcher.forward(request,response);
        System.out.println("程序结束");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
