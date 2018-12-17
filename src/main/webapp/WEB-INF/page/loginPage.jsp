<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2018/10/30
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="<%=basePath%>assets/css/amazeui.css" />
    <link rel="stylesheet" href="<%=basePath%>assets/css/other.min.css" />

    <!-- Sweet Alert -->
    <link href="${baseUrl}admin/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">

    <!-- Sweet alert -->
    <script src="${baseUrl}admin/js/plugins/sweetalert/sweetalert.min.js"></script>
    <script src="<%=basePath%>assets/js/jquery.min.js"></script>
    <script>
        window.onload = function () {
            if (window.parent.window != window) {
                window.top.location = "/toLogin";
            }
        }

        //json两种形式
        //当是对象的时候最外层是{}
        //当是数组集合的时候最外层是[]
        function login() {


            var username=$("#username").val();
            if (username==""){
                swal("错误！", "用户名不能为空！", "error");
                return false;//因为这是submit表单提交 返回false 不进行请求
            };

            var password=$("#password").val();
            if (password==""){
                swal("错误！", "密码不能为空！", "error");
                return false;
            }
            var rememberMe=$("#rememberMe").val();

            $.ajax({
                type: 'post',
                url: "toLogin",
                data: {username:username,password:password,rememberMe:rememberMe},
                dataType: "text",
                success: function (data) {
                    var mydata =data;
                    console.log(mydata)
                    if (mydata == "1") {

                        window.location.href="toIndex";
                    }else if(mydata == "3"){

                        window.location.href="toAdminIndex";
                    }
                    else {
                        swal("错误！", "用户名或密码不正确！", "error");
                        return false;
                    }
                }
            });

        }
    </script>
</head>
<body class="login-container">
<div class="login-box">
    <div class="logo-img">
        <img src="<%=basePath%>images/logo2_03.png" alt="" />
    </div>
    <form action="" class="am-form" data-am-validator>
        <div class="am-form-group">
            <label for="username"><i class="am-icon-user"></i></label>
            <input type="text" id="username" minlength="3" placeholder="输入用户名（至少 3 个字符）" required/>
        </div>

        <div class="am-form-group">
            <label for="password"><i class="am-icon-key"></i></label>
            <input type="password" id="password" placeholder="输入密码" required/>
        </div>

            <input type="checkbox" id="rememberMe"/>自动登录 <a style="margin-left: 200px;" href="toRegister">注册</a>

        <button class="am-btn am-btn-secondary"  onclick="login()" type="button">登录</button>

    </form>
</div>

</body>
</html>
