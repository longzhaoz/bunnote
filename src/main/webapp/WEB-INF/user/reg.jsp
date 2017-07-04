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
            "../../static/css/style.css"/>
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
                            if (true == data.flag) {
                                $("#rename").text(data.msg);
                            } else {
                                $("#rename").text("√");
                            }
                        },
                        error: function (XMLHttpRequest, textStatus, errorThrown) {
                            XMLHttpRequest.
                            $("#rename").text("X");
                        }
                    }
                );
            } else {
                $("#rename").text("X");
            }
        }
        function checkpw() {
            var check = /^[a-zA-Z0-9_]{6,12}$/;
            var password = $("#password").val();
            if (check.test(password)) {
                $("#pw").text("√");
            } else {
                $("#pw").text("X");
            }
        }
        function checkrepw() {
            var password = $("#password").val();
            var repassword = $("#repassword").val();
            if (password == repassword) {
                $("#repw").text("√");
            } else {
                $("#repw").text("X");
            }
        }
    </script>
</head>
<body>
<jsp:include page="h-menu.html"/>
<div id="body_wrapper">
    <div id="body">
        <div id="left_blank">
            <div id="reg">
                <form action="../user/reg.jsp" method="post">
                    <h1>欢迎注册</h1>
                    <fieldset>

                        <legend>注册</legend>
                        <table>
                            <tr>
                                <td>用户名</td>
                                <td><input type="text" name="user.name" id="name" title="5-10个英文字符和下划线"
                                           onchange="checkname()"></td>
                                <td><span id="rename"></span></td>
                            </tr>
                            <tr>
                                <td>密码</td>
                                <td><input type="password" name="user.password" id="password" title="6-12个英文字母和数字"
                                           onchange="checkpw()"></td>
                                <td><span id="pw"></span></td>
                            </tr>
                            <tr>
                                <td>确认密码</td>
                                <td><input type="password" title="重复输入密码" id="repassword" onchange="checkrepw()"></td>
                                <td><span id="repw"></span></td>
                            </tr>
                            <tr>
                                <td>昵称</td>
                                <td><input type="text" name="user.alias" title="昵称可以使用汉字"></td>
                            </tr>
                        </table>
                        <input type="submit" title="点击注册" value="填好了！" class="button">
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
