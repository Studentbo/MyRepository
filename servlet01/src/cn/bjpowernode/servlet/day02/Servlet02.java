package cn.bjpowernode.servlet.day02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

//这里的name属性就相当于xml中的servlet-name，名称
//由于注解就在这个类当中，所以不需要写类路径
//urlPatterns  这里是一个String类型的数组，内可以放置多个请求
//只有urlPatterns   是必须的，其他都可以使用默认的！
//loadOnStartup   将servlet类的实例化时间设置为服务器启动的时候
//initParams     初始化参数，
@WebServlet(name = "Servlet02",
        urlPatterns = {"/b","/a","/abc"},
        initParams = {@WebInitParam(name="张三",value="儿子"),@WebInitParam(name="李四",value = "孙子")},
        loadOnStartup = 2
        )
public class Servlet02 extends HttpServlet {
    public Servlet02() {
        System.out.println("我胡汉三回来啦！！！");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("胡汉三的doPost方法");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("胡汉三的doGet方法");
        //获取servlet-name或 name的值
        System.out.println(this.getServletName());
        //获取初始化参数的值
        //先获取键的数组
        Enumeration<String> names = this.getInitParameterNames();
        //然后对数组遍历就可以获取每一个键，也就可以拿到每一个值
        //这里的遍历类似之前的迭代器！
        while(names.hasMoreElements()){
            String s = names.nextElement();
            System.out.println(s+","+this.getInitParameter(s));
        }
    }
}
