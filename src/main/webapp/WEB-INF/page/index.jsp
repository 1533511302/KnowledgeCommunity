<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2018/10/19
  Time: 16:12
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
    <link rel="stylesheet" href="${baseUrl}assets/css/amazeui.css">
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
    <script>
        function clickCommentBtn(massageId,btn) {
            if($(btn).attr("key")==1){
            $.post("indexComment",{massageId:massageId},function (data) {
                $.each(data,function (i,comment) {
                    if($(btn).attr("flag")=="new"){
                        $("#new"+massageId).append(" <li class=\"am-comment am-comment-highlight\">\n" +
                            "                                <article class=\"am-comment\" style=\"margin-top: -20px;margin-bottom: -20px;margin-left: 30px;\">\n" +
                            "                                    <a href=\"#link-to-user-home\">\n" +
                            "                                        <img src=\"${baseUrl}Temp-images/face2.jpg\" alt=\"\" class=\"am-comment-avatar\" width=\"48\" height=\"48\"/>\n" +
                            "                                    </a>\n" +
                            "\n" +
                            "                                    <div class=\"am-comment-main\">\n" +
                            "                                        <header class=\"am-comment-hd\">\n" +
                            "                                            <!--<h3 class=\"am-comment-title\">评论标题</h3>-->\n" +
                            "                                            <div class=\"am-comment-meta\">\n" +
                            "                                                <a href=\"#link-to-user\" class=\"am-comment-author\">某人</a>\n" +
                            "                                                评论于 <time datetime=\"2013-07-27T04:54:29-07:00\" title=\"2013年7月27日 下午7:54 格林尼治标准时间+0800\">"+comment.createTime+"</time>\n" +
                            "                                            </div>\n" +
                            "                                        </header>\n" +
                            "\n" +
                            "                                        <div class=\"am-comment-bd\">\n" +
                            "                                            "+comment.commentContent+"\n" +
                            "                                        </div>\n" +
                            "                                    </div>\n" +
                            "                                </article>\n" +
                            "                            </li>")

                    }else {
                    $("#"+massageId).append(" <li class=\"am-comment am-comment-highlight\">\n" +
                        "                                <article class=\"am-comment\" style=\"margin-top: -20px;margin-bottom: -20px;margin-left: 30px;\">\n" +
                        "                                    <a href=\"#link-to-user-home\">\n" +
                        "                                        <img src=\"${baseUrl}Temp-images/face2.jpg\" alt=\"\" class=\"am-comment-avatar\" width=\"48\" height=\"48\"/>\n" +
                        "                                    </a>\n" +
                        "\n" +
                        "                                    <div class=\"am-comment-main\">\n" +
                        "                                        <header class=\"am-comment-hd\">\n" +
                        "                                            <!--<h3 class=\"am-comment-title\">评论标题</h3>-->\n" +
                        "                                            <div class=\"am-comment-meta\">\n" +
                        "                                                <a href=\"#link-to-user\" class=\"am-comment-author\">某人</a>\n" +
                        "                                                评论于 <time datetime=\"2013-07-27T04:54:29-07:00\" title=\"2013年7月27日 下午7:54 格林尼治标准时间+0800\">"+comment.createTime+"</time>\n" +
                        "                                            </div>\n" +
                        "                                        </header>\n" +
                        "\n" +
                        "                                        <div class=\"am-comment-bd\">\n" +
                        "                                            "+comment.commentContent+"\n" +
                        "                                        </div>\n" +
                        "                                    </div>\n" +
                        "                                </article>\n" +
                        "                            </li>")

                    }
                });
            },'json');
            $(btn).attr("key",2);
            }else {
                $("#"+massageId).empty();
                $("#new"+massageId).empty();
                $(btn).attr("key",1);
            }
        };

        function clickLikeNumbBtn(massageId,likeNumb,btn) {
            if($(btn).attr("key")==1){
                $.post("AddLikeNum",{massageId:massageId},function (data) {
                    if(data){
                        $(btn).attr("data-am-popover","{content: '鄙是点击显示的'}");
                        $(btn).html("<i class=\"am-icon-caret-up\"></i>&nbsp;赞&nbsp;"+(likeNumb+1));
                    }
                });
                $(btn).attr("key","2");
            }
        }

        function clickCollectionBtn(massageId,btn) {

            if($(btn).attr("key")==1){

                $.post("saveCollectionMassage",{massageId:massageId},function (data) {

                    if(data=="1"){
                        $(btn).html("<i class='am-icon-heart'></i>&nbsp;已收藏");

                    }
                    if(data=="2"){
                        $(btn).html("<i class='am-icon-heart'></i>&nbsp;收藏过");

                    }
                });
            }
            $(btn).attr("key","2");

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
                <li class="am-active"><a href="${baseUrl}toIndex">首页</a></li>
                <li><a href="${baseUrl}massagePage">图文</a></li>
                <li><a href="${baseUrl}audioPage">音频</a></li>
                <li><a href="${baseUrl}topics/1">问答</a></li>
                <li><a href="${baseUrl}vUsers/1">大咖秀</a></li>
                <li class="am-dropdown" data-am-dropdown>
                    <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
                        付费专区<span class="am-icon-caret-down"></span>
                    </a>
                    <ul class="am-dropdown-content">
                        <li class="am-dropdown-header">付费内容</li>
                        <li><a href="#">图文付费</a></li>
                        <li><a href="#">音频付费</a></li>
                        <li><a href="#">问答付费</a></li>

                    </ul>
                </li>
            </ul>
            <form action="${baseUrl}massages/likeName" class="am-topbar-form am-topbar-left am-form-inline" role="search">
                <div class="am-form-group" style="margin-top: 9px;margin-left: 100px">
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
<!--banner-->
<div class="banner">
    <div class="am-g am-container">
        <div class="am-u-sm-12 am-u-md-12 am-u-lg-8">
            <div data-am-widget="slider" class="am-slider am-slider-c1" data-am-slider='{"directionNav":false}' >
                <ul class="am-slides">
                    <c:forEach var="massage" items="${likeMassageList}" varStatus="index">
                    <li>
                        <a href="${baseUrl}massages/${massage.id}"><img src="/img/${massage.photo}" style="height: 420px;"></a>
                        <div class="am-slider-desc">${massage.title}</div>
                    </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="am-u-sm-0 am-u-md-0 am-u-lg-4 padding-none">
            <div class="star am-container"><span><img src="images/star.png">音频</span></div>
            <ul class="padding-none am-gallery am-avg-sm-2 am-avg-md-4 am-avg-lg-2 am-gallery-overlay" data-am-gallery="{ pureview: true }" >
                <c:forEach var="audio" items="${audioList}">
                    <li>
                        <div class="am-gallery-item">
                            <a href="${baseUrl}audio/${audio.id}">
                                <img src="/img/${audio.photo}"  alt="${audio.audioName}"/>
                                <h3 class="am-gallery-title">${audio.audioName}</h3>
                                <div class="am-gallery-desc">2375-09-26</div>
                            </a>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>

<!--banner2-->
<div class="am-container">
    <ul class="padding-none banner2 am-gallery am-avg-sm-2 am-avg-md-4 am-avg-lg-4 am-gallery-overlay" data-am-gallery="{ pureview: true }" >
        <c:forEach var="topic" items="${randTopicList}" varStatus="index">
        <li>
            <div class="am-gallery-item">
                <a href="${baseUrl}questionList/${topic.id}">
                    <img src="/img/${topic.photo}"  alt="话题配图" style="height: 160px;"/>
                    <h3 class="am-gallery-title">${topic.topicName}</h3>
                    <div class="am-gallery-desc">2375-09-26</div>
                </a>
            </div>
        </li>
        </c:forEach>
    </ul>
</div>
<!--news-->
<div class="am-g am-container newatype">
    <div class="am-u-sm-12 am-u-md-12 am-u-lg-8 oh">
        <div data-am-widget="titlebar" class="am-titlebar am-titlebar-default" style="border-bottom: 0px; margin-bottom: -10px">
            <h2 class="am-titlebar-title ">
                热门资讯
            </h2>
            <nav class="am-titlebar-nav">
                <a href="#more">more &raquo;</a>
            </nav>
        </div>

        <div data-am-widget="list_news" class="am-list-news am-list-news-default news">
            <div class="am-list-news-bd">
                <ul class="am-list">
                    <c:forEach var="massage" items="${hotMassageList}" varStatus="index">
                        <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
                            <div class="am-u-sm-5 am-list-thumb">
                                <a href="#">
                                    <img src="/img/${massage.photo}" alt="配图"/>
                                </a>
                            </div>

                            <div class=" am-u-sm-7 am-list-main">
                                <h2 class="am-list-item-hd"><a href="${baseUrl}massages/${massage.id}">${massage.title}</a></h2>

                                <div class="am-list-item-text">${massage.content}</div>

                            </div>
                            <div style="width:840px;height:50px;margin-top: 120px;">
                                <div class="am-btn-group">
                                <button class="am-btn am-btn-secondary am-radius" key="1"  onclick="clickLikeNumbBtn(${massage.id},${massage.likeNumb},this)"  data-am-popover="{content: '已经点赞成功！！'}"  style="width: 100px">
                                <i class="am-icon-caret-up"></i>
                                赞 ${massage.likeNumb}
                                </button>
                                <button class="am-btn am-btn-secondary am-radius" key="1" onclick="clickCommentBtn(${massage.id},this)"  style="width: 150px">
                                    <i class="am-icon-comment"></i>
                                ${massage.commentNumb}条评论
                                </button>

                                <button class="am-btn am-btn-secondary am-radius" key="1" onclick="clickCollectionBtn(${massage.id},this)"  style="width: 100px"  data-am-popover="{content: '已经添加收藏！！'}">
                                    <i class="am-icon-heart"></i>
                                收藏
                                </button>
                                <button class="am-btn am-btn-secondary" style="width: 100px">
                                    <i class="am-icon-eye"></i>
                                        ${massage.browseNumb}
                                </button>
                                </div>

                            </div>

                        </li>
                        <div class="newsico am-fr">
                            <i class="am-icon-clock-o">${massage.createTime}</i>
                        </div>
                        <ul id="${massage.id}" class="am-comments-list am-comments-list-flip">

                        </ul>
                    </c:forEach>
                </ul>
            </div>
            <a href="#"><img src="${baseUrl}Temp-images/ad2.png" class="am-img-responsive" width="100%"/></a>
            <div data-am-widget="titlebar" class="am-titlebar am-titlebar-default" style="border-bottom: 0px; margin-bottom: -10px">
                <h2 class="am-titlebar-title ">
                    最新资讯
                </h2>
                <nav class="am-titlebar-nav">
                    <a href="#more">more &raquo;</a>
                </nav>
            </div>
            <div class="am-list-news-bd">
                <ul class="am-list">
                    <c:forEach var="massage" items="${newMassageList}" varStatus="index">
                        <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left" style="border-top: 0px">
                            <div class="am-u-sm-5 am-list-thumb">
                                <a href="#">
                                    <img src="/img/${massage.photo}" alt="配图"/>
                                </a>
                            </div>

                            <div class=" am-u-sm-7 am-list-main">
                                <h2 class="am-list-item-hd"><a href="${baseUrl}massages/${massage.id}">${massage.title}</a></h2>

                                <div class="am-list-item-text">${massage.content}</div>

                            </div>
                            <div style="width:840px;height:50px;margin-top: 120px;">
                                <div class="am-btn-group">
                                    <button class="am-btn am-btn-secondary am-radius" key="1" onclick="clickLikeNumbBtn(${massage.id},${massage.likeNumb},this)"  data-am-popover="{content: '已经点赞成功！！'}" style="width: 100px">
                                        <i class="am-icon-caret-up"></i>
                                        赞 ${massage.likeNumb}
                                    </button>
                                    <button class="am-btn am-btn-secondary am-radius"  key="1" flag="new" onclick="clickCommentBtn('${massage.id}',this)" style="width: 150px">
                                        <i class="am-icon-comment"></i>
                                            ${massage.commentNumb}条评论
                                    </button>

                                    <button class="am-btn am-btn-secondary am-radius" style="width: 100px"  key="1" onclick="clickCollectionBtn(${massage.id},this)"  style="width: 100px"  data-am-popover="{content: '已经添加收藏！！'}">
                                        <i class="am-icon-heart"></i>
                                        收藏
                                    </button>
                                    <button class="am-btn am-btn-secondary" style="width: 100px">
                                        <i class="am-icon-eye"></i>
                                            ${massage.browseNumb}
                                    </button>
                                </div>

                            </div>

                        </li>
                        <div class="newsico am-fr">
                            <i class="am-icon-clock-o">${massage.createTime}</i>
                        </div>
                        <ul id="new${massage.id}" class="am-comments-list am-comments-list-flip">

                        </ul>
                    </c:forEach>
                </ul>
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
        <div class="btnlogo"><img src="images/btnlogo.png"/></div>
        <p>knowledge出品<br>© 2016 AllMobilize, Inc. Licensed under MIT license. Developed with WebStorm.</p>
        <div class="w2div">
            <ul data-am-widget="gallery" class="am-gallery am-avg-sm-2
  am-avg-md-2 am-avg-lg-2 am-gallery-overlay" data-am-gallery="{ pureview: true }" >
                <li class="w2">
                    <div class="am-gallery-item">
                        <a href="Temp-images/dd.jpg">
                            <img src="Temp-images/dd.jpg" />
                            <h3 class="am-gallery-title">订阅号：</h3>
                        </a>
                    </div>
                </li>
                <li   class="w2">
                    <div class="am-gallery-item">
                        <a href="Temp-images/dd.jpg">
                            <img src="Temp-images/dd.jpg"/>
                            <h3 class="am-gallery-title">服务号：</h3>
                        </a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</footer>
</body>
</html>