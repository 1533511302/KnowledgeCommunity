<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2018/11/25
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <li><a href="${baseUrl}topics/1">问答</a></li>
                <li  class="am-active"><a href="${baseUrl}vUsers/1">大咖秀</a></li>
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

            <form action="${baseUrl}vUsersCategory/${user.id}/likeTitle" class="am-topbar-form am-topbar-left am-form-inline" role="search">
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
                    <p>图文：<span>${user.massagenumb}</span>
                    <p>问题：<span>${user.questionnumb}</span> &nbsp;回答：<span>${user.answernumb}</span></p></p>

                </div>
            </div>

        </div>
        <div class="am-u-sm-0 am-u-md-12 am-u-lg-4 am-show-lg-only userinfo_center">
            ${user.introduce}
        </div>

            <div class="am-u-sm-12 am-u-md-12 am-u-lg-3 am-show-lg-only userinfo_right">
                <a href="${baseUrl}toUpdateUserPassword/${user.id}"><button type="button" class="am-btn am-btn-warning">
                    <i class="am-icon-pencil-square"></i>
                    修改密码
                </button></a>
            </div>


    </div>
</div>
<hr data-am-widget="divider" style="" class="am-divider am-divider-default" />
<div class="star am-container mcenter"><span>我的个人信息</span></div>
<div>

    <div class="am-container" style="margin-top: 10px">
        <div class="am-panel am-panel-success">
            <div class="am-panel-hd">个人信息</div>
            <div class="am-panel-bd" style="padding: 1rem;padding-bottom: 0.2rem">

                <form class="am-form" action="${baseUrl}updateUser" method="post" enctype="multipart/form-data">
                    <fieldset disabled id="field">
                        <div class="am-form-group">
                            <label for="doc-ipt-name-1">真实姓名</label>
                            <input type="text" class="" id="doc-ipt-name-1" name="realname" value="${user.realname}" placeholder="输入真实姓名">
                        </div>

                        <div class="am-form-group">
                            <label for="doc-ipt-email-1">邮件</label>
                            <input type="email" class="" id="doc-ipt-email-1" name="email" value="${user.email}" placeholder="输入电子邮件">
                        </div>

                        <div class="am-form-group">
                            <label for="doc-ipt-name-2">简介（如：清华教授、人工智能专家）</label>
                            <input type="text" class="" id="doc-ipt-name-2" name="introduce" value="${user.autograph}" placeholder="一句话概括干什么的">
                        </div>

                        <div class="am-form-group">
                            <label for="doc-select-1">性别</label>
                            <select id="doc-select-1" name="gender">
                                <c:if test="${user.gender=='1'}">
                                    <option value="1" selected>男</option>
                                    <option value="2">女</option>
                                </c:if>
                                <c:if test="${user.gender=='2'}">
                                    <option value="1">男</option>
                                    <option value="2" selected>女</option>
                                </c:if>

                            </select>
                            <span class="am-form-caret"></span>
                        </div>

                        <div class="am-form-group">
                            <label for="photo">头像上传：</label>
                            <input type="file" name="photo" id="photo">
                            <p class="am-form-help">请选择要上传的图片...</p>
                        </div>

                       <%-- <div class="am-form-group am-form-file">
                            <label for="doc-ipt-file-2">图片上传</label>
                            <div>
                                <button type="button" class="am-btn am-btn-default am-btn-sm">
                                    <i class="am-icon-cloud-upload"></i> 选择要上传的文件</button>
                            </div>
                            <input type="file" id="doc-ipt-file-2">
                        </div>--%>



                        <div class="am-form-group">
                            <label for="doc-ta-1">个人介绍</label>
                            <textarea class="" rows="5" id="doc-ta-1" name="introduce">${user.introduce}</textarea>
                        </div>
                        <div class="star am-container mcenter">
                            <span><button id="submit" type="submit" class="am-btn am-btn-secondary">提交</button></span>
                        </div>
                    </fieldset>
                </form>
            </div>

        </div>
    </div>

    <div class="star am-container mcenter">
        <span><button type="button"  class="am-btn am-btn-primary am-radius" style="width: 150px" onclick="onClickUpdateBtn()">修改</button></span>
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
</body>
<script>
    function  onClickUpdateBtn() {
       $("fieldset").removeAttr("disabled");
    }
    function onClickSaveBtn() {

    }
</script>
</html>
