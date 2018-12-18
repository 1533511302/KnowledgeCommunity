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
<div class="star am-container mcenter"><span>编写我的知识图文</span></div>
<div>

    <div class="am-container" style="margin-top: 10px">
        <div class="am-panel am-panel-success">
            <div class="am-panel-hd">编辑器</div>
            <div class="am-panel-bd" style="padding: 1rem;padding-bottom: 0.2rem">
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
                    <input id="title" type="text" class="am-form-field" placeholder="文章标题">
                </div>

                <div class="am-form-group am-form-file">
                    <i class="am-icon-cloud-upload"></i> 选择图文封面图(非必选项)
                    <input id="file" type="file" multiple>
                </div>
                <input type="hidden" name="content">
                <div id="editor">
                    <p>文章内容编辑区域</p>
                </div>
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

    $.get("categorise/1",null,function (data) {
        $.each(data,function (i,category) {
            $("#doc-select-1").append("<option value='"+category.id+"'>"+category.categoryName+"</option>")
        });
    });

    var E = window.wangEditor
    var editor = new E('#editor')
    editor.customConfig.uploadImgServer = 'uploadMassagePhoto'  // 上传图片到服务器

    //配置属性名称，绑定请求的图片数据
    //controller会用到，可以随便设置，但是一定要与controller一致
    editor.customConfig.uploadFileName = 'photo';

    editor.customConfig.uploadImgHooks = {
        before: function (xhr, editor, files) {
            // 图片上传之前触发
            // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，files 是选择的图片文件

            // 如果返回的结果是 {prevent: true, msg: 'xxxx'} 则表示用户放弃上传
            // return {
            //     prevent: true,
            //     msg: '放弃上传'
            // }
        },
        success: function (xhr, editor, result) {
            console.log(result);
            // 图片上传并返回结果，图片插入成功之后触发
            // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，result 是服务器端返回的结果
        },
        fail: function (xhr, editor, result) {
            console.log(result);
            // 图片上传并返回结果，但图片插入错误时触发
            // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，result 是服务器端返回的结果
        },
        error: function (xhr, editor) {
            console.log(result);
            // 图片上传出错时触发
            // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象
        },
        timeout: function (xhr, editor) {
            // 图片上传超时时触发
            // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象
        },

        // 如果服务器端返回的不是 {errno:0, data: [...]} 这种格式，可使用该配置
        // （但是，服务器端返回的必须是一个 JSON 格式字符串！！！否则会报错）
        customInsert: function (insertImg, result, editor) {
            // 图片上传并返回结果，自定义插入图片的事件（而不是编辑器自动插入图片！！！）
            // insertImg 是插入图片的函数，editor 是编辑器对象，result 是服务器端返回的结果

            // 举例：假如上传图片成功后，服务器端返回的是 {url:'....'} 这种格式，即可这样插入图片：
            insertImg(result.data)

            // result 必须是一个 JSON 格式字符串！！！否则报错
        }

    }



    // 或者 var editor = new E( document.getElementById('editor') )
    //插入网络图片的回调
    editor.customConfig.linkImgCallback = function (url) {
        console.log(url) // url 即插入图片的地址
    };
    //插入链接的校验
    editor.customConfig.linkCheck = function (text, link) {
        console.log(text) // 插入的文字
        console.log(link) // 插入的链接

        return true // 返回 true 表示校验成功
        // return '验证失败' // 返回字符串，即校验失败的提示信息
    };
    //插入网络图片的校验
    editor.customConfig.linkImgCheck = function (src) {
        console.log(src) // 图片的链接

        return true // 返回 true 表示校验成功
        // return '验证失败' // 返回字符串，即校验失败的提示信息
    };
    editor.create();










    document.getElementById('save').addEventListener('click', function () {
        // 读取 text
        var type=$("#doc-select-1 option:selected").val();
        var title=$("#title").val();
        var photo=$('#file')[0].files[0];
        var content=editor.txt.html();
        var formData = new FormData();
        formData.append('photo', $('#file')[0].files[0]);
        formData.append('type', type);
        formData.append('content', content);
        formData.append('title', title);
        console.log(photo);
        console.log(type);
        console.log(title);
        console.log(content);
        if(type!="0"){
            if (title!="" && content!=""){
                // $.post("massages",{photo:photo,type:type,title:title,content:content},function (data) {
                //     if(data==1){
                //         alert("提交成功");
                //     }
                // });
                // $.post("massages",formData,function (data) {
                //     if(data==1){
                //         alert("提交成功");
                //     }
                // });
                $.ajax({
                    type: "POST",
                    url:"massages",
                    data:formData,
                    contentType: false,
                    processData: false,
                    success: function(data) {
                        if(data==1){
                            alert("提交成功");
                            //js跳转页面
                            location.href="${baseUrl}massagePage";
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
