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
<div id="head">
    <div id="title">
        包子笔记
    </div>
    <div id="menu">
        <ul>
            <li>
                <a href="../index.jsp" title="欢迎页面">主页</a>
            </li>
            <li>
                <a href="/note/index.jsp" title="赏阅笔记">笔记</a>
            </li>
            <li>
                <a href="tags.html" title="浏览博客">博客</a>
            </li>
            <li class="active">
                <a href="/user/index.jsp" title="用户相关">账号</a>
            </li>
        </ul>
    </div>
</div>

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
                <h4>菜单</h4>
                <ul>
                    <li><a href="../user/loginx.jsp">登录</a></li>
                    <li><a href="../user/regx.jsp">注册</a></li>
                    <li><a href="../user/index.jsp">用户信息</a></li>
                    <li><a href="../user/logout.jsp">注销</a></li>
                </ul>
                <hr/>
                <h4>Quote</h4>
                There's no 'I' in team.<br/>
                There's no 'U' in team either.<br/>
                If I'm not on the team, and you're not on the team: nobody is on the
                team and the team sucks!<br/>
                <hr/>
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
<%@include file="../footer.jsp" %>
</body>
</html>
