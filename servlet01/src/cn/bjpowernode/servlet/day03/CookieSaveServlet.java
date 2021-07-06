package cn.bjpowernode.servlet.day03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/cookieSaveServlet")
public class CookieSaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求字符编码
        request.setCharacterEncoding("utf-8");
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("用户名："+username+"密码："+password);
        //获取cookie对象，将需要储存的数据传入
        Cookie cookie = new Cookie(username,password);
        //设置能保存的时间
        cookie.setMaxAge(60);
        //将cookie对象绑定到响应对象中，这样浏览器在响应时，
        // 就能获取到这个cookie对象，就能获取到保存的数据
        response.addCookie(cookie);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //返回的时cookie对象,通过遍历获取cookie对象，再取到里面的数据
        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            out.print(cookies[i]+"<br>");
            out.print(cookies[i].getName()+"<br>");
            out.print(cookies[i].getValue()+"<br>");
        }
    }
}
