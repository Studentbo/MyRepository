package cn.bjpowernode.servlet.day03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/httpServletRequest")
public class HttpServletRequest extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置好编码
        request.setCharacterEncoding("utf-8");
        //获取输出流
        String username = request.getParameter("username");
        System.out.println("用户名："+username+"<br>");
        String password = request.getParameter("password");
        System.out.println("密码："+password+"<br>");
        String sex = request.getParameter("sex");
        System.out.println("性别："+sex+"<br>");
        String dept = request.getParameter("dept");
        System.out.println("部门："+dept+"<br>");
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println("爱好是：");
        System.out.println(Arrays.toString(hobbies));
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");//设置响应编码
        PrintWriter out = response.getWriter();//获取流
        //返回请求的URI（相对路径，工程路径后面的）
        StringBuffer requestURL = request.getRequestURL();
        out.write(requestURL+"<br>");
        //返回访问电脑的IP地址，知道是谁访问了这个网站
        String remoteAddr = request.getRemoteAddr();
        out.write(remoteAddr+"<br>");
        //返回协议的名称：http，https，ftp等
        String scheme = request.getScheme();
        out.write(scheme+"<br>");
        //获取服务器端名称
        String serverName = request.getServerName();
        out.write(serverName+"<br>");
        //获取服务器端口号
        int serverPort = request.getServerPort();
        out.print(serverPort+"<br>");
        //返回获取的方式get或post
        String method = request.getMethod();
        out.write(method+"<br>");
        //浏览器的端口号
        int remotePort = request.getRemotePort();
        out.print(remotePort);
        this.doPost(request,response);
    }
}
