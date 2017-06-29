<%--
  Created by IntelliJ IDEA.
  User: longz
  Date: 17-6-28
  Time: 下午5:00
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
        读取备份
    </title>
    <link rel="stylesheet" type="text/css" href=
            "../../static/css/style.css"/>
    <script src="../../static/js/jquery-3.2.1.min.js"></script>
    <script language="javascript" type="text/javascript">
        function view(i) {
            var view = $("#viewb");
            console.log(i);
            switch (i) {
                case 1:
                    view.val($("#view1").val());
                    console.log(2);
                    break;
                case 2:
                    view.val($("#view2").val());
                    break;
                case 3:
                    view.val($("#view3").val());
                    break;
                case 4:
                    view.val($("#view4").val());
                    break;
                case 5:
                    view.val($("#view5").val());
                    break;
            }

        }
        function rollback(id, type) {
            if (confirm("确定回滚？回滚将损失最后一次编辑内容")) {
                window.location.href = "/note/rollback.jsp?note.id=" + id + "&type=" + type;
            }
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
                <table>
                    <thead>
                    <tr>
                        <td>序号</td>
                        <td>操作</td>
                        <td>笔记时间</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${notes}" var="note" varStatus="i">
                        <tr>
                            <td>${i.index+1}</td>
                            <td>
                                <input type="button" value="查看" onclick="view(${i.index+1})" class="view"/>
                                <textarea hidden id="view${i.index+1}">${note.note}</textarea>
                                <input type="button" value="恢复" onclick="rollback(${note.id},${i.index+1})"
                                       class="rollback"/>
                            </td>
                            <td><fmt:formatDate value="${note.time}" pattern="yyyy年MM月dd日 HH时mm分ss秒"/></td>
                        </tr>
                    </c:forEach>
                    </tbody>

                </table>
            </div>
            <div class="bottom"></div>
            <div><textarea  id="viewb" style="width:1359px;height:375px;resize:none;" readonly="readonly"></textarea></div>
        </div>
        <div class="clearer"></div>
    </div>
    <div class="clearer"></div>
</div>
<div id="end_body"></div>
<%@include file="../footer.jsp" %>
</body>
</html>