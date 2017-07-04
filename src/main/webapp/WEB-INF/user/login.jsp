<%--
  Created by IntelliJ IDEA.
  User: longz
  Date: 17-6-22
  Time: 上午9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="Robots" content="index,follow"/>
    <meta name="author" content="walter,longzhaoz@qq.com"/>
    <title>
        用户操作
    </title>
    <link rel="stylesheet" type="text/css" href=
            "${pageContext.request.contextPath}/static/css/style.css"/>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.min.js"></script>
    <script>
        function checkname() {
            var check = /^[a-zA-Z][a-zA-Z0-9_]{5,10}$/;
            var name = $("#name").val();
            var url = "/user/check.jsp";
            if (check.test(name)) {

                $.ajax({
                        type: "post",
                        url: url,
                        data: {"user.name": name},
                        dataType: "json",
                        success: function (data, textStatus, jqXHR) {
                            console.log(data.flag);
                            if (true == data.flag) {
                                $("#rename").text("√");
                            } else {
                                $("#rename").text(data.msg);
                            }
                        },
                        error: function (XMLHttpRequest, textStatus, errorThrown) {
                            $("#rename").text("X");
                        }
                    }
                );
            } else {
                $("#rename").text("X");
            }
        }
    </script>
</head>
<body>
<jsp:include page="h-menu.html"/>

<div id="body_wrapper">
    <div id="body">
        <div id="left_blank">
            <div id="login">
                <form action="../user/login.jsp" method="post">
                    <h1>用户登录</h1>
                    <fieldset>

                        <legend>登录</legend>
                        <table>
                            <tr>
                                <td>用户名</td>
                                <td><input type="text" name="user.name" id="name" title="5-10个英文字符和下划线"
                                           onchange="checkname();"></td>
                                <td><span id="rename"></span></td>
                            </tr>
                            <tr>
                                <td>密码</td>
                                <td><input type="password" name="user.password" id="password" title="6-12个英文字母和数字"></td>
                                <td><span id="repassword"></span></td>
                            </tr>
                        </table>
                        <input type="submit" title="点击登录" value="Let's Go！" class="button">
                    </fieldset>
                </form>
            </div>
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
