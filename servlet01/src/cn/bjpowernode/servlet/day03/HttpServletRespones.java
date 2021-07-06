package cn.bjpowernode.servlet.day03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/HttpServletRespones")
public class HttpServletRespones extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //先设置响应字符编码
        response.setContentType("text/html;charset=utf-8");
        //可以选择对应的错误给推送浏览器，还可以附带信息
        // response.sendError(500,"错误啦");
        //先获取一个输出流
        PrintWriter out = response.getWriter();
        //通过这个流可以输出想输出的内容
        out.write("<a href=\'http://www.baidu.com\'>百度一下</a><br>");
        out.write("hello....这是一个响应结果<br>");
    }
}
