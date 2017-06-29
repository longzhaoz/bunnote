<%--
  Created by IntelliJ IDEA.
  User: longz
  Date: 17-6-28
  Time: 下午2:48
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
        ${note.title}
    </title>
    <link rel="stylesheet" type="text/css" href=
            "../../static/css/style.css" />
    <link rel="stylesheet" type="text/css" href="../../static/css/mark.css">
    <script src="../../static/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
//            获取目录
            $("h1,h2,h3,h4,h5,h6").each(function(i,item){
                var tag = $(item).get(0).localName;
                $(item).attr("id","wow"+i);
                $("#category").append('<a class="new'+tag+'" href="#wow'+i+'">'+$(this).text()+'</a></br>');
                $(".newh1").css("margin-left",0);
                $(".newh2").css("margin-left",20);
                $(".newh3").css("margin-left",40);
                $(".newh4").css("margin-left",60);
                $(".newh5").css("margin-left",80);
                $(".newh6").css("margin-left",100);
            });
        });
    </script>
</head>
<body>
<jsp:include page="h-menu.html"/>

<div id="body_wrapper">
    <div id="body">
        <div id="left">
            <div class="top"></div>
            <div class="content">
               ${note.note}
                <p>最后修改时间<fmt:formatDate value="${note.time}" pattern="yyyy年MM月dd日"/></p>
            </div>
            <div class="bottom"></div>
        </div>
        <div id="noth" style="width: 300px;float: right;border: 2px dashed cornsilk">
                <p style="font-size: 20px">菜单</p>
                <ul>
                    <li><a href="../note/index.jsp">笔记本</a></li>
                    <li><a href="../note/trash.jsp">回收站</a></li>
                    <li><a href="../note/draftview.jsp">草稿箱</a></li>
                    <li><a href="../note/edit.jsp">新笔记</a></li>
                </ul>
                <hr />
                <p style="font-size: 20px">目录</p>
                <div id="category"></div>
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
