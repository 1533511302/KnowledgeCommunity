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
            <form action="${baseUrl}topics/likeName" class="am-topbar-form am-topbar-left am-form-inline" role="search">
                <div class="am-form-group" style="margin-top: 9px;margin-left: 100px">
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

<div class="star am-container mcenter"><span><img src="${baseUrl}images/star.png">话题</span></div>
<div class="am-container events">
    <ul data-am-widget="gallery" class="am-gallery am-avg-sm-1 am-avg-md-3 am-avg-lg-3 am-gallery-bordered" data-am-gallery="{  }" >
        <c:forEach var="topic" items="${pageInfo.list}" varStatus="index">
            <li>
                <div class="am-gallery-item">
                    <a href="${baseUrl}questionList/${topic.id}" class="">
                        <img src="${baseUrl}Temp-images/question.jpg"  alt="远方 有一个地方 那里种有我们的梦想"/>
                        <div class="efe">${topic.topicName}</div>
                        <p>${topic.topicDescribe}</p>
                        <div class="am-gallery-desc fee">
                            <div class="am-fl">成都</div>
                            <div class="am-fr">${topic.createTime}</div>
                        </div>
                    </a>
                </div>
            </li>
        </c:forEach>
    </ul>
    <div class="am-fr"></div>

</div>

<div class="am-container" style="margin: 20px auto">
    <ul data-am-widget="pagination" class="am-pagination am-pagination-default am-text-center">

        <li class="am-pagination-first ">
            <a href="<c:url value="/topics/1"/>">首页</a>
        </li>

        <li class="am-pagination-prev ">
            <a href="<c:url value="/topics/${pageInfo.pageNum-1>1?pageInfo.pageNum-1:1}"/>">&laquo;</a>
        </li>
        <c:set var="start" value="${pageInfo.pageNum-5<=0?1:pageInfo.pageNum-5}"/>
        <c:set var="end" value="${start+9<pageInfo.pages?start+9:pageInfo.pages}"/>
        <c:forEach begin="${start}" end="${end}" varStatus="loop">
            <c:set var="active" value="${loop.index==pageInfo.pageNum?'am-active':''}"/>


            <li class="${active}">
                <a href="<c:url value="/topics/${loop.index}"/>">${loop.index}</a>
            </li>
        </c:forEach>

        <li class="am-pagination-next ">
            <a href="<c:url value="/topics/${pageInfo.pageNum+1<pageInfo.pages?pageInfo.pageNum+1:pageInfo.pages}"/>">&raquo;</a>
        </li>

        <li class="am-pagination-last ">
            <a href="<c:url value="/topics/${pageInfo.pages}"/>">尾页</a>
        </li>
    </ul>
</div>
<div class="am-container" style="margin-top: 10px">
    <div class="am-panel am-panel-success">
        <div class="am-panel-hd">编辑器</div>
        <div data-am-widget="titlebar" class="am-titlebar am-titlebar-default" style="border-bottom: 10px; margin-bottom: 10px">
            <h2 class="am-titlebar-title ">
                选择分类&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </h2>

            <select id="doc-select-1" style="width: 200px;height: 36px;">
                <option value="0">---未选择---</option>
            </select>
        </div>

        <div class="am-input-group am-input-group-primary" style="margin-top: 20px;margin-bottom: 20px">
            <span class="am-input-group-label"><i class="am-icon-user am-icon-fw"></i></span>
            <input id="quesTitle" type="text" class="am-form-field" placeholder="问题">
        </div>

        <h3 class="blog-comment">描述</h3>
        <fieldset>
            <div class="am-form-group">
                <textarea id="quesContent" style="width: 100%;" rows="6" placeholder="问题描述"></textarea>
            </div>


        </fieldset>

    </div>
    <div class="star am-container mcenter"><span><button id="save" type="button" class="am-btn am-btn-primary" onclick="clickSubmit()" style="width: 120px">提交</button></span></div>

</div>

<div class="star am-container mcenter"><span><img src="${baseUrl}images/star.png">媒体报道</span></div>
<div class="am-container">
    <ul data-am-widget="gallery" class="am-gallery am-avg-sm-2 am-avg-md-4 am-avg-lg-6 am-gallery-bordered" data-am-gallery="{  }" >
        <li>
            <div class="am-gallery-item">
                <a href="http://s.amazeui.org/media/i/demos/bing-1.jpg" class="">
                    <img src="http://s.amazeui.org/media/i/demos/bing-1.jpg"  alt="远方 有一个地方 那里种有我们的梦想"/>
                    <h3 class="am-gallery-title">远方 有一个地方 那里种有我们的梦想</h3>
                    <div class="am-gallery-desc">2375-09-26</div>
                </a>
            </div>
        </li>
        <li>
            <div class="am-gallery-item">
                <a href="http://s.amazeui.org/media/i/demos/bing-2.jpg" class="">
                    <img src="http://s.amazeui.org/media/i/demos/bing-2.jpg"  alt="某天 也许会相遇 相遇在这个好地方"/>
                    <h3 class="am-gallery-title">某天 也许会相遇 相遇在这个好地方</h3>
                    <div class="am-gallery-desc">2375-09-26</div>
                </a>
            </div>
        </li>
        <li>
            <div class="am-gallery-item">
                <a href="http://s.amazeui.org/media/i/demos/bing-3.jpg" class="">
                    <img src="http://s.amazeui.org/media/i/demos/bing-3.jpg"  alt="不要太担心 只因为我相信"/>
                    <h3 class="am-gallery-title">不要太担心 只因为我相信</h3>
                    <div class="am-gallery-desc">2375-09-26</div>
                </a>
            </div>
        </li>
        <li>
            <div class="am-gallery-item">
                <a href="http://s.amazeui.org/media/i/demos/bing-4.jpg" class="">
                    <img src="http://s.amazeui.org/media/i/demos/bing-4.jpg"  alt="终会走过这条遥远的道路"/>
                    <h3 class="am-gallery-title">终会走过这条遥远的道路</h3>
                    <div class="am-gallery-desc">2375-09-26</div>
                </a>
            </div>
        </li>
        <li>
            <div class="am-gallery-item">
                <a href="http://s.amazeui.org/media/i/demos/bing-1.jpg" class="">
                    <img src="http://s.amazeui.org/media/i/demos/bing-1.jpg"  alt="远方 有一个地方 那里种有我们的梦想"/>
                    <h3 class="am-gallery-title">远方 有一个地方 那里种有我们的梦想</h3>
                    <div class="am-gallery-desc">2375-09-26</div>
                </a>
            </div>
        </li>
        <li>
            <div class="am-gallery-item">
                <a href="http://s.amazeui.org/media/i/demos/bing-2.jpg" class="">
                    <img src="http://s.amazeui.org/media/i/demos/bing-2.jpg"  alt="某天 也许会相遇 相遇在这个好地方"/>
                    <h3 class="am-gallery-title">某天 也许会相遇 相遇在这个好地方</h3>
                    <div class="am-gallery-desc">2375-09-26</div>
                </a>
            </div>
        </li>
        <li>
            <div class="am-gallery-item">
                <a href="http://s.amazeui.org/media/i/demos/bing-3.jpg" class="">
                    <img src="http://s.amazeui.org/media/i/demos/bing-3.jpg"  alt="不要太担心 只因为我相信"/>
                    <h3 class="am-gallery-title">不要太担心 只因为我相信</h3>
                    <div class="am-gallery-desc">2375-09-26</div>
                </a>
            </div>
        </li>
        <li>
            <div class="am-gallery-item">
                <a href="http://s.amazeui.org/media/i/demos/bing-4.jpg" class="">
                    <img src="http://s.amazeui.org/media/i/demos/bing-4.jpg"  alt="终会走过这条遥远的道路"/>
                    <h3 class="am-gallery-title">终会走过这条遥远的道路</h3>
                    <div class="am-gallery-desc">2375-09-26</div>
                </a>
            </div>
        </li>
        <li>
            <div class="am-gallery-item">
                <a href="http://s.amazeui.org/media/i/demos/bing-3.jpg" class="">
                    <img src="http://s.amazeui.org/media/i/demos/bing-3.jpg"  alt="不要太担心 只因为我相信"/>
                    <h3 class="am-gallery-title">不要太担心 只因为我相信</h3>
                    <div class="am-gallery-desc">2375-09-26</div>
                </a>
            </div>
        </li>
        <li>
            <div class="am-gallery-item">
                <a href="http://s.amazeui.org/media/i/demos/bing-4.jpg" class="">
                    <img src="http://s.amazeui.org/media/i/demos/bing-4.jpg"  alt="终会走过这条遥远的道路"/>
                    <h3 class="am-gallery-title">终会走过这条遥远的道路</h3>
                    <div class="am-gallery-desc">2375-09-26</div>
                </a>
            </div>
        </li>
        <li>
            <div class="am-gallery-item">
                <a href="http://s.amazeui.org/media/i/demos/bing-3.jpg" class="">
                    <img src="http://s.amazeui.org/media/i/demos/bing-3.jpg"  alt="不要太担心 只因为我相信"/>
                    <h3 class="am-gallery-title">不要太担心 只因为我相信</h3>
                    <div class="am-gallery-desc">2375-09-26</div>
                </a>
            </div>
        </li>
        <li>
            <div class="am-gallery-item">
                <a href="http://s.amazeui.org/media/i/demos/bing-4.jpg" class="">
                    <img src="http://s.amazeui.org/media/i/demos/bing-4.jpg"  alt="终会走过这条遥远的道路"/>
                    <h3 class="am-gallery-title">终会走过这条遥远的道路</h3>
                    <div class="am-gallery-desc">2375-09-26</div>
                </a>
            </div>
        </li>
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
<script src="https://cdn.bootcss.com/jquery/3.1.0/jquery.js"></script>
<script type="text/javascript">
    $.get("${baseUrl}topics",null,function (data) {
        $.each(data,function (i,topic) {
            $("#doc-select-1").append("<option value='"+topic.id+"'>"+topic.topicName+"</option>")
        });
    });

    function clickSubmit() {
        // 读取 text
        var type=$("#doc-select-1 option:selected").val();
        var title=$("#quesTitle").val();
        var content=$("#quesContent").val();
        console.log(type);
        console.log(content);
        console.log(title);
        if(type!="0"){
            if (title!="" && content!=""){
                $.post("${baseUrl}saveQuestion",{topicId:type,quesName:title,quesDescribe:content},function (data) {
                    if(data=1){
                        alert("提交成功");
                    }
                });
            }else {
                alert("标题和内容不能为空！！！")
            }


        }else{

            alert("没有选择分类！！！")
        }
    }

</script>
</body>
</html>
