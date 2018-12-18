<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2018/10/30
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="baseUrl" value="${pageContext.request.contextPath}/"></c:set>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>注册</title>
    <link rel="stylesheet" href="${baseUrl}assets/css/amazeui.css" />
    <link rel="stylesheet" href="${baseUrl}assets/css/other.min.css" />

    <!-- Sweet Alert -->
    <link href="${baseUrl}admin/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">


    <script src="${baseUrl}assets/js/jquery.min.js"></script>
    <script type="text/javascript">


        //json两种形式
        //当是对象的时候最外层是{}
        //当是数组集合的时候最外层是[]
        function register() {
            var username=$("#username").val();
            $.post("isUsername",{username:username},function (data) {
                if (data) {

                    swal("错误！", "用户名已存在！", "error");
                    return false;
                }
            });


            if (username==""){

                swal("错误！", "用户名不能为空！", "error");
                return false;//因为这是submit表单提交 返回false 不进行请求
            }else {
                var password=$("#password").val();
                if (password==""){

                    swal("错误！", "旧密码不能为空！", "error");
                    return false;
                }

                var confirm=$("#confirm").val();
                if(confirm == password){
                    $.ajax({
                        type: 'post',
                        url: "${baseUrl}users",
                        data: {username:username,password:password},
                        success: function (data) {
                                swal({
                                    title: "成功",
                                    text: "注册成功！",
                                    type: "success",
                                    confirmButtonColor: "#4CAF50",
                                    confirmButtonText: "OK",
                                    closeOnConfirm: false
                                }, function () {
                                    window.location.href="toLogin";
                                });


                        }
                    });

                }else {
                    swal("错误！", "确认密码不相等！", "error");
                    return false;
                }
            }



            // var username=$("#username").val();
            // var password=$("#password").val();
            // if (password==""){
            //     swal("错误！", "密码不能为空！", "error");
            //     return false;
            // }
            // if (username==""){
            //
            //     swal("错误！", "用户名不能为空！", "error");
            //     return false;//因为这是submit表单提交 返回false 不进行请求
            // }else {
            //     $.post("isUsername",{username:username},function (data) {
            //         if (data){
            //             swal("错误！", "用户名已存在！", "error");
            //             return false;
            //         }else {
            //
            //
            //
            //             var password=$("#password").val();
            //             if (password==""){
            //                 swal("错误！", "密码不能为空！", "error");
            //                 return false;
            //             }
            //             var confirm=$("#confirm").val();
            //             if(confirm == password){
            //                 $.ajax({
            //                     type: 'post',
            //                     url: "users",
            //                     data: {username:username,password:password},
            //                     success: function (data) {
            //
            //                         swal({
            //                             title: "成功",
            //                             text: "注册成功！",
            //                             type: "success",
            //                             confirmButtonColor: "#4CAF50",
            //                             confirmButtonText: "OK",
            //                             closeOnConfirm: false
            //                         }, function () {
            //                             window.location.href="toLogin";
            //                         });
            //
            //
            //
            //
            //                     }
            //                 });
            //
            //             }else {
            //                 swal("错误！", "确认密码不相等！", "error");
            //                 return false;
            //             }
            //
            //         }
            //     });
            //
            // }



        }
    </script>
</head>
<body class="login-container">
<div class="login-box">
    <div class="logo-img">
        <img src="${baseUrl}images/logo2_03.png" alt="" />
    </div>
    <form  class="am-form"  onsubmit="return register()">
        <div class="am-form-group">
            <label for="username"><i class="am-icon-user"></i></label>
            <input type="text" id="username"  placeholder="输入用户名（至少 3 个字符）"/>
        </div>

        <div class="am-form-group">
            <label for="password"><i class="am-icon-key"></i></label>
            <input type="password" id="password" placeholder="输入密码" />
        </div>
        <div class="am-form-group">
            <label for="confirm"><i class="am-icon-key"></i></label>
            <input type="password" id="confirm" placeholder="确认密码" />
        </div>
        <button class="am-btn am-btn-secondary"  type="submit">注册</button>
    </form>
</div>
<!-- Sweet alert -->
<script src="${baseUrl}admin/js/plugins/sweetalert/sweetalert.min.js"></script>
</body>
</html>
