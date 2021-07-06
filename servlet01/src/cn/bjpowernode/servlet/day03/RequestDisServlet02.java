package cn.bjpowernode.servlet.day03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/requestDisServlet02")
public class RequestDisServlet02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        out.print(username);
        out.print(password);
        //在request作用域中获取设置的值
        String attribute = (String)request.getAttribute("1");
        out.print(attribute);
        System.out.println(request.hashCode());

        System.out.println("RequestDisServlet02类结束了");
    }
}
