<%--
  Created by IntelliJ IDEA.
  User: longz
  Date: 17-6-27
  Time: 上午8:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="Robots" content="index,follow"/>
    <meta name="author" content="walter,longzhaoz@qq.com"/>
    <title>
        笔记回收
    </title>
    <link rel="stylesheet" type="text/css" href=
            "../../static/css/style.css"/>
    <script language="javascript" type="text/javascript">
        function drop(id) {
            if (confirm("确定彻底删除当前笔记？")) {
                window.location.href = "/note/del.jsp?note.id=" + id;
            }
        }
        function view(id) {
            window.location.href = "/note/view.jsp?note.id=" + id;
        }
        function rollback(id) {
            window.location.href = "/note/recovery.jsp?note.id=" + id;
        }
    </script>
</head>
<body>
<jsp:include page="h-menu.html"/>

<div id="body_wrapper">
    <div id="body">
        <div id="left">
            <div class="top"></div>
            <div class="content">
                <table>
                    <thead>
                    <tr>
                        <td>序号</td>
                        <td>笔记题目</td>
                        <td>操作</td>
                        <td>笔记时间</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${notes}" var="note" varStatus="i">
                        <tr>
                            <td>${i.index+1}</td>
                            <td>${note.title}</td>
                            <td>
                                <input type="button" value="查看" onclick="view(${note.id})" class="view"/>
                                <input type="button" value="删除" onclick="drop(${note.id})" class="drop"/>
                                <input type="button" value="恢复" onclick="rollback(${note.id})" class="rollback"/>
                            </td>
                            <td><fmt:formatDate value="${note.time}" pattern="yyyy年MM月dd日 HH时mm分ss秒"/></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
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
