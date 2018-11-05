<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2018/11/1
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="baseUrl" value="${pageContext.request.contextPath}/"></c:set>
<html>
<head>
    <title>Title</title>
</head>
<body>

<shiro:notAuthenticated>
    <div class="am-topbar-right" style="margin-top: 9px">
        <a href="${baseUrl}toRegister"><button class="am-btn am-btn-default am-topbar-btn am-btn-sm"><span class="am-icon-pencil"></span>注册</button></a>
    </div>

    <div class="am-topbar-right" style="margin-top: 9px">
        <a href="${baseUrl}toLogin"><button class="am-btn am-btn-danger am-topbar-btn am-btn-sm"><span class="am-icon-user"></span>登录</button></a>
    </div>
</shiro:notAuthenticated>
<shiro:authenticated>
    <div class="am-topbar-right" style="margin-top: 9px">
        <a href="${baseUrl}logout"><button class="am-btn am-btn-danger am-topbar-btn am-btn-sm"><span class="am-icon-share"></span>退出</button></a>
    </div>

    <div class="am-topbar-right" style="margin-top: 9px">
        <a href="${baseUrl}userCenter"><button class="am-btn am-btn-danger am-topbar-btn am-btn-sm"><span class="am-icon-user"></span>个人中心</button></a>
    </div>
</shiro:authenticated>
</body>
</html>
