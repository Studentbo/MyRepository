package cn.bjpowernode.servlet.day03;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet( "/DemoServlet")
public class DemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码方式，
        response.setContentType("text/html;charset=utf-8");
        //获取输出流
        PrintWriter out = response.getWriter();
        //获取访问电脑的IP地址
        String remoteAddr = request.getRemoteAddr();
        //获取全局作用域对象
        ServletContext servletContext = this.getServletContext();
//用setAttribute设置的数据，必须用getAttribute去获取
        int i = (Integer)servletContext.getAttribute("number");
        servletContext.removeAttribute("number");
        i++;
        out.write(remoteAddr+"访问次数是："+i);
        servletContext.setAttribute("number",i);
    }
}
