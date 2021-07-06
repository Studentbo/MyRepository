package cn.bjpowernode.servlet.day04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/saveCookieServlet")
public class SaveCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String check = request.getParameter("check");
        //如果用户选择了十天免登录，这个时候就需要配自动填充用户名或密码
        if("yes".equals(check)){
            //将用户信息保存到cookie中
            Cookie username1 = new Cookie("username", username);
            Cookie username2 = new Cookie("password", password);
            response.addCookie(username1);
            response.addCookie(username2);
            out.write("用户数据保存成功！！！<br>");
            //跳回到登录界面
            out.write("<a href='login.jsp'>查看数据保存情况");
        }
    }
}
