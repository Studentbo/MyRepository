<%--
  Created by IntelliJ IDEA.
  User: 波波同学
  Date: 2021/5/18
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>用户登录</title>
</head>
<body>

${cookie.password.value}
<form action="saveCookieServlet" method="get">
    <label>账号</label>
    <input type="text" placeholder="请设置用户名" name="username" value="${cookie.username.value}"/><br/>

    <label>密码</label>
    <input type="password" placeholder="请输入密码" name="password" value="${cookie.password.value}"/><br/>

    <label>十天免登录</label>
    <input type="checkbox" name="check" value="yes" checked><br>

    <input type="submit" value="登录"/><br/>
</form>
</body>
</html>
