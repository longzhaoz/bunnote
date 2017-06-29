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
            "../static/css/style.css" />
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
                <a href="1col.html" title="赏阅笔记">笔记</a>
            </li>
            <li>
                <a href="tags.html" title="浏览博客">博客</a>
            </li>
            <li>
                <a href="../user/index.jsp" title="用户相关">账号</a>
            </li>
        </ul>
    </div>
</div>

<div id="body_wrapper">
    <div id="body">
        <div id="left">
            <div class="top"></div>
            <div class="content">
                <h1>用户信息</h1>
                <h2>欢迎你,${userLogined.alias}</h2>
                <h3>注册时间：<fmt:formatDate value="${userLogined.regTime}" pattern="yyyy年MM月dd日"/></h3>
                <h3>上次登录时间：<fmt:formatDate value="${userLogined.time}" pattern="yyyy年MM月dd日 HH时mm分ss秒"/></h3>
            </div>
            <div class="bottom"></div>
        </div>
        <div id="right">
            <div class="top"></div>
            <div class="content">
                <h4>菜单</h4>
                <ul>
                    <li><a href="../user/loginx.jsp">登录</a></li>
                    <li><a href="../user/regx.jsp">注册</a></li>
                    <li><a href="../user/index.jsp">用户信息</a></li>
                    <li><a href="../user/logout.jsp">注销</a></li>
                </ul>
                <hr />
                <h4>Quote</h4>
                There's no 'I' in team.<br />
                There's no 'U' in team either.<br />
                If I'm not on the team, and you're not on the team: nobody is on the
                team and the team sucks!<br />
                <hr />
                <h4>Links</h4>
                <ul>
                    <li><a href="http://aaron.ganschow.us/" target="_blank">Aaron Ganschow</a></li>
                    <li><a href="http://www.wildleaf.net/" target="_blank">Wildleaf</a></li>
                    <li><a href="http://www.mozilla.org/" target="_blank">Mozilla</a></li>
                    <li><a href="http://www.csszengarden.com/" target="_blank">CSS Zen Garden</a></li>
                </ul>
            </div>
            <div class="bottom"></div>
        </div>
        <div class="clearer"></div>
    </div>
    <div class="clearer"></div>
</div>
<div id="end_body"></div>
<%@include file="footer.jsp" %>
</body>
</html>
