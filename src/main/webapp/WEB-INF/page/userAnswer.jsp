<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2018/10/20
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="baseurl" value="${pageContext.request.contextPath}/"></c:set>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>

    <!--360 browser -->
    <meta name="renderer" content="webkit">
    <meta name="author" content="wos">
    <!-- Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="${baseurl}images/i/app.png">
    <!--Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="apple-touch-icon-precomposed" href="${baseurl}images/i/app.png">
    <!--Win8 or 10 -->
    <meta name="msapplication-TileImage" content="${baseurl}images/i/app.png">
    <meta name="msapplication-TileColor" content="#e1652f">

    <link rel="icon" type="image/png" href="${baseurl}images/i/favicon.png">
    <link rel="stylesheet" href="${baseurl}assets/css/amazeui.min.css">
    <link rel="stylesheet" href="${baseurl}css/public.css">

    <!--[if (gte IE 9)|!(IE)]><!-->
    <script src="${baseurl}assets/js/jquery.min.js"></script>
    <!--<![endif]-->
    <!--[if lte IE 8 ]>
    <script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
    <script src="${baseurl}assets/js/amazeui.ie8polyfill.min.js"></script>
    <![endif]-->
    <script src="${baseurl}assets/js/amazeui.min.js"></script>
    <script src="${baseurl}js/public.js"></script>

</head>
<body>

<header class="am-topbar am-topbar-fixed-top wos-header">
    <div class="am-container">
        <h1 class="am-topbar-brand">
            <a href="#"><img src="${baseurl}images/logo.png" alt=""></a>
        </h1>

        <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-warning am-show-sm-only"
                data-am-collapse="{target: '#collapse-head'}">
            <span class="am-sr-only">导航切换</span>
            <span class="am-icon-bars"></span>
        </button>

        <div class="am-collapse am-topbar-collapse" id="collapse-head">
            <ul class="am-nav am-nav-pills am-topbar-nav">
                <li><a href="${baseurl}toIndex">首页</a></li>
                <li><a href="${baseurl}massagePage">图文</a></li>
                <li><a href="${baseurl}audioPage">音频</a></li>
                <li><a href="${baseurl}topics/1">问答</a></li>
                <li  class="am-active"><a href="${baseurl}vUsers/1">大咖秀</a></li>

            </ul>

            <form action="${baseurl}vUsersCategory/${user.id}/likeTitle" class="am-topbar-form am-topbar-left am-form-inline" role="search">
                <div class="am-form-group" style="margin-top: 12px;margin-left: 10px">
                    <input name="title" type="text" class="am-form-field am-input-sm" placeholder="搜索内容" value="${title}">
                </div>
                <div class="am-topbar-right">
                    <button type="submit" class="am-btn am-btn-primary am-topbar-btn am-btn-sm">搜索</button>
                </div>
            </form>

            <c:import url="userPlugin.jsp"></c:import>
        </div>
    </div>
</header>

<div class="category2top">
    <div class="am-g am-container userinfo">
        <div class="am-u-sm-12 am-u-md-12 am-u-lg-5 userinfo_left">
            <div class="am-g">
                <div class="am-u-md-12 am-u-lg-6 userface">
                    <img src="/img/${user.photo}">
                </div>
                <div class="am-u-md-9 am-u-lg-6 userin">
                    <h3>姓名：${user.realname}</h3>
                    <h4>性别：${user.gender==1?'男':'女'}</h4>
                    <h4>${user.autograph}</h4>
                    <p>图文：${user.massagenumb} &nbsp; 音频：${user.audionumb}</p>
                    <p>问题：${user.questionnumb} &nbsp; 回答：${user.answernumb}</p>
                </div>
            </div>

        </div>
        <div class="am-u-sm-0 am-u-md-12 am-u-lg-4 am-show-lg-only userinfo_center">
            ${user.introduce}
        </div>
        <c:if test="${user.username==username}">
            <div class="am-u-sm-12 am-u-md-12 am-u-lg-2 am-show-lg-only userinfo_right">
                <a href="${baseurl}userInfo/${user.id}"><button type="button" class="am-btn am-btn-warning">
                    <i class="am-icon-pencil-square-o"></i>
                    个人信息
                </button></a>
                <a href="${baseurl}collectionMassage"><button type="button" class="am-btn am-btn-warning">
                    <i class="am-icon-shopping-bag"></i>
                    我的收藏
                </button></a>
                <a href="${baseurl}collectionVUser"><button type="button" class="am-btn am-btn-warning">
                    <i class="am-icon-heart"></i>
                    我的关注
                </button></a>
                <c:if test="${user.role=='1'}">
                    <button  type="button" class="am-btn am-btn-warning" onclick="onClickToVUser()">
                        <i class="am-icon-heart"></i>
                        申请认证
                    </button>
                </c:if>
            </div>
        </c:if>

    </div>
</div>
<div id="cattit">
    <c:if test="${user.role=='2'}">
        <ul class="am-avg-sm-4 am-avg-md-4 am-avg-lg-4" style="width: 700px;margin-left: -250px">
            <li class="active-none"><h3><a href="${baseUrl}vUsersCategory/${user.id}">我的图文</a></h3></li>
            <li  class="active-none" ><h3><a href="${baseUrl}vUsersAudio/${user.id}">我的音频</a></h3></li>
            <li  class="active-none"><h3><a href="${baseUrl}vUsersQuestion/${user.id}">我的问题</a></h3></li>
            <li  class="active"><h3><a href="${baseUrl}vUsersAnswer/${user.id}">我的回答</a></h3></li>
        </ul>
    </c:if>
    <c:if test="${user.role=='1'}">
        <ul class="am-avg-sm-1 am-avg-md-1 am-avg-lg-1" style="width: 700px;margin-left: -250px">
            <li class="active-none"><h3><a href="${baseUrl}vUsersQuestion/${user.id}">我的问题</a></h3></li>
        </ul>
    </c:if>
</div>
<hr data-am-widget="divider" style="" class="am-divider am-divider-default" />
<div class="am-g">
    <div class="am-u-sm-0 am-u-md-2 am-u-lg-3">&nbsp;</div>
    <div class="am-u-sm-12 am-u-md-8 am-u-lg-6">
        <div data-am-widget="list_news" class="am-list-news am-list-news-default ">
            <div class="am-list-news-bd">
                <ul class="am-list">
                    <c:forEach var="answer" items="${pageInfo.list}" varStatus="index">
                        <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left" style="border-top: 0px">
                            <div class="am-u-sm-5 am-list-thumb">
                                <a href="#">
                                    <img src="/img/${answer.photo}" alt="配图" />
                                </a>
                            </div>

                            <div class=" am-u-sm-7 am-list-main">
                                <h2 class="am-list-item-hd"><a href="${baseurl}question/${answer.quesId}">${answer.quesTitle}</a></h2>

                                <div class="am-list-item-text">${answer.answerContent}</div>

                            </div>
                            <c:if test="${user.username==username}">
                                <div align="right" style="width:840px;height:50px;margin-top: 120px;">
                                    <div class="am-btn-group">


                                        <button class="am-btn am-btn-danger  am-radius" style="width: 100px" onclick="clickDeleteBtn(${answer.id})">
                                            <i class="am-icon-eraser"></i>
                                            删除
                                        </button>

                                        <a href="${baseurl}toUpdateAnswer?answerId=${answer.id}">
                                            <button class="am-btn am-btn-warning am-radius" style="width: 100px">
                                                <i class="am-icon-pencil"></i>
                                                修改
                                            </button>
                                        </a>
                                    </div>

                                </div>
                            </c:if>
                        </li>
                        <div class="newsico am-fr">
                            <i class="am-icon-clock-o">${answer.createTime}</i>

                        </div>
                    </c:forEach>




                </ul>
                <ul data-am-widget="pagination" class="am-pagination am-pagination-default" style="text-align: center">

                    <li class="am-pagination-first ">
                        <a href="<c:url value="/vUsersAnswer/${user.id}?page=1"/>">首页</a>
                    </li>

                    <li class="am-pagination-prev ">
                        <a href="<c:url value="/vUsersAnswer/${user.id}?page=${pageInfo.pageNum-1>1?pageInfo.pageNum-1:1}"/>">&laquo;</a>
                    </li>
                    <c:set var="start" value="${pageInfo.pageNum-5<=0?1:pageInfo.pageNum-5}"/>
                    <c:set var="end" value="${start+9<pageInfo.pages?start+9:pageInfo.pages}"/>
                    <c:forEach begin="${start}" end="${end}" varStatus="loop">
                        <c:set var="active" value="${loop.index==pageInfo.pageNum?'am-active':''}"/>


                        <li class="${active}">
                            <a href="<c:url value="/vUsersAnswer/${user.id}?page=${loop.index}"/>">${loop.index}</a>
                        </li>
                    </c:forEach>


                    <li class="am-pagination-next ">
                        <a href="<c:url value="/vUsersAnswer/${user.id}?page=${pageInfo.pageNum+1<pageInfo.pages?pageInfo.pageNum+1:pageInfo.pages}"/>">&raquo;</a>
                    </li>

                    <li class="am-pagination-last ">
                        <a href="<c:url value="/vUsersAnswer/${user.id}?page=${pageInfo.pages}"/>">尾页</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="am-u-sm-0 am-u-md-2 am-u-lg-3">&nbsp;</div>
</div>



<div data-am-widget="gotop" class="am-gotop am-gotop-fixed" >
    <a href="#top" title="回到顶部">
        <span class="am-gotop-title">回到顶部</span>
        <i class="am-gotop-icon am-icon-chevron-up"></i>
    </a>
</div>

<footer>
    <div class="content">
        <ul class="am-avg-sm-5 am-avg-md-5 am-avg-lg-5 am-thumbnails">
            <li><a href="#">联系我们</a></li>
            <li><a href="#">加入我们</a></li>
            <li><a href="#">合作伙伴</a></li>
            <li><a href="#">广告及服务</a></li>
            <li><a href="#">友情链接</a></li>
        </ul>
        <div class="btnlogo"><img src="${baseurl}images/btnlogo.png"/></div>
        <p>Amaze UI出品<br>© 2016 AllMobilize, Inc. Licensed under MIT license. Developed with WebStorm.</p>
        <div class="w2div">
            <ul data-am-widget="gallery" class="am-gallery am-avg-sm-2
  am-avg-md-2 am-avg-lg-2 am-gallery-overlay" data-am-gallery="{ pureview: true }" >
                <li class="w2">
                    <div class="am-gallery-item">
                        <a href="${baseurl}Temp-images/dd.jpg">
                            <img src="${baseurl}Temp-images/dd.jpg" />
                            <h3 class="am-gallery-title">订阅号：Amaze UI</h3>
                        </a>
                    </div>
                </li>
                <li   class="w2">
                    <div class="am-gallery-item">
                        <a href="${baseurl}Temp-images/dd.jpg">
                            <img src="${baseurl}Temp-images/dd.jpg"/>
                            <h3 class="am-gallery-title">服务号：Amaze UI</h3>
                        </a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</footer>
<script>
    function clickDeleteBtn(answerId) {
        $.post("${baseurl}deleteAnswer",{answerId:answerId},function (data) {
            if(data){
            alert("删除成功！");
            }
        });

    }
</script>
</body>
</html>