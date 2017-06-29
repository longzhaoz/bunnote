<%--
  Created by IntelliJ IDEA.
  User: longz
  Date: 17-6-28
  Time: 上午10:16
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
        创建笔记
    </title>
    <link rel="stylesheet" type="text/css" href=
            "../../static/css/style.css" />
    <script src="../../static/js/jquery-3.2.1.min.js"></script>
    <style type="text/css">
        .notetitle{
            width: 80%;
            padding: 0 auto;
        }
        .text {
            border: 1px solid #ccc;
            height: 600px;
        }
    </style>
    <script type="text/javascript">
        function savenote() {
            var note =$("#note").val();
            var title = $("#notetitle").val();
            var url = "/note/add.jsp";
            console.log(note);
            console.log(title);
            if (title==""||note==""){
                alert("不能为空")
            }else{
                $.ajax({
                    type:"post",
                    url:url,
                    data:{"note.note":note,"note.title":title},
                    dataType:"json",
                    success:function (data) {
                        if (true == data.flag){
                            location.href="/note/index.jsp";
                        } else {
                            alert("存入日记出错！请稍后再试.")
                        }
                    },
                    error:function () {
                        alert("网络异常请检查网络！")
                    }
                });
            }
        }
        function savedraft() {
            var note =$("#note").val();
            var title = $("#notetitle").val();
            var url = "/note/draftsave.jsp";
            console.log(note);
            console.log(title);
            if (title==""||note==""){
                alert("不能为空")
            }else{
                $.ajax({
                    type:"post",
                    url:url,
                    data:{"note.note":note,"note.title":title},
                    dataType:"json",
                    success:function (data) {
                        if (true == data.flag){
                            location.href="/note/index.jsp";
                        } else {
                            alert("存入日记出错！请稍后再试.")
                        }
                    },
                    error:function () {
                        alert("网络异常请检查网络！")
                    }
                });
            }
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
                <div>
                    标题<input id="notetitle" title="标题" class="notetitle"/>
                </div>
                <div style="padding: 5px 0; color: #ccc"></div>
                <div id="div2" class="text">
                    <textarea id="note" title="内容" style="width:98%;height:590px;resize:none;"></textarea>
                </div>

            </div>
            <div class="bottom"></div>
        </div>
        <div id="right">
            <div class="top"></div>
            <div class="content">
                <jsp:include page="r-menu.html"/>
                <hr />
                <h4>功能区</h4>
                <input type="button" value="新增笔记" id="savenote" onclick="savenote();"/>
                <input type="button" value="存入草稿" id="savedraft" onclick="savedraft();"/>
                <input type="button" value="清空笔记" id="clear"/>
                <input type="button" value="跳转末尾" id="turn"/>
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

