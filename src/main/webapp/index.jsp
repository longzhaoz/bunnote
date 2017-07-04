<%--
  Created by IntelliJ IDEA.
  User: longz
  Date: 17-6-22
  Time: 上午9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="Robots" content="index,follow" />
    <meta name="author" content="walter,longzhaoz@qq.com" />
    <title>
        用户操作
    </title>
    <link rel="stylesheet" type="text/css" href=
            "static/css/style.css" />
</head>
<body>
<div id="head">
    <div id="title">
        包子笔记
    </div>
    <div id="menu">
        <ul>
            <li class="active">
                <a href="index.jsp" title="欢迎页面">主页</a>
            </li>
            <li>
                <a href="/note/index.jsp" title="赏阅笔记">笔记</a>
            </li>
            <li>
                <a href="/blog/index.jsp" title="浏览博客">博客</a>
            </li>
            <li>
                <a href="/user/index.jsp" title="用户相关">账号</a>
            </li>
        </ul>
    </div>
</div>

<div id="body_wrapper">
    <div id="body">
        <div id="all">
            <img src="static/images/bun.jpg" style="padding-left: 300px">
        </div>
        <div class="clearer"></div>
    </div>
    <div class="clearer"></div>
</div>
<div id="end_body"></div>
<div id="footer">
    &copy; Copyright <a href="mailto:longzhaoz@qq.com">Walter</a> 2017
</div>
</body>
</html>
