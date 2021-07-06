package cn.bjpowernode.servlet.day04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String un="";
        String pw="";
        //设置字符编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //先拼接一个登录页面
        PrintWriter out = response.getWriter();
        Cookie[] cookies = request.getCookies();
        if(cookies!=null) {
            for (int i = 0; i < cookies.length; i++) {
                if ("username".equals(cookies[i].getName()))
                    un = cookies[i].getValue();
                if ("password".equals(cookies[i].getName()))
                    pw = cookies[i].getValue();
            }
        }
        out.print("<html> <head> <meta charset='UTF-8'><title>用户登录页面</title> </head>");
        out.print("<body><form action='saveCookieServlet' method='get'>");
        out.print("<label>账号</label><input type=\"text\" value='"+un+"'  name=\"username\" /><br />");
        out.print("<label>密码</label><input type=\"password\" value='"+pw+"'name=\"password\"  /><br />");
        out.print("<input type=\"checkbox\" name=\"check\" value='yes' checked><label>十天免登录</label><br>");
        out.print("<input type=\"submit\" value=\"登录\" /><br /></form></body></html>");
    }
}
