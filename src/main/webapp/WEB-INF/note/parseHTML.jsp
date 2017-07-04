<%--
  Created by IntelliJ IDEA.
  User: longz
  Date: 17-7-2
  Time: 上午11:39
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
        转换工具
    </title>
    <link rel="stylesheet" type="text/css" href=
            "../../static/css/style.css"/>
    <script src="../../static/js/jquery-3.2.1.min.js"></script>
    <script src="../../static/js/to-markdown.js"></script>
    <script language="javascript" type="text/javascript">
        function view() {
            var view = $("#viewa").val();
            view = toMarkdown(view);
            $("#viewb").val(view);
        }
    </script>
</head>
<body>
<jsp:include page="h-menu.html"/>

<div id="body_wrapper">
    <div id="body">
        <div id="all">
            <div class="top"></div>
            <div class="content">
                <div><textarea  id="viewa" style="width:1359px;height:375px;"></textarea></div>
                <input type="button" onclick="view()" value="转换为Markdown">
                <div><textarea  id="viewb" style="width:1359px;height:375px;" readonly="readonly"></textarea></div>
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
