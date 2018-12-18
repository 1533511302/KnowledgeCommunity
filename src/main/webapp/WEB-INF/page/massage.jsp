<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2018/10/20
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="baseUrl" value="${pageContext.request.contextPath}/"></c:set>
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
    <link rel="icon" sizes="192x192" href="${baseUrl}images/i/app.png">
    <!--Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="apple-touch-icon-precomposed" href="${baseUrl}images/i/app.png">
    <!--Win8 or 10 -->
    <meta name="msapplication-TileImage" content="${baseUrl}images/i/app.png">
    <meta name="msapplication-TileColor" content="#e1652f">

    <link rel="icon" type="image/png" href="${baseUrl}images/i/favicon.png">
    <link rel="stylesheet" href="${baseUrl}assets/css/amazeui.min.css">
    <link rel="stylesheet" href="${baseUrl}css/public.css">

    <!--[if (gte IE 9)|!(IE)]><!-->
    <script src="${baseUrl}assets/js/jquery.min.js"></script>
    <!--<![endif]-->
    <!--[if lte IE 8 ]>
    <script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
    <script src="${baseUrl}assets/js/amazeui.ie8polyfill.min.js"></script>
    <![endif]-->
    <script src="${baseUrl}assets/js/amazeui.min.js"></script>
    <script src="${baseUrl}js/public.js"></script>
</head>
<body>

<header class="am-topbar am-topbar-fixed-top wos-header">
    <div class="am-container">
        <h1 class="am-topbar-brand">
            <a href="#"><img src="${baseUrl}images/logo.png" alt=""></a>
        </h1>

        <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-warning am-show-sm-only"
                data-am-collapse="{target: '#collapse-head'}">
            <span class="am-sr-only">导航切换</span>
            <span class="am-icon-bars"></span>
        </button>

        <div class="am-collapse am-topbar-collapse" id="collapse-head">
            <ul class="am-nav am-nav-pills am-topbar-nav">
                <li><a href="${baseUrl}toIndex">首页</a></li>
                <li class="am-active"><a href="${baseUrl}massagePage">图文</a></li>
                <li><a href="${baseUrl}audioPage">音频</a></li>
                <li><a href="${baseUrl}topics/1">问答</a></li>
                <li><a href="${baseUrl}vUsers/1">大咖秀</a></li>

            </ul>

            <form action="${baseUrl}massages/likeName" class="am-topbar-form am-topbar-left am-form-inline" role="search">
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


<div class="am-g am-container">
    <div class="am-u-sm-12 am-u-md-12 am-u-lg-8">
        <div class="newstitles">
            <h2>${massage.title}</h2>
            <img src="${baseUrl}Temp-images/face.jpg" class="face">
            <span>${massage.username}</span>
            时间：${massage.createTime}   阅读：${massage.browseNumb}
        </div>
        <a href="#"><img src="${baseUrl}Temp-images/ad2.png" class="am-img-responsive" width="100%"/></a>

        <div class="contents">
            ${massage.content}
        </div>

        <!--data-ds-short-name="amazeui" 多说的用户名-->
        <div data-am-widget="duoshuo" class="am-duoshuo am-duoshuo-default" data-ds-short-name="amazeui">
            <div class="ds-thread" >
            </div>
        </div>
        <div data-am-widget="list_news" class="am-list-news am-list-news-default ">
            <div class="am-list-news-bd">
                <div data-am-widget="titlebar" class="am-titlebar am-titlebar-default" style="border-bottom: 0px; margin-bottom: -10px">
                    <h2 class="am-titlebar-title ">
                        评论内容
                    </h2>
                    <nav class="am-titlebar-nav">
                        <a href="#more">more &raquo;</a>
                    </nav>
                </div>
                <ul id="answerList" class="am-comments-list am-comments-list-flip">
                    <c:forEach var="comment" items="${commentList}" varStatus="index">
                        <li class="am-comment am-comment-primary">
                            <article class="am-comment">
                                <a href="#link-to-user-home">
                                    <img src="/img/${comment.photo}" alt="" class="am-comment-avatar" width="48" height="48"/>
                                </a>
                                <div class="am-comment-main">
                                    <header class="am-comment-hd">
                                        <!--<h3 class=\"am-comment-title\">评论标题</h3>-->
                                        <div class="am-comment-meta">
                                            <a href="#link-to-user" class="am-comment-author">${comment.username}</a>
                                            评论于 <time datetime="2013-07-27T04:54:29-07:00" title="2013年7月27日 下午7:54 格林尼治标准时间+0800">${comment.createTime}</time>
                                        </div>
                                    </header>

                                    <div class="am-comment-bd">
                                            ${comment.commentContent}

                                    </div>
                                </div>
                            </article>
                        </li>
                    </c:forEach>
                </ul>
            </div>

            <div class="am-container" style="margin-top: 10px">
                <div class="am-panel am-panel-success">
                    <div class="am-panel-hd">评论</div>

                    <fieldset>
                        <div class="am-form-group">
                            <textarea id="massageContent" style="width: 100%;" rows="6" placeholder="评论内容编辑"></textarea>
                        </div>


                    </fieldset>

                </div>
                <div class="star am-container mcenter"><span><button id="save" type="button" class="am-btn am-btn-primary" onclick="clickSubmit(${massage.id})" style="width: 120px">提交</button></span></div>

            </div>
        </div>
    </div>
    <div class="am-u-sm-12 am-u-md-12 am-u-lg-4">
        <div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
            <h2 class="am-titlebar-title ">
                大咖
            </h2>
            <nav class="am-titlebar-nav">
                <a href="${baseUrl}vUsers/1">more &raquo;</a>
            </nav>
        </div>
        <div data-am-widget="list_news" class="am-list-news am-list-news-default right-bg" data-am-scrollspy="{animation:'fade'}">
            <ul class="am-list"  >
                <c:forEach var="user" items="${hotUserList}" varStatus="index">
                    <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
                        <div class="am-u-sm-4 am-list-thumb">
                            <a href="vUsersCategory/${user.id}">
                                <img src="/img/${user.photo}" class="face" style="width: 70px;height: 70px;"/>
                            </a>

                            <button class="am-btn am-btn-warning am-round am-btn-xs"  key="1" onclick="clickVUserBtn(${user.id},this)"  style="margin-top: 5px;">
                                关注一下
                            </button>

                        </div>

                        <div class=" am-u-sm-8 am-list-main">
                            <h3 class="am-list-item-hd"><a href="vUsersCategory/${user.id}">${user.realname}</a></h3>

                            <div class="am-list-item-text">${user.autograph}</div>
                        </div>

                    </li>
                    <hr data-am-widget="divider" style="" class="am-divider am-divider-default" />
                </c:forEach>
            </ul>
        </div>

        <div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
            <h2 class="am-titlebar-title ">
                新咖
            </h2>
            <nav class="am-titlebar-nav">
                <a href="${baseUrl}vUsers/1">more &raquo;</a>
            </nav>
        </div>

        <div data-am-widget="list_news" class="am-list-news am-list-news-default right-bg" data-am-scrollspy="{animation:'fade'}">
            <ul class="am-list">
                <c:forEach var="user" items="${newUserList}" varStatus="index">
                    <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
                        <div class="am-u-sm-4 am-list-thumb">
                            <a href="vUsersCategory/${user.id}">
                                <img src="/img/${user.photo}" class="face" style="width: 70px;height: 70px;"/>
                            </a>

                            <button class="am-btn am-btn-warning am-round am-btn-xs"  key="1" onclick="clickVUserBtn(${user.id},this)"  style="margin-top: 5px;">
                                关注一下
                            </button>

                        </div>

                        <div class=" am-u-sm-8 am-list-main">
                            <h3 class="am-list-item-hd"><a href="vUsersCategory/${user.id}">${user.realname}</a></h3>

                            <div class="am-list-item-text">${user.autograph}</div>
                        </div>
                    </li>
                    <hr data-am-widget="divider" style="" class="am-divider am-divider-default" />
                </c:forEach>
            </ul>
        </div>

    </div>
    </div>
</div>
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
        <div class="btnlogo"><img src="${baseUrl}images/btnlogo.png"/></div>
        <p>Amaze UI出品<br>© 2016 AllMobilize, Inc. Licensed under MIT license. Developed with WebStorm.</p>
        <div class="w2div">
            <ul data-am-widget="gallery" class="am-gallery am-avg-sm-2
  am-avg-md-2 am-avg-lg-2 am-gallery-overlay" data-am-gallery="{ pureview: true }" >
                <li class="w2">
                    <div class="am-gallery-item">
                        <a href="${baseUrl}Temp-images/dd.jpg">
                            <img src="${baseUrl}Temp-images/dd.jpg" />
                            <h3 class="am-gallery-title">订阅号：Amaze UI</h3>
                        </a>
                    </div>
                </li>
                <li   class="w2">
                    <div class="am-gallery-item">
                        <a href="${baseUrl}Temp-images/dd.jpg">
                            <img src="${baseUrl}Temp-images/dd.jpg"/>
                            <h3 class="am-gallery-title">服务号：Amaze UI</h3>
                        </a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</footer>
<script type="text/javascript">

    function clickSubmit(massageId) {
        // 读取 text
        var content=$("#massageContent").val();

        if (content!=""){
            $.post("${baseUrl}saveComment",{massageId:massageId,commentContent:content},function (data) {
                if(data==1){

                    location.href="${baseUrl}massages/${massage.id}";
                }
            });
        }else {
            alert("内容不能为空！！！")
        }
    }

    function clickVUserBtn(vUserId,btn) {

        if($(btn).attr("key")==1){

            $.post("${baseUrl}saveCollectionVUser",{vUserId:vUserId},function (data) {

                if(data=="1"){
                    $(btn).html("已关注");

                }
                if(data=="2"){
                    $(btn).html("关注过");

                }
            });
        }
        $(btn).attr("key","2");

    }

</script>
</body>
</html>
