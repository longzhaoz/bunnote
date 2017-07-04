<%--
  Created by IntelliJ IDEA.
  User: longz
  Date: 17-6-26
  Time: 下午5:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>${title}</title>
    <link rel="stylesheet" type="text/css" href="../../static/css/style.css" />
    <script>
        function  redirect() {
            window.location.href="${url}";
        }
        window.onload = function () {
            var i=3;
            var span = document.getElementById("sec");
            setInterval(function () {
                i--;
                if(i==0){
                    redirect();
                }
                span.innerHTML= i;
            },1000);
        }
    </script>
</head>
<body>

<jsp:include page="h-menu.html"/>

<div id="body_wrapper">
    <div id="body">
        <div id="left_blank">
            <h2>${message}</h2>
            <p><span id="sec">3</span>秒后跳转...<input type="button" value="跳转" onclick="redirect();"/></p>
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
