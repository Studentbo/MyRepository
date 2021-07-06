package cn.bjpowernode.servlet.day02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/aaa")
public class Servlet03 extends HttpServlet {
    public Servlet03() {
        System.out.println("胡汉三来来来。。。。");
    }

    @Override
    public void destroy() {
        System.out.println("胡汉三要走了，不要想我哦");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("哈哈哈，你们干不掉我的！！");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("我胡汉三就在这儿呢，来干我呀！！");
        super.service(req,resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("胡汉三的doPost方法。。。。。");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("胡汉三的doGet方法。。。。。");
    }
}
