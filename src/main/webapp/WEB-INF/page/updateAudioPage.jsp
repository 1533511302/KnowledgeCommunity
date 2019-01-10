<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2018/10/29
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="baseUrl" value="${pageContext.request.contextPath}/"></c:set>

<!doctype html>
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
<div class="star am-container mcenter"><span>编写我的知识图文</span></div>
<div>

    <div class="am-container" style="margin-top: 10px">
        <div class="am-panel am-panel-success">
            <div class="am-panel-hd">编辑器</div>
            <div class="am-panel-bd" style="padding: 1rem;padding-bottom: 0.2rem">
                <input type="hidden" id="audioId" value="${audio.id}">
                <div data-am-widget="titlebar" class="am-titlebar am-titlebar-default" style="border-bottom: 10px; margin-bottom: 10px">
                    <h2 class="am-titlebar-title ">
                        选择分类&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    </h2>

                    <select id="doc-select-1" style="width: 200px;height: 36px;">

                        <c:forEach var="category" items="${categoryList}">
                            <c:choose>
                                <c:when test="${category.id==audio.categoryId}">
                                    <option value="${category.id}" selected="selected">${category.categoryName}</option>
                                </c:when>

                                <c:otherwise>
                                    <option value="${category.id}">${category.categoryName}</option>
                                </c:otherwise>
                            </c:choose>

                        </c:forEach>
                    </select>
                </div>

                <div class="am-input-group am-input-group-primary" style="margin-top: 20px;margin-bottom: 20px">
                    <span class="am-input-group-label"><i class="am-icon-user am-icon-fw"></i></span>
                    <input id="audioName" type="text" class="am-form-field" value="${audio.audioName}">
                </div>

                <div class="am-form-group am-form-file">
                    <i class="am-icon-cloud-upload"></i> 选择音频封面图
                    <input id="file" type="file" accept="image/jpg, image/jpeg, image/gif, image/png" multiple>
                </div>
                <div class="am-form-group">
                    <label for="audio">上传的音频文件</label>
                    <input type="file" id="audio">
                    <p class="am-form-help">请选择要上传的文件...</p>
                </div>

                <h3 class="blog-comment">描述</h3>
                <fieldset>
                    <div class="am-form-group">
                        <textarea id="audioDescribe" style="width: 100%;" rows="6">${audio.audioDescribe}</textarea>
                    </div>
                </fieldset>
            </div>

        </div>
    </div>

        <div class="star am-container mcenter">
            <span><button id="save" type="button"  class="am-btn am-btn-primary am-radius" style="width: 150px">提交</button></span>
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
<script type="text/javascript" src="${baseUrl}assets/js/wangEditor.min.js"></script>
<script type="text/javascript">





    document.getElementById('save').addEventListener('click', function () {
        // 读取 text
        var audioId=$("#audioId").val();
        var type=$("#doc-select-1 option:selected").val();
        var audioName=$("#audioName").val();
        var audioDescribe=$("#audioDescribe").val();
        var formData = new FormData();
        formData.append('audioId',audioId);
        formData.append('photo', $('#file')[0].files[0]);
        formData.append('type', type);
        formData.append('audio', $('#audio')[0].files[0]);
        formData.append("audioName",audioName);
        formData.append('audioDescribe', audioDescribe);

        if(type!="0"){
            if (audioName!=""&& audioDescribe!=""){

                $.ajax({
                    type: "POST",
                    url:"updateAudio",
                    data:formData,
                    contentType: false,
                    processData: false,
                    success: function(data) {
                        if(data==1){
                            alert("提交成功");

                            //js跳转页面
                            location.href="${baseUrl}audioPage";
                        }
                    }
                });

            }else {
                alert("标题和内容不能为空！！！")
            }


        }else{

            alert("没有选择分类！！！")
        }
    }, false)





</script>

</body>
</html>
