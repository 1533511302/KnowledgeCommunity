<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2018/11/23
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="baseUrl" value="${pageContext.request.contextPath}/"></c:set>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title>知识社区后台管理系统 - 主页</title>


    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->

    <link rel="shortcut icon" href="favicon.ico"> <link href="${baseUrl}admin/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${baseUrl}admin/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">

    <!-- Sweet Alert -->
    <link href="${baseUrl}admin/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">

    <link href="${baseUrl}admin/css/animate.css" rel="stylesheet">
    <link href="${baseUrl}admin/css/style.css?v=4.1.0" rel="stylesheet">
</head>

<body class="fixed-sidebar full-height-layout .skin-3" style="overflow:hidden">
<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close"><i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <span><img alt="image" class="img-circle" src="${baseUrl}admin/img/profile_small.jpg" /></span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                               <span class="block m-t-xs"><strong class="font-bold" id="admin">Maniy</strong></span>
                                <span class="text-muted text-xs block">系统管理员<b class="caret"></b></span>
                                </span>
                        </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
                            <li><a class="J_menuItem"  id="adminId"></a>
                            </li>

                            <li><a class="J_menuItem" id="adminEmail">信箱</a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="logout">安全退出</a>
                            </li>
                        </ul>
                    </div>
                    <div class="logo-element">R
                    </div>
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa-home"></i>
                        <span class="nav-label">主页</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="index_v1" data-index="0">我的主页</a>
                        </li>


                    </ul>

                </li>

                <li>
                    <a href="#">
                        <i class="fa fa fa-bar-chart-o"></i>
                        <span class="nav-label">目录管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="admin/categoryList">图文音频目录</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="admin/topicList">话题目录</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-user"></i> <span class="nav-label">用户管理</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="admin/userCount">用户统计</a>
                        </li>
                        <li><a class="J_menuItem" href="admin/userList">用户管理</a>
                        </li>


                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-edit"></i> <span class="nav-label">标签管理</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="admin/labelCount">标签统计</a>
                        </li>

                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-edit"></i> <span class="nav-label">图文管理</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="acceptCount">图文统计</a>
                        </li>
                        <li><a class="J_menuItem" href="admin/massageList">图文管理</a>
                        </li>

                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-edit"></i> <span class="nav-label">音频管理</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="companyCount">音频统计</a>
                        </li>
                        <li><a class="J_menuItem" href="admin/audioList">音频管理</a>
                        </li>


                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-table"></i> <span class="nav-label">问题管理</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="jobCount">问题统计</a>
                        </li>
                        <li><a class="J_menuItem" href="admin/questionList">问题管理</a>
                        </li>



                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-table"></i> <span class="nav-label">回答管理</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="jobHunterCount">回答统计</a>
                        </li>
                        <li><a class="J_menuItem" href="jobHunterList">回答管理</a>
                        </li>

                    </ul>
                </li>


                <li>
                    <a href="#"><i class="fa fa-table"></i> <span class="nav-label">评论管理</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="jobHunterCount">评论统计</a>
                        </li>
                        <li><a class="J_menuItem" href="jobHunterList">评论管理</a>
                        </li>

                    </ul>
                </li>


                <li>
                    <a href="#"><i class="fa fa-edit"></i> <span class="nav-label">用户充值</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="resumeCount">知识点充值</a>
                        </li>
                        <li><a class="J_menuItem" href="resumeList">其他</a>
                        </li>

                    </ul>
                </li>

            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
                    <form role="search" class="navbar-form-custom" method="post" action="search_results.html">
                        <div class="form-group">
                            <input type="text" placeholder="系统全局搜索" class="form-control" name="top-search" id="top-search">
                        </div>
                    </form>
                </div>
                <ul class="nav navbar-top-links navbar-right">



                    <li class="dropdown hidden-xs">
                        <a class="right-sidebar-toggle" aria-expanded="false">
                            <i class="fa fa-tasks"></i> 主题
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="row content-tabs">
            <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
            </button>
            <nav class="page-tabs J_menuTabs">
                <div class="page-tabs-content">
                    <a href="javascript:;" class="active J_menuTab" data-id="recruit/index_v1">首页</a>
                </div>
            </nav>
            <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
            </button>
            <div class="btn-group roll-nav roll-right">
                <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>

                </button>
                <ul role="menu" class="dropdown-menu dropdown-menu-right">
                    <li class="J_tabShowActive"><a>定位当前选项卡</a>
                    </li>
                    <li class="divider"></li>
                    <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                    </li>
                </ul>
            </div>
            <a href="logout" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
        </div>
        <div class="row J_mainContent" id="content-main">
            <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="index_v1" frameborder="0" data-id="index_v1" seamless></iframe>
        </div>
        <div class="footer">
            <div class="pull-right">&copy; 2018-2019 <a href="#" target="_blank">renwen</a>
            </div>
        </div>
    </div>
    <!--右侧部分结束-->
    <!--右侧边栏开始-->
    <div id="right-sidebar">
        <div class="sidebar-container">

            <ul class="nav nav-tabs navs-3">

                <li class="active">
                    <a data-toggle="tab" href="#tab-1">
                        <i class="fa fa-gear"></i> 主题
                    </a>
                </li>

            </ul>

            <div class="tab-content">
                <div id="tab-1" class="tab-pane active">
                    <div class="sidebar-title">
                        <h3> <i class="fa fa-comments-o"></i> 主题设置</h3>
                        <small><i class="fa fa-tim"></i> 你可以从这里选择和预览主题的布局和样式，这些设置会被保存在本地，下次打开的时候会直接应用这些设置。</small>
                    </div>
                    <div class="skin-setttings">
                        <div class="title">主题设置</div>
                        <div class="setings-item">
                            <span>收起左侧菜单</span>
                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="collapsemenu">
                                    <label class="onoffswitch-label" for="collapsemenu">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="setings-item">
                            <span>固定顶部</span>

                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="fixednavbar" class="onoffswitch-checkbox" id="fixednavbar">
                                    <label class="onoffswitch-label" for="fixednavbar">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="setings-item">
                                <span>
                        固定宽度
                    </span>
                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="boxedlayout" class="onoffswitch-checkbox" id="boxedlayout">
                                    <label class="onoffswitch-label" for="boxedlayout">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="title">皮肤选择</div>
                        <div class="setings-item default-skin nb">
                                <span class="skin-name ">
                         <a href="#" class="s-skin-0">
                             默认皮肤
                         </a>
                    </span>
                        </div>
                        <div class="setings-item blue-skin nb">
                                <span class="skin-name ">
                        <a href="#" class="s-skin-1">
                            蓝色主题
                        </a>
                    </span>
                        </div>
                        <div class="setings-item yellow-skin nb">
                                <span class="skin-name ">
                        <a href="#" class="s-skin-3">
                            黄色/紫色主题
                        </a>
                    </span>
                        </div>
                    </div>
                </div>

            </div>

        </div>
    </div>
    <!--右侧边栏结束-->
    <!--mini聊天窗口开始-->
    <div class="small-chat-box fadeInRight animated">

        <div class="heading" draggable="true">
            <small class="chat-date pull-right">
                2018.8
            </small>   聊天中
        </div>

        <div class="content" id="content">



        </div>
        <div class="form-chat">
            <div class="input-group input-group-sm">
                <input type="text" class="form-control" id="chatContent"> <span class="input-group-btn"> <button
                    class="btn btn-primary" type="button" id="sendChat">发送
                </button> </span>
            </div>
        </div>

    </div>
    <div id="small-chat">
        <!--<span class="badge badge-warning pull-right">5</span>-->
        <a class="open-small-chat">
            <i class="fa fa-comments"></i>

        </a>
    </div>
    <!--mini聊天窗口结束-->
</div>
<#--弹窗-->
<div class="modal fade" id="mymodal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">
                    提醒
                </h4>
            </div>
            <div class="modal-body">
                用户提交了新的求职申请
            </div>
            <div class="modal-footer">
                <button onclick="javascript:document.getElementById('notice').pause();"  type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" onclick="location.reload()" class="btn btn-primary">刷新查看申请</button>
            </div>
        </div>

    </div>

</div>
<#--播放音乐-->
<audio id="notice" >

    <source src="mp3/song.mp3" type="audio/mpeg" />
</audio>
<#--播放音乐-->
<audio id="chatMusic" >

    <source src="mp3/didididi.mp3" type="audio/mpeg" />
</audio>
<!-- 全局js -->
<script src="${baseUrl}admin/js/jquery.min.js?v=2.1.4"></script>
<script src="${baseUrl}admin/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${baseUrl}admin/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${baseUrl}admin/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${baseUrl}admin/js/plugins/layer/layer.min.js"></script>

<!-- 自定义js -->
<script src="${baseUrl}admin/js/hplus.js?v=4.1.0"></script>
<script type="text/javascript" src="${baseUrl}admin/js/contabs.js"></script>

<!-- 第三方插件 -->
<%--<script src="${baseUrl}admin/js/plugins/pace/pace.min.js"></script>--%>

<!-- Sweet alert -->
<script src="${baseUrl}admin/js/plugins/sweetalert/sweetalert.min.js"></script>
<%--<script>--%>
<%--var websocket =null;--%>
<%--if('WebSocket' in window){--%>
<%--websocket =new WebSocket('ws://localhost:8089/recruit/webSocket')--%>
<%--}else {--%>
<%--alert("该浏览器不支持webSocket!")--%>
<%--}--%>
<%--websocket.onopen =function (event) {--%>
<%--console.log('建立连接')--%>

<%--}--%>
<%--websocket.onclose=function (event) {--%>
<%--console.log('连接关闭')--%>

<%--}--%>
<%--websocket.onmessage = function (event) {--%>
<%--console.log('收到消息:'+event.data)--%>

<%--var webTxt =event.data;--%>
<%--var arr=webTxt.split("|")--%>
<%--if(event.data=="acceptSave"){--%>
<%--//弹窗提醒,播放音乐--%>
<%--$('#mymodal').modal('show');--%>
<%--document.getElementById('notice').play();--%>
<%--}else if(arr[1]!=undefined){--%>



<%--document.getElementById('chatMusic').play();--%>
<%--var textSmall=document.createTextNode(new Date().getHours()+" 时 "+new Date().getMinutes()+" 分 "+new Date().getSeconds()+" 秒");--%>
<%--var textName =document.createTextNode(arr[0]+"    ");--%>
<%--var textMessage=document.createTextNode(arr[1]);--%>


<%--var small=document.createElement("small");--%>
<%--small.classList.add("chat-date");--%>
<%--small.appendChild(textSmall);--%>


<%--var name=document.createElement("div");--%>
<%--name.classList.add("author-name");--%>
<%--name.appendChild(textName);--%>
<%--name.appendChild(small);--%>

<%--var message=document.createElement("div");--%>
<%--message.classList.add("chat-message");--%>
<%--message.appendChild(textMessage);--%>


<%--var left=document.createElement("div");--%>
<%--left.classList.add("left");--%>
<%--left.appendChild(name);--%>
<%--left.appendChild(message);--%>


<%--var div=document.getElementById("content");--%>
<%--div.appendChild(left);--%>

<%--}else{--%>
<%--// var txt=document.getElementById("chatContent").value;--%>
<%--//--%>
<%--// var textSmall=document.createTextNode("22:22");--%>
<%--// var textName =document.createTextNode("管理员  ");--%>
<%--// var textMessage=document.createTextNode(txt);--%>
<%--//--%>
<%--//--%>
<%--// var small=document.createElement("small");--%>
<%--// small.classList.add("chat-date");--%>
<%--// small.appendChild(textSmall);--%>
<%--//--%>
<%--//--%>
<%--// var name=document.createElement("div");--%>
<%--// name.classList.add("author-name");--%>
<%--// name.appendChild(textName);--%>
<%--// name.appendChild(small);--%>
<%--//--%>
<%--// var message=document.createElement("div");--%>
<%--// message.classList.add("chat-message");--%>
<%--// message.classList.add("active");--%>
<%--// message.appendChild(textMessage);--%>
<%--//--%>
<%--//--%>
<%--// var right=document.createElement("div");--%>
<%--// right.classList.add("right");--%>
<%--// right.appendChild(name);--%>
<%--// right.appendChild(message);--%>
<%--//--%>
<%--//--%>
<%--// var div=document.getElementById("content");--%>
<%--// div.appendChild(right);--%>
<%--}--%>


<%--}--%>
<%--document.getElementById("sendChat").onclick= function () {--%>
<%--var txt=document.getElementById("chatContent").value;--%>
<%--document.getElementById("chatContent").value="";--%>
<%--websocket.send(txt);--%>
<%--var textSmall=document.createTextNode(new Date().getHours()+" 时 "+new Date().getMinutes()+" 分 "+new Date().getSeconds()+" 秒");--%>
<%--var textName =document.createTextNode("管理员    ");--%>
<%--var textMessage=document.createTextNode(txt);--%>


<%--var small=document.createElement("small");--%>
<%--small.classList.add("chat-date");--%>
<%--small.appendChild(textSmall);--%>


<%--var name=document.createElement("div");--%>
<%--name.classList.add("author-name");--%>
<%--name.appendChild(textName);--%>
<%--name.appendChild(small);--%>

<%--var message=document.createElement("div");--%>
<%--message.classList.add("chat-message");--%>
<%--message.classList.add("active");--%>
<%--message.appendChild(textMessage);--%>


<%--var right=document.createElement("div");--%>
<%--right.classList.add("right");--%>
<%--right.appendChild(name);--%>
<%--right.appendChild(message);--%>


<%--var div=document.getElementById("content");--%>
<%--div.appendChild(right);--%>
<%--}--%>
<%--websocket.onerror =function(){--%>
<%--alert('webSocket通信发生错误!')--%>
<%--}--%>
<%--window.onbeforeunload =function () {--%>
<%--websocket.close();--%>
<%--}--%>

<%--</script>--%>
<script>
    $(document).ready(function () {

        // Examle data for jqGrid
        $.ajax({
            type: 'GET',
            url: "http://localhost:8089/recruit/ajax/admin",
            data: {},
            // dataType: "json",
            success: function (data) {
                console.log(data);
                var mydata = data;
                var admin=document.getElementById("admin");
                var adminId =document.getElementById("adminId");
                var adminEmail=document.getElementById("adminEmail");
                adminId.textContent="编号："+mydata.adminId;
                adminEmail.textContent=mydata.adminEmail;
                admin.textContent=mydata.adminEmail;

            }
        });
    });
</script>

</body>

</html>
