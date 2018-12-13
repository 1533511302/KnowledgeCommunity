<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2018/10/25
  Time: 21:41
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
                <li><a href="${baseUrl}massagePage">图文</a></li>
                <li class="am-active"><a href="${baseUrl}audioPage">音频</a></li>
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

<div id="category_top">
    <div class="am-hide-lg-only kz" id="leftbtn">
        <i class="am-icon-angle-left" ></i>
    </div>
    <div class="am-hide-lg-only kz" style="right:0px;" id="rightbtn">
        <i class="am-icon-angle-right"></i>
    </div>
    <div class="am-container" >
        <ul class="am-avg-sm-2 am-avg-md-3 am-avg-lg-6 am-thumbnails" id="topface">
            <li>
                <a href="category2.html">
                    <div class="ctl active">
                        <img src="${baseUrl}Temp-images/face1.jpg">
                        <h3>情商课</h3>
                        <p>蔡康永</p>
                    </div>
                    <button type="button" class="am-btn am-btn-primary">专辑推荐</button>
                </a>
            </li>
            <li>
                <a href="http://www.sina.com">
                    <div class="ctl">
                        <img src="${baseUrl}Temp-images/face2.jpg">
                        <h3>矮大紧指北</h3>
                        <p>高晓松</p>
                    </div>
                    <button type="button" class="am-btn am-btn-default">专辑推荐</button>
                </a>
            </li>
            <li>
                <a href="http://www.qq.com">
                    <div class="ctl">
                        <img src="${baseUrl}Temp-images/face3.jpg">
                        <h3>像他一样说话</h3>
                        <p>崔永元</p>
                    </div>
                    <button type="button" class="am-btn am-btn-default">专辑推荐</button>
                </a>
            </li>
            <li>
                <a href="http://www.youku.com">
                    <div class="ctl">
                        <img src="${baseUrl}Temp-images/face4.jpg">
                        <h3>观复嘟嘟</h3>
                        <p>马未都</p>
                    </div>
                    <button type="button" class="am-btn am-btn-default">专辑推荐</button>
                </a>
            </li>
            <li>
                <a href="http://www.yahoo.com">
                    <div class="ctl">
                        <img src="${baseUrl}Temp-images/face5.jpg">
                        <h3>吴晓波频道</h3>
                        <p>吴晓波</p>
                    </div>
                    <button type="button" class="am-btn am-btn-default">专辑推荐</button>
                </a>
            </li>
            <li>
                <a href="http://www.china.com">
                    <div class="ctl">
                        <img src="${baseUrl}Temp-images/face6.jpg">
                        <h3>讲讲行天下</h3>
                        <p>刘宗华</p>
                    </div>
                    <button type="button" class="am-btn am-btn-default">专辑推荐</button>
                </a>
            </li>
        </ul>

    </div>

</div>

<script>
    var countnum=5 //一共多少个图 例如6个请输入5
    $("#leftbtn").click(function(){
        var temp_href=$("#topface li:eq(0) a").attr("href");
        var temp_img=$("#topface li:eq(0) img").attr("src");
        var temp_h3=$("#topface li:eq(0) h3").html();
        var temp_p=$("#topface li:eq(0) p").html();

        for (i=0; i<countnum; i++){
            var n=i+1;
            $("#topface li:eq("+i+") a").attr('href',$("#topface li:eq("+n+") a").attr("href"));
            $("#topface li:eq("+i+") img").attr('src',$("#topface li:eq("+n+") img").attr("src"));
            $("#topface li:eq("+i+") h3").html($("#topface li:eq("+n+") h3").html());
            $("#topface li:eq("+i+") p").html($("#topface li:eq("+n+") p").html());
        };
        $("#topface li:eq("+countnum+") a").attr('href',temp_href);
        $("#topface li:eq("+countnum+") img").attr('src',temp_img);
        $("#topface li:eq("+countnum+") h3").html(temp_h3);
        $("#topface li:eq("+countnum+") p").html(temp_p);
    });
    $("#rightbtn").click(function(){
        var temp_href=$("#topface li:eq("+countnum+") a").attr("href");
        var temp_img=$("#topface li:eq("+countnum+") img").attr("src");
        var temp_h3=$("#topface li:eq("+countnum+") h3").html();
        var temp_p=$("#topface li:eq("+countnum+") p").html();

        for (i=countnum; i>0; i--){
            var n=i-1;
            $("#topface li:eq("+i+") a").attr('href',$("#topface li:eq("+n+") a").attr("href"));
            $("#topface li:eq("+i+") img").attr('src',$("#topface li:eq("+n+") img").attr("src"));
            $("#topface li:eq("+i+") h3").html($("#topface li:eq("+n+") h3").html());
            $("#topface li:eq("+i+") p").html($("#topface li:eq("+n+") p").html());
        };
        $("#topface li:eq(0) a").attr('href',temp_href);
        $("#topface li:eq(0) img").attr('src',temp_img);
        $("#topface li:eq(0) h3").html(temp_h3);
        $("#topface li:eq(0) p").html(temp_p);
    });
</script>

<div class="star am-container mcenter"><span><a class="am-badge am-badge-secondary am-text-xl" style="margin-left: 10px" href="${baseUrl}editAudioPage">分享音频</a></span></div>
<div class="am-container" style="margin-top: 10px">
    <div data-am-widget="titlebar" class="am-titlebar am-titlebar-default" style="border-bottom: 0px; margin-bottom: -10px">
        <h2 class="am-titlebar-title ">
            音频分类
        </h2>
    </div>
    <ul class="am-avg-sm-1 am-avg-md-2 am-avg-lg-1" style="margin-top: 30px;margin-left: 10px">
        <li class="ms" style="line-height: 50px">

            <c:forEach var="category" items="${categoryList}" varStatus="v">
                <c:set var="badge" value="${v.index%4==1?'am-badge-primary':(v.index%4==2?'am-badge-secondary':(v.index%4==3?'am-badge-success':'am-badge-warning'))}"/>

                <a class="am-badge am-round ${badge} am-text-lg" style="margin-left: 10px" href="${baseUrl}audioList/${category.id}">${category.categoryName}</a>
            </c:forEach>
        </li>

    </ul>
</div>

<hr data-am-widget="divider" style="" class="am-divider am-divider-default" />

<div class="star am-container mcenter"><span><img src="images/star.png">${categoryName1}</span></div>
<div class="am-container">
    <ul data-am-widget="gallery" class="am-gallery am-avg-sm-2 am-avg-md-4 am-avg-lg-6 am-gallery-bordered" data-am-gallery="{  }" >
        <c:forEach var="audio" items="${audioList1}" varStatus="v">
            <li>
            <div class="am-gallery-item">
                <a href="${baseUrl}audio/${audio.id}" class="">
                    <img src="/img/${audio.photo}"  alt="配图"/>
                    <h3 class="am-gallery-title">${audio.audioName}</h3>
                    <div class="am-gallery-desc">${audio.createTime}</div>
                </a>
            </div>
        </li>
        </c:forEach>

    </ul>

</div>
<hr data-am-widget="divider" style="" class="am-divider am-divider-default" />

<div class="star am-container mcenter"><span><img src="images/star.png">${categoryName2}</span></div>
<div class="am-container">
    <ul data-am-widget="gallery" class="am-gallery am-avg-sm-2 am-avg-md-4 am-avg-lg-6 am-gallery-bordered" data-am-gallery="{  }" >
        <c:forEach var="audio" items="${audioList2}" varStatus="v">
            <li>
                <div class="am-gallery-item">
                    <a href="${baseUrl}audio/${audio.id}" class="">
                        <img src="/img/${audio.photo}"  alt="配图"/>
                        <h3 class="am-gallery-title">${audio.audioName}</h3>
                        <div class="am-gallery-desc">${audio.createTime}</div>
                    </a>
                </div>
            </li>
        </c:forEach>

    </ul>

</div>
<hr data-am-widget="divider" style="" class="am-divider am-divider-default" />

<div class="star am-container mcenter"><span><img src="images/star.png">${categoryName3}</span></div>
<div class="am-container">
    <ul data-am-widget="gallery" class="am-gallery am-avg-sm-2 am-avg-md-4 am-avg-lg-6 am-gallery-bordered" data-am-gallery="{  }" >
        <c:forEach var="audio" items="${audioList3}" varStatus="v">
            <li>
                <div class="am-gallery-item">
                    <a href="${baseUrl}audio/${audio.id}" class="">
                        <img src="/img/${audio.photo}"  alt="配图"/>
                        <h3 class="am-gallery-title">${audio.audioName}</h3>
                        <div class="am-gallery-desc">${audio.createTime}</div>
                    </a>
                </div>
            </li>
        </c:forEach>

    </ul>

</div>
<hr data-am-widget="divider" style="" class="am-divider am-divider-default" />

<div class="star am-container mcenter"><span><img src="images/star.png">${categoryName4}</span></div>
<div class="am-container">
    <ul data-am-widget="gallery" class="am-gallery am-avg-sm-2 am-avg-md-4 am-avg-lg-6 am-gallery-bordered" data-am-gallery="{  }" >
        <c:forEach var="audio" items="${audioList4}" varStatus="v">
            <li>
                <div class="am-gallery-item">
                    <a href="${baseUrl}audio/${audio.id}" class="">
                        <img src="/img/${audio.photo}"  alt="配图"/>
                        <h3 class="am-gallery-title">${audio.audioName}</h3>
                        <div class="am-gallery-desc">${audio.createTime}</div>
                    </a>
                </div>
            </li>
        </c:forEach>

    </ul>

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
</body>
</html>