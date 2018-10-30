<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2018/10/30
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="baseurl" value="${pageContext.request.contextPath}/"></c:set>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="${baseurl}assets/css/amazeui.css" />
    <link rel="stylesheet" href="${baseurl}assets/css/other.min.css" />
    <script src="${baseurl}assets/js/jquery.min.js"></script>
    <script type="text/javascript">


        //json两种形式
        //当是对象的时候最外层是{}
        //当是数组集合的时候最外层是[]
        function login() {


            var username=$("#username").val();
            if (username==""){

                alert("用户名不能为空！");
                return false;//因为这是submit表单提交 返回false 不进行请求
            }else {
                $.post("isUsername",{username:username},function (data) {
                    if (data){
                        alert("用户名已存在！");
                        return false;
                    }
                });

            }


            var password=$("#password").val();
            if (password==""){
                alert("密码不能为空！");
                return false;
            }
            var confirm=$("#confirm").val();
            if(confirm !=password){
                alert("确认密码不相等！");
            }else {
                $.ajax({
                    type: 'post',
                    url: "users",
                    data: {username:username,password:password},
                    success: function (data) {

                        console.log(data)
                        if (data) {
                            alert("注册成功！")
                            window.location.href="toLogin";
                        }
                        else {
                            console.log("失败");
                        }
                    }
                });
            }
        }
    </script>
</head>
<body class="login-container">
<div class="login-box">
    <div class="logo-img">
        <img src="${baseurl}images/logo2_03.png" alt="" />
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
        <div class="am-form-group">
            <label for="confirm"><i class="am-icon-key"></i></label>
            <input type="password" id="confirm" placeholder="确认密码" required/>
        </div>
        <button class="am-btn am-btn-secondary" onclick="login()" type="submit">注册</button>
    </form>
</div>
</body>
</html>
