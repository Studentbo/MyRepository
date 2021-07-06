package cn.bjpowernode.servlet.day04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/httpSessionServlet")
public class HttpSessionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取session对象，如果是true，没有session，创建一个，并返回一个session对象
        HttpSession session = request.getSession(true);
        //设置session对象存在的时间
        session.setMaxInactiveInterval(300);

        System.out.println(session);
        //获取session对象的id值，16进制的32位，不重复的
        System.out.println(session.getId());
        //判断session对象是否位新创建的
        System.out.println(session.isNew());
    }
}
