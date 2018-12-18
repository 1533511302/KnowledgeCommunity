<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2018/11/2
  Time: 9:34
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
<c:if test="${user.role=='2'}">
    <ul class="am-avg-sm-4 am-avg-md-4 am-avg-lg-4" style="width: 700px;margin-left: -250px">
        <li class="active-none"><h3><a href="${baseUrl}vUsersCategory/${user.id}">我的图文</a></h3></li>
        <li  class="active-none" ><h3><a href="${baseUrl}vUsersAudio/${user.id}">我的音频</a></h3></li>
        <li  class="active-none"><h3><a href="${baseUrl}vUsersQuestion/${user.id}">我的问题</a></h3></li>
        <li  class="active-none"><h3><a href="${baseUrl}vUsersAnswer/${user.id}">我的回答</a></h3></li>
    </ul>
</c:if>
<c:if test="${user.role=='1'}">
    <ul class="am-avg-sm-1 am-avg-md-1 am-avg-lg-1" style="width: 700px;margin-left: -250px">
        <li class="active-none"><h3><a href="${baseUrl}vUsersQuestion/${user.id}">我的问题</a></h3></li>
    </ul>
</c:if>
</body>
</html>
