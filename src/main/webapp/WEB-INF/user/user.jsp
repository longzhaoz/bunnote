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
    <link rel="stylesheet" type="text/css" href="../../static/css/style.css" />

</head>
<body>
<jsp:include page="h-menu.html"/>

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
                <jsp:include page="r-menu.html"/>
            </div>
            <div class="bottom"></div>
        </div>
        <div class="clearer"></div>
    </div>
    <div class="clearer"></div>
</div>
<div id="end_body"></div>
<%@include file="../footer.jsp" %>
</body>
</html>
