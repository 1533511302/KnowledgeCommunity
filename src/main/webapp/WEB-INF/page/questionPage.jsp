<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2018/10/20
  Time: 14:44
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
    <script src="${baseUrl}img/vendor/jquery/jquery-3.2.1.min.js"></script>

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
                <li><a href="${baseUrl}massagePage">图文</a></li>
                <li><a href="${baseUrl}audioPage">音频</a></li>
                <li class="am-active"><a href="${baseUrl}topics/1">问答</a></li>
                <li><a href="${baseUrl}vUsers/1">大咖秀</a></li>

            </ul>
            <form action="${baseUrl}topics/likeName" class="am-topbar-form am-topbar-left am-form-inline" role="search">
                <div class="am-form-group" style="margin-top: 12px;margin-left: 10px">
                    <input name="name" type="text" class="am-form-field am-input-sm" placeholder="搜索内容" value="${name}">
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
    <div class="am-g am-container padding-none">
        <div class="am-u-sm-12 am-u-md-12 am-u-lg-8 padding-none">
            <div class="am-container" style="margin-top: 10px">
                <div class="am-panel am-panel-success">
                    <div class="am-panel-hd">问题：<h3 style="float: right;font-size: 18px;color:#dd514c"><span class="am-icon-eye">&nbsp;&nbsp;</span>${question.browseNumb}</h3></div>
                    <div class="am-panel-bd" style="padding: 1rem;padding-bottom: 0.2rem">
                        <h2>${question.quesName}</h2>


                    </div>
                    <div class="am-panel-bd">
                        ${question.quesDescribe}
                    </div>
                    <footer class="am-panel-footer" style="margin-top: 1px">一共有${question.answerNumb}回答</footer>
                </div>
            </div>

        </div>
        <div class="am-u-sm-0 am-u-md-0 am-u-lg-4 padding-none lrad">
            <div data-am-widget="titlebar" class="am-titlebar am-titlebar-default" style="border-bottom: 0px; margin-bottom: -10px">
                <h2 class="am-titlebar-title ">
                    话题
                </h2>

            </div>
            <ul class="am-avg-sm-1 am-avg-md-2 am-avg-lg-1" style="margin-top: 30px;margin-left: 10px">
                <li class="ms" style="line-height: 50px">

                    <c:forEach var="topic" items="${topicList.list}" varStatus="v">
                        <c:set var="badge" value="${v.index%4==1?'am-badge-primary':(v.index%4==2?'am-badge-secondary':(v.index%4==3?'am-badge-success':'am-badge-warning'))}"/>

                        <a class="am-badge am-round ${badge} am-text-lg" style="margin-left: 10px" href="${baseUrl}questionList/${topic.id}">${topic.topicName}</a>
                    </c:forEach>
                </li>

            </ul>
        </div>
    </div>
</div>
<div class="am-g am-container newatype">
    <div class="am-u-sm-12 am-u-md-12 am-u-lg-8 oh">
        <div data-am-widget="list_news" class="am-list-news am-list-news-default ">
            <div class="am-list-news-bd">
                <div data-am-widget="titlebar" class="am-titlebar am-titlebar-default" style="border-bottom: 0px; margin-bottom: -10px">
                    <h2 class="am-titlebar-title ">
                        回答
                    </h2>
                    <nav class="am-titlebar-nav">
                        <a href="#more">more &raquo;</a>
                    </nav>
                </div>
                <ul id="answerList" class="am-comments-list am-comments-list-flip">
                    <c:forEach var="answer" items="${pageInfo.list}" varStatus="index">
                        <li class="am-comment am-comment-primary">
                            <article class="am-comment">
                                <a href="#link-to-user-home">
                                    <img src="/img/${answer.photo}" alt="" class="am-comment-avatar" width="48" height="48"/>
                                </a>
                                <div class="am-comment-main">
                                    <header class="am-comment-hd">
                                        <!--<h3 class=\"am-comment-title\">评论标题</h3>-->
                                        <div class="am-comment-meta">
                                            <a href="#" class="am-comment-author">${answer.username}</a>
                                            回答于 <time datetime="2013-07-27T04:54:29-07:00" title="2018年7月27日 下午7:54 格林尼治标准时间+0800">${answer.createTime}</time>
                                        </div>
                                    </header>

                                    <div class="am-comment-bd">
                                            ${answer.answerContent}
                                    </div>
                                </div>
                            </article>
                        </li>
                    </c:forEach>
                </ul>
                <div class="am-fr"></div>
                <button type="button" class="am-badge-secondary am-btn am-btn-block" onclick="clickMoreBtn(${question.id},this)" style="margin-top: 20px;margin-bottom: 20px;">更多回答</button>
            </div>

                <div class="am-container" style="margin-top: 10px">
                    <div class="am-panel am-panel-success">
                        <div class="am-panel-hd">回答</div>

                        <fieldset>
                            <div class="am-form-group">
                                <textarea id="answerContent" style="width: 100%;" rows="6" placeholder="回答内容编辑"></textarea>
                            </div>


                        </fieldset>

                    </div>
                    <div class="star am-container mcenter"><span><button id="save" type="button" class="am-btn am-btn-primary" onclick="clickSubmit(${question.id})" style="width: 120px">提交</button></span></div>

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
        <div class="btnlogo"><img src="${baseUrl}images/btnlogo.png"/></div>
        <p>knowledge出品<br>© 2016 AllMobilize, Inc. Licensed under MIT license. Developed with WebStorm.</p>
        <div class="w2div">
            <ul data-am-widget="gallery" class="am-gallery am-avg-sm-2
  am-avg-md-2 am-avg-lg-2 am-gallery-overlay" data-am-gallery="{ pureview: true }" >
                <li class="w2">
                    <div class="am-gallery-item">
                        <a href="${baseUrl}Temp-images/dd.jpg">
                            <img src="${baseUrl}Temp-images/dd.jpg" />
                            <h3 class="am-gallery-title">订阅号：</h3>
                        </a>
                    </div>
                </li>
                <li   class="w2">
                    <div class="am-gallery-item">
                        <a href="${baseUrl}Temp-images/dd.jpg">
                            <img src="${baseUrl}Temp-images/dd.jpg"/>
                            <h3 class="am-gallery-title">服务号：</h3>
                        </a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</footer>

<script type="text/javascript">

    function clickSubmit(quesId) {
        // 读取 text
        var content=$("#answerContent").val();
            if (content!=""){
                $.post("${baseUrl}saveAnswer",{quesId:quesId,answerContent:content},function (data) {
                    if(data=="1"){
                        alert("提交成功");
                        location.reload();
                    }else {
                        alert("权限不够,必须为认证用户才可作答！");
                    }
                });
            }else {
                alert("内容不能为空！！！")
            }
    }

    var pageNum = 1;
    function clickMoreBtn(questId,btn) {
        pageNum++;
        $.post("${baseUrl}answerListByQuestionId/"+questId,{page:pageNum},function (data) {

            if (data.length==0){
                $(btn).html("已经到底了，没有更多的回答了");
            }else {
            $.each(data,function (i,answer) {
                console.log(answer.id);
                var temp="<li class=\"am-comment am-comment-primary\">\n" +
                    "                            <article class=\"am-comment\">\n" +
                    "                                <a href=\"#link-to-user-home\">\n" +
                    "                                    <img src=\"${baseUrl}Temp-images/face2.jpg\" alt=\"\" class=\"am-comment-avatar\" width=\"48\" height=\"48\"/>\n" +
                    "                                </a>\n" +
                    "                                <div class=\"am-comment-main\">\n" +
                    "                                    <header class=\"am-comment-hd\">\n" +
                    "                                        <div class=\"am-comment-meta\">\n" +
                    "                                            <a href=\"#link-to-user\" class=\"am-comment-author\">"+answer.username+"</a>\n" +
                    "                                            回答于 <time datetime=\"2013-07-27T04:54:29-07:00\" title=\"2013年7月27日 下午7:54 格林尼治标准时间+0800\">"+answer.createTime+"</time>\n" +
                    "                                        </div>\n" +
                    "                                    </header>\n" +
                    "\n" +
                    "                                    <div class=\"am-comment-bd\">\n" +
                    "                                            "+answer.answerContent+"\n" +
                    "                                    </div>\n" +
                    "                                </div>\n" +
                    "                            </article>\n" +
                    "                        </li>";
                $("#answerList").append(temp);
            });
            }
        });

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
