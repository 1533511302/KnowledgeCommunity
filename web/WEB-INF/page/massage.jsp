<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2018/10/20
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
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
    <link rel="icon" sizes="192x192" href="<%=basePath%>images/i/app.png">
    <!--Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="apple-touch-icon-precomposed" href="<%=basePath%>images/i/app.png">
    <!--Win8 or 10 -->
    <meta name="msapplication-TileImage" content="<%=basePath%>images/i/app.png">
    <meta name="msapplication-TileColor" content="#e1652f">

    <link rel="icon" type="image/png" href="<%=basePath%>images/i/favicon.png">
    <link rel="stylesheet" href="<%=basePath%>assets/css/amazeui.min.css">
    <link rel="stylesheet" href="<%=basePath%>css/public.css">

    <!--[if (gte IE 9)|!(IE)]><!-->
    <script src="<%=basePath%>assets/js/jquery.min.js"></script>
    <!--<![endif]-->
    <!--[if lte IE 8 ]>
    <script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
    <script src="<%=basePath%>assets/js/amazeui.ie8polyfill.min.js"></script>
    <![endif]-->
    <script src="<%=basePath%>assets/js/amazeui.min.js"></script>
    <script src="<%=basePath%>js/public.js"></script>

</head>
<body>

<header class="am-topbar am-topbar-fixed-top wos-header">
    <div class="am-container">
        <h1 class="am-topbar-brand">
            <a href="#"><img src="<%=basePath%>images/logo.png" alt=""></a>
        </h1>

        <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-warning am-show-sm-only"
                data-am-collapse="{target: '#collapse-head'}">
            <span class="am-sr-only">导航切换</span>
            <span class="am-icon-bars"></span>
        </button>

        <div class="am-collapse am-topbar-collapse" id="collapse-head">
            <ul class="am-nav am-nav-pills am-topbar-nav">
                <li><a href="<%=basePath%>toIndex">首页</a></li>
                <li class="am-active"><a href="<%=basePath%>massagePage">图文</a></li>
                <li><a href="#">音频</a></li>
                <li><a href="<%=basePath%>topics/1">问答</a></li>
                <li><a href="<%=basePath%>vUsers/1">大咖秀</a></li>
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

            <form action="<%=basePath%>massages/likeName" class="am-topbar-form am-topbar-left am-form-inline" role="search">
                <div class="am-form-group" style="margin-top: 9px;margin-left: 100px">
                    <input name="title" type="text" class="am-form-field am-input-sm" placeholder="搜索内容" value="${title}">
                </div>
                <div class="am-topbar-right">
                    <button type="submit" class="am-btn am-btn-primary am-topbar-btn am-btn-sm">搜索</button>
                </div>
            </form>

            <div class="am-topbar-right" style="margin-top: 9px">
                <button class="am-btn am-btn-default am-topbar-btn am-btn-sm"><span class="am-icon-pencil"></span>注册</button>
            </div>

            <div class="am-topbar-right" style="margin-top: 9px">
                <button class="am-btn am-btn-danger am-topbar-btn am-btn-sm"><span class="am-icon-user"></span> 登录</button>
            </div>
        </div>
    </div>
</header>


<div class="am-g am-container">
    <div class="am-u-sm-12 am-u-md-12 am-u-lg-8">
        <div class="newstitles">
            <h2>${massage.title}</h2>
            <img src="<%=basePath%>Temp-images/face.jpg" class="face">
            <span>${massage.username}</span>
            时间：${massage.createTime}   阅读：${massage.browseNumb}
        </div>
        <a href="#"><img src="<%=basePath%>Temp-images/ad2.png" class="am-img-responsive" width="100%"/></a>

        <div class="contents">
            <p dir="ltr"><span style="color: rgb(88, 88, 88); font-family: arial, &#39;microsoft yahei&#39;, 宋体; line-height: 28px; text-align: justify; font-size: 16px; background-color: rgb(255, 255, 255);">&nbsp; &nbsp; &nbsp; &nbsp;最近研究servlet，看书时候书里讲到了c/s架构到b/s架构的演变，讲servlet的书都很老了，现在的b/s架构已经不是几年前的b/s架构，其实b/s架构就是web应用开发，对于这样的架构我们现在应该考虑的是前端和后端的分离（注意：这里的后端是指服务端）。</span></p><p dir="ltr"><span style="color: rgb(88, 88, 88); font-family: arial, &#39;microsoft yahei&#39;, 宋体; line-height: 28px; text-align: justify; font-size: 16px; background-color: rgb(255, 255, 255);">&nbsp; &nbsp; &nbsp; &nbsp;Web前端现在是一个独立的技术工种，这个工种的产生主要是针对互联网行业的需求，我在以前的文章里曾经讲到过，一个大型互联网网站，例如想淘宝网，它绝对不是一个Web项目，而是一群web项目的集合，那么如果不在前端进行整合，这么多web项目前端开发一定存在大量重复劳动，并且运维时候也存在难以统一管理的问题。本文假想一个面对需要前端资源整合的组织，如何做到前后端分离的解决思路。本文详情如下：</span></p><p dir="ltr"><span style="color: rgb(88, 88, 88); font-family: arial, &#39;microsoft yahei&#39;, 宋体; line-height: 28px; text-align: justify; font-size: 16px; background-color: rgb(255, 255, 255);"><br/></span></p><p dir="ltr"><strong><span style="color: rgb(88, 88, 88); font-family: arial, &#39;microsoft yahei&#39;, 宋体; line-height: 28px; text-align: justify; font-size: 16px; background-color: rgb(255, 255, 255);">(一) 前后端分离的目的和作用</span></strong></p><p dir="ltr"><span style="color: rgb(88, 88, 88); font-family: arial, &#39;microsoft yahei&#39;, 宋体; line-height: 28px; text-align: justify; font-size: 16px; background-color: rgb(255, 255, 255);">&nbsp; &nbsp; &nbsp; &nbsp;做Web开发也可以说是B/S架构开发，B端和S端从技术体系角度而言异构性很大，换而言之就是B端使用的技术和S端使用的技术不适于同一个体系，这样的结果导致实际开发中，很难做到专业分工，如果项目开发过程中管控不到位，这样的问题可能会影响到整个项目的开发质量，因此前后端分离的目的之一就是要做到专业化分工，提高项目的质量和开发效率。</span></p><p dir="ltr"><span style="color: rgb(88, 88, 88); font-family: arial, &#39;microsoft yahei&#39;, 宋体; line-height: 28px; text-align: justify; font-size: 16px; background-color: rgb(255, 255, 255);">&nbsp; &nbsp; &nbsp; &nbsp;随着技术的发展，当下的Web开发形势已经和以前有了很大的不同，早期的Web项目是一个封闭的项目，用户从浏览器里看到的页面直到后台数据库都是在一个项目里集成的，而现在Web系统的规模越来越大，中大型的Web系统是一个开放式的系统，开放型的系统用户在浏览器发起的请求可能会转发到外部的系统里进行处理，或者是本地的系统和外部系统一起完成请求的处理，此外有的请求可能不会直接请求数据库，而是请求缓存服务器，这些变化几乎都是发生在Web系统的服务端，前后端耦合度很高的Web系统服务端的复杂度提升必然带来了Web前端的复杂度的提升。因此Web前端从系统架构的角度也需要更加专业的管控，管控的作用之一就是前后端进行分离，降低前端对服务端的依耐性。</span></p><p dir="ltr"><span style="color: rgb(88, 88, 88); font-family: arial, &#39;microsoft yahei&#39;, 宋体; line-height: 28px; text-align: justify; font-size: 16px; background-color: rgb(255, 255, 255);">&nbsp; &nbsp; &nbsp; &nbsp;富客户端应用的普及导致Web前端技术开发更加专业化，Web前端工程师成为一个独立的技术岗位，Web前端开发技术的难度也越来越高，前后端的分离就是为Web前端开发营造一个良好的开发环境，不要让前端工程师被一些不可控的外在因素所影响（例如：前后端的耦合性），最后导致前端不能专心致志做出更加好的作品。所以，前后端分离是让前后端更加专业化，在技术和管理上将前端角色更加明确，更深入的挖掘前端开发的价值。</span></p><p dir="ltr"><span style="color: rgb(88, 88, 88); font-family: arial, &#39;microsoft yahei&#39;, 宋体; line-height: 28px; text-align: justify; font-size: 16px; background-color: rgb(255, 255, 255);"><br/></span></p><p dir="ltr"><strong><span style="color: rgb(88, 88, 88); font-family: arial, &#39;microsoft yahei&#39;, 宋体; line-height: 28px; text-align: justify; font-size: 16px; background-color: rgb(255, 255, 255);">(二) 现有系统架构给前后端带来的问题以及解决方法</span></strong></p><p dir="ltr" style="text-align: center;"><span style="color: rgb(88, 88, 88); font-family: arial, &#39;microsoft yahei&#39;, 宋体; line-height: 28px; text-align: justify; font-size: 16px; background-color: rgb(255, 255, 255);"></span></p><p dir="ltr"><span style="color: rgb(88, 88, 88); font-family: arial, &#39;microsoft yahei&#39;, 宋体; line-height: 28px; text-align: justify; font-size: 16px; background-color: rgb(255, 255, 255);">&nbsp; &nbsp; &nbsp; &nbsp;上图是目前大部分系统的架构图，虽然有些系统采用分布式架构，层与层之间使用了远程调用框架，但是本质上都逃不开上面这个架构设计。这张图是一张比较合理的图，在实际开发里最常发生的事情就是控制层（Control）越过服务层（Service）直接处理下面的资源。</span></p><p dir="ltr"><span style="color: rgb(88, 88, 88); font-family: arial, &#39;microsoft yahei&#39;, 宋体; line-height: 28px; text-align: justify; font-size: 16px; background-color: rgb(255, 255, 255);">&nbsp; &nbsp; &nbsp; &nbsp; 前后端耦合的问题主要发生在控制层（Control），控制层是前端和服务端交互的边界，但是在开发过程中控制层（Control）和服务层（Service）常常混淆不清，这就是前后端耦合度高的重要原因。</span></p><p dir="ltr"><span style="color: rgb(88, 88, 88); font-family: arial, &#39;microsoft yahei&#39;, 宋体; line-height: 28px; text-align: justify; font-size: 16px; background-color: rgb(255, 255, 255);">&nbsp; &nbsp; &nbsp; &nbsp; 因此要前后端解耦，就是要划清控制层的边界，控制层到底该属于前端还是服务端，在MVC模式里控制层作用是调度，控制层不是写业务逻辑的地方，因此将大量业务逻辑写到控制层其实是违背了MVC模式的思想，同时控制层是前端和服务端通讯的桥梁，其实控制层是参入了前端的工作任务，既然控制层要剥离业务操作同时控制层也要参入前端应用的开发，那么将控制层归为前端的一部分是完全合情合理合规的。</span></p><p dir="ltr"><span style="color: rgb(88, 88, 88); font-family: arial, &#39;microsoft yahei&#39;, 宋体; line-height: 28px; text-align: justify; font-size: 16px; background-color: rgb(255, 255, 255);">&nbsp; &nbsp; &nbsp; &nbsp;把控制层剥离了业务逻辑处理可能会让人不知道如何开发了，我觉得有这种想法的人是开发时候没有理解透MVC模式思想，编程随意性大养成了坏习惯，这个就需要这些人一点点去适应技术新趋势的发展。</span></p><p dir="ltr"><span style="color: rgb(88, 88, 88); font-family: arial, &#39;microsoft yahei&#39;, 宋体; line-height: 28px; text-align: justify; font-size: 16px; background-color: rgb(255, 255, 255);">&nbsp; &nbsp; &nbsp; &nbsp;前后端分离的终极目标应该是前端和服务端是完全独立的项目，前端项目包含上图里的浏览器和控制层，服务端项目包括服务层、DAO层等等，前端项目和服务端项目以高效的远程调用框架做通讯介质，项目开发时候前端项目做前端的事情，服务项目做服务端的事情，这样就让服务端开发的人员没有机会在控制层乱写代码了，保证了Web前端环境的纯粹性，最后生产发布也要独立部署，这样就达到了前后端真正解耦，但是前后端的沟通机制也是不可或缺的，我觉得它们之间的沟通使用高性能的远程调用框架，前后端相互约定通讯报文格式。.</span></p><p dir="ltr"><span style="color: rgb(88, 88, 88); font-family: arial, &#39;microsoft yahei&#39;, 宋体; line-height: 28px; text-align: justify; font-size: 16px; background-color: rgb(255, 255, 255);">&nbsp; &nbsp; &nbsp; &nbsp;其实不管服务端还是前端宏观流程无非是输入数据à数据处理à输出数据，但是服务端要把心思花在数据处理上，前端要更多关心的是输入输出数据时候的用户体验操作，服务端开发最大的问题就是违背MVC原则，代码编写的随意性，而前端不管出于安全还是性能考虑，最好是尽量少牵涉业务。前端和后端通讯层的独立，会将前后端进行真正的解耦，前面我讲到前后真正问题就是前端和后端技术路线不一致，但是传统Web开发里前后端又要融为一体，这就导致前后端很难做到专业化分工，对于前端应该尽量弱化通讯级别的开发工作，前端通讯编程只要知道调用哪个接口，传什么参数，怎么处理响应信息就行了。这样就能让前端和后端实现真正的专业化。</span></p><p dir="ltr"><span style="color: rgb(88, 88, 88); font-family: arial, &#39;microsoft yahei&#39;, 宋体; line-height: 28px; text-align: justify; font-size: 16px; background-color: rgb(255, 255, 255);">&nbsp; &nbsp; &nbsp; &nbsp;做到了这些，就不会发生开发时候前后端边界不清的问题了。</span></p><p dir="ltr"><span style="color: rgb(88, 88, 88); font-family: arial, &#39;microsoft yahei&#39;, 宋体; line-height: 28px; text-align: justify; font-size: 16px; background-color: rgb(255, 255, 255);"><br/></span></p><p dir="ltr"><strong><span style="color: rgb(88, 88, 88); font-family: arial, &#39;microsoft yahei&#39;, 宋体; line-height: 28px; text-align: justify; font-size: 16px; background-color: rgb(255, 255, 255);">(三) 前后端分离的一些想法</span></strong></p><p dir="ltr"><span style="color: rgb(88, 88, 88); font-family: arial, &#39;microsoft yahei&#39;, 宋体; line-height: 28px; text-align: justify; font-size: 16px; background-color: rgb(255, 255, 255);">&nbsp; &nbsp; &nbsp; &nbsp;本文主题应该是前后端分离，我上面的建议是个彻底方案，要革以前系统的命，对存量系统那该如何处理，答案还是重构代码，想方设法逐步减少已经发现的前后端耦合度高的问题，这个跟我之前的建议就是小重构和大重构的区别，如果有人觉得我上面建议合适，前端组应该马上提供一套这样的框架出来，这样后面的新系统就不会在循环前面的错误了。我觉得搭建这样的框架不会太复杂的。</span></p><p dir="ltr"><span style="color: rgb(88, 88, 88); font-family: arial, &#39;microsoft yahei&#39;, 宋体; line-height: 28px; text-align: justify; font-size: 16px; background-color: rgb(255, 255, 255);">&nbsp; &nbsp; &nbsp; &nbsp;我上面的前后端分离的目的就是将前端资源整合为一个整体，理清前后端的边界，这些做完后，前端组里该如何提升自己的能力了？</span></p><p dir="ltr"><span style="color: rgb(88, 88, 88); font-family: arial, &#39;microsoft yahei&#39;, 宋体; line-height: 28px; text-align: justify; font-size: 16px; background-color: rgb(255, 255, 255);">&nbsp; &nbsp; &nbsp; 这时候要让前端的东西项目化，工程化，前端技术不能再当做开发者的玩具，它也是需要大量的系统架构，开发规范，自动化压缩混淆，自动化发布，前端监控和分析，前端优化等等。</span></p><p dir="ltr"><span style="color: rgb(88, 88, 88); font-family: arial, &#39;microsoft yahei&#39;, 宋体; line-height: 28px; text-align: justify; font-size: 16px; background-color: rgb(255, 255, 255);">&nbsp; &nbsp; &nbsp; &nbsp;上面这些问题都很重要，也很专业，如果我有机会能参入这样的事情，我还有个特别的建议，具体如下：</span></p><p dir="ltr"><span style="color: rgb(88, 88, 88); font-family: arial, &#39;microsoft yahei&#39;, 宋体; line-height: 28px; text-align: justify; font-size: 16px; background-color: rgb(255, 255, 255);">&nbsp; &nbsp; &nbsp; &nbsp; 在一个企业内部，Web前端的组件，不管这个组件是UI层级，还是javascript开发层级，都脱离不了该企业业务产品的模式，其实看看像网易，新浪这样的门户网站的前端应用组件，它们用于做门户很合适，但是用它来做企业应用软件可能就不是太好使用，因此对于组件要有一个清晰的认识，我觉得可以把组件按业务场景分类，这里我可以举个例子，如果这个企业有给门户使用的组件，而这个组件很适合门户，应该把它归为门户组件，如果某些组件适合做网站后台管理的，那么就列为后台管理组件，如果某些组件能跨多了业务场景则标记为通用组件。</span></p><p dir="ltr"><span style="color: rgb(88, 88, 88); font-family: arial, &#39;microsoft yahei&#39;, 宋体; line-height: 28px; text-align: justify; font-size: 16px; background-color: rgb(255, 255, 255);">&nbsp; &nbsp; &nbsp; &nbsp;做分类的原因是为了理清组件的应用边界，这样我们可以有针对性的积累和完善这些组件，有意识的开发相关的组件，最终形成一个针对某个业务组件的组件仓库，这样等新需求过来，Web前端的项目经理或Web前端的技术经理可以通过场景分析该需求需要使用那些现有的技术，需求里的那些场景是要进行开发，新场景里有没有新开发的代码能生成新的组件，这就可以做到有计划有次序的积累。</span></p><p dir="ltr"><span style="color: rgb(88, 88, 88); font-family: arial, &#39;microsoft yahei&#39;, 宋体; line-height: 28px; text-align: justify; font-size: 16px; background-color: rgb(255, 255, 255);">&nbsp; &nbsp; &nbsp; &nbsp;Web前端的核心人员应该花更多精力去设计、积累、整理各种组件，通过实际业务需求去完善和丰富这些组件，最终达到组件可以覆盖到全公司绝大多数场景，最终通过组件积累形成完善的Web前端开发规范，这样的规范覆盖面广更加易于操作，对于企业而言Web前端开发流程就可以做到标准化，从而达到简单培训一些技术能力不高的开发人员就能完成相关的开发任务，同时也让Web前端核心人员也能很好的把控项目的质量和进度。</span></p><p dir="ltr"><span style="color: rgb(88, 88, 88); font-family: arial, &#39;microsoft yahei&#39;, 宋体; line-height: 28px; text-align: justify; font-size: 16px; background-color: rgb(255, 255, 255);">&nbsp; &nbsp; &nbsp; &nbsp;以上就是我的一些前后端分离的想法，它是一个很宏观的想法，没有太多技术实现细节，如果这个想法如果针对存量系统，的确是一个颠覆性的方案，如果Web前端允许一切重头来做，我个人觉得这还是很好的一个思路。前后端分离是Web前端专业化的万里长征第一步，如果这一步做好，前端就有一套专属自己的优质环境，那时候Web前端就会有更大的余力做更优秀的工作，这就是我的愿景。</span></p><p dir="ltr"><span style="color: rgb(88, 88, 88); font-family: arial, &#39;microsoft yahei&#39;, 宋体; line-height: 28px; text-align: justify; font-size: 16px; background-color: rgb(255, 255, 255);"><br/></span></p><p dir="ltr"><span style="color: rgb(88, 88, 88); font-family: arial, &#39;microsoft yahei&#39;, 宋体; line-height: 28px; text-align: justify; font-size: 16px; background-color: rgb(255, 255, 255);">&nbsp; &nbsp; &nbsp; &nbsp;当然我的构想也许并不太正确，如果有大牛看了本人文章还请多多指教。</span></p><p dir="ltr"><span style="color: rgb(88, 88, 88); font-family: arial, &#39;microsoft yahei&#39;, 宋体; line-height: 28px; text-align: justify; font-size: 16px; background-color: rgb(255, 255, 255);"><br/></span></p><p dir="ltr"><span style="color: rgb(88, 88, 88); font-family: arial, &#39;microsoft yahei&#39;, 宋体; line-height: 28px; text-align: justify; font-size: 16px; background-color: rgb(255, 255, 255);"><br/></span></p><p dir="ltr"><span style="color: rgb(88, 88, 88); font-family: arial, &#39;microsoft yahei&#39;, 宋体; line-height: 28px; text-align: justify; font-size: 16px; background-color: rgb(255, 255, 255);">作者：夏天的森林</span></p><p dir="ltr" style="text-align: justify; "><font color="#585858" face="arial, microsoft yahei, 宋体"><span style="line-height: 28px; background-color: rgb(255, 255, 255);">原文链接：<a href="http://www.cnblogs.com/sharpxiajun/p/3531665.html" _src="http://www.cnblogs.com/sharpxiajun/p/3531665.html">http://www.cnblogs.com/sharpxiajun/p/3531665.html</a> </span></font></p><p dir="ltr" style="text-align: justify; "><font color="#585858" face="arial, microsoft yahei, 宋体"><br/></font></p><p dir="ltr" style="text-align: justify;"><font color="#585858" face="arial, microsoft yahei, 宋体">本文转自XXX</font></p>
        </div>
        <div class="shang">
            <img src="<%=basePath%>images/shang.png" >
        </div>
        <!--data-ds-short-name="amazeui" 多说的用户名-->
        <div data-am-widget="duoshuo" class="am-duoshuo am-duoshuo-default" data-ds-short-name="amazeui">
            <div class="ds-thread" >
            </div>
        </div>
    </div>
    <div class="am-u-sm-0 am-u-md-0 am-u-lg-4">
        <div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
            <h2 class="am-titlebar-title ">
                个人专栏
            </h2>
            <nav class="am-titlebar-nav">
                <a href="#more">more &raquo;</a>
            </nav>
        </div>

        <div data-am-widget="list_news" class="am-list-news am-list-news-default right-bg">
            <ul class="am-list"  >
                <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
                    <div class="am-u-sm-4 am-list-thumb">
                        <a href="http://www.douban.com/online/11624755/">
                            <img src="<%=basePath%>Temp-images/face.jpg" class="face"/>
                        </a>
                    </div>

                    <div class=" am-u-sm-8 am-list-main">
                        <h3 class="am-list-item-hd"><a href="http://www.douban.com/online/11624755/">勾三古寺</a></h3>

                        <div class="am-list-item-text">代码压缩和最小化。在这里，我们为你收集了9个最好的JavaScript压缩工具将帮</div>
                    </div>
                </li>
                <hr data-am-widget="divider" style="" class="am-divider am-divider-default" />
                <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
                    <div class="am-u-sm-4 am-list-thumb">
                        <a href="http://www.douban.com/online/11624755/">
                            <img src="<%=basePath%>Temp-images/face.jpg" class="face"/>
                        </a>
                    </div>

                    <div class=" am-u-sm-8 am-list-main">
                        <h3 class="am-list-item-hd"><a href="http://www.douban.com/online/11624755/">勾三古寺</a></h3>

                        <div class="am-list-item-text">代码压缩和最小化。在这里，我们为你收集了9个最好的JavaScript压缩工具将帮</div>

                    </div>
                </li>
                <hr data-am-widget="divider" style="" class="am-divider am-divider-default" />
                <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
                    <div class="am-u-sm-4 am-list-thumb">
                        <a href="http://www.douban.com/online/11624755/">
                            <img src="<%=basePath%>Temp-images/face.jpg" class="face"/>
                        </a>
                    </div>

                    <div class=" am-u-sm-8 am-list-main">
                        <h3 class="am-list-item-hd"><a href="http://www.douban.com/online/11624755/">勾三古寺</a></h3>

                        <div class="am-list-item-text">代码压缩和最小化。在这里，我们为你收集了9个最好的JavaScript压缩工具将帮</div>

                    </div>
                </li>
            </ul>
        </div>

        <div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
            <h2 class="am-titlebar-title ">
                合作专栏
            </h2>
            <nav class="am-titlebar-nav">
                <a href="#more">more &raquo;</a>
            </nav>
        </div>

        <div data-am-widget="list_news" class="am-list-news am-list-news-default right-bg">
            <ul class="am-list">
                <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
                    <div class="am-u-sm-4 am-list-thumb">
                        <a href="http://www.douban.com/online/11624755/">
                            <img src="<%=basePath%>Temp-images/face.jpg" class="face"/>
                        </a>
                    </div>

                    <div class=" am-u-sm-8 am-list-main">
                        <h3 class="am-list-item-hd"><a href="http://www.douban.com/online/11624755/">勾三古寺</a></h3>

                        <div class="am-list-item-text">代码压缩和最小化。在这里，我们为你收集了9个最好的JavaScript压缩工具将帮</div>
                    </div>
                </li>
                <hr data-am-widget="divider" style="" class="am-divider am-divider-default" />
                <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
                    <div class="am-u-sm-4 am-list-thumb">
                        <a href="http://www.douban.com/online/11624755/">
                            <img src="<%=basePath%>Temp-images/face.jpg" class="face"/>
                        </a>
                    </div>

                    <div class=" am-u-sm-8 am-list-main">
                        <h3 class="am-list-item-hd"><a href="http://www.douban.com/online/11624755/">勾三古寺</a></h3>

                        <div class="am-list-item-text">代码压缩和最小化。在这里，我们为你收集了9个最好的JavaScript压缩工具将帮</div>

                    </div>
                </li>
                <hr data-am-widget="divider" style="" class="am-divider am-divider-default" />
                <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
                    <div class="am-u-sm-4 am-list-thumb">
                        <a href="http://www.douban.com/online/11624755/">
                            <img src="<%=basePath%>Temp-images/face.jpg" class="face"/>
                        </a>
                    </div>

                    <div class=" am-u-sm-8 am-list-main">
                        <h3 class="am-list-item-hd"><a href="http://www.douban.com/online/11624755/">勾三古寺</a></h3>

                        <div class="am-list-item-text">代码压缩和最小化。在这里，我们为你收集了9个最好的JavaScript压缩工具将帮</div>

                    </div>
                </li>
            </ul>
        </div>
        <div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
            <h2 class="am-titlebar-title ">
                评测
            </h2>
            <nav class="am-titlebar-nav">
                <a href="#more">more &raquo;</a>
            </nav>
        </div>

        <div data-am-widget="list_news" class="am-list-news am-list-news-default right-bg">
            <ul class="am-list"  >
                <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
                    <div class="am-u-sm-4 am-list-thumb">
                        <a href="http://www.douban.com/online/11624755/">
                            <img src="<%=basePath%>Temp-images/face.jpg"/>
                        </a>
                    </div>

                    <div class=" am-u-sm-8 am-list-main">
                        <h3 class="am-list-item-hd"><a href="http://www.douban.com/online/11624755/">勾三古寺</a></h3>

                        <div class="am-list-item-text">代码压缩和最小化。在这里，我们为你收集了9个最好的JavaScript压缩工具将帮</div>
                    </div>
                </li>
                <hr data-am-widget="divider" style="" class="am-divider am-divider-default" />
                <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
                    <div class="am-u-sm-4 am-list-thumb">
                        <a href="http://www.douban.com/online/11624755/">
                            <img src="<%=basePath%>Temp-images/face.jpg"/>
                        </a>
                    </div>

                    <div class=" am-u-sm-8 am-list-main">
                        <h3 class="am-list-item-hd"><a href="http://www.douban.com/online/11624755/">勾三古寺</a></h3>

                        <div class="am-list-item-text">代码压缩和最小化。在这里，我们为你收集了9个最好的JavaScript压缩工具将帮</div>

                    </div>
                </li>
                <hr data-am-widget="divider" style="" class="am-divider am-divider-default" />
                <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
                    <div class="am-u-sm-4 am-list-thumb">
                        <a href="http://www.douban.com/online/11624755/">
                            <img src="<%=basePath%>Temp-images/face.jpg"/>
                        </a>
                    </div>

                    <div class=" am-u-sm-8 am-list-main">
                        <h3 class="am-list-item-hd"><a href="http://www.douban.com/online/11624755/">勾三古寺</a></h3>

                        <div class="am-list-item-text">代码压缩和最小化。在这里，我们为你收集了9个最好的JavaScript压缩工具将帮</div>

                    </div>
                </li>
            </ul>
        </div>

        <ul class="am-gallery am-avg-sm-1
  am-avg-md-1 am-avg-lg-1 am-gallery-default" data-am-gallery="{ pureview: true }" >
            <li>
                <div class="am-gallery-item">
                    <a href="http://s.amazeui.org/media/i/demos/bing-1.jpg" class="">
                        <img src="http://s.amazeui.org/media/i/demos/bing-1.jpg"  alt="远方 有一个地方 那里种有我们的梦想"/>
                        <h3 class="am-gallery-title">远方 有一个地方 那里种有我们的梦想</h3>
                        <div class="am-gallery-desc">
                            <div class="am-fr">北京</div>
                            <div class="am-fl">2016/11/11</div>
                        </div>
                    </a>
                </div>
            </li>
            <li>
                <div class="am-gallery-item">
                    <a href="http://s.amazeui.org/media/i/demos/bing-2.jpg" class="">
                        <img src="http://s.amazeui.org/media/i/demos/bing-2.jpg"  alt="某天 也许会相遇 相遇在这个好地方"/>
                        <h3 class="am-gallery-title">某天 也许会相遇 相遇在这个好地方</h3>
                        <div class="am-gallery-desc">
                            <div class="am-fr">北京</div>
                            <div class="am-fl">2016/11/11</div>
                        </div>
                    </a>
                </div>
            </li>
            <li>
                <div class="am-gallery-item">
                    <a href="http://s.amazeui.org/media/i/demos/bing-2.jpg" class="">
                        <img src="http://s.amazeui.org/media/i/demos/bing-2.jpg"  alt="某天 也许会相遇 相遇在这个好地方"/>
                        <h3 class="am-gallery-title">某天 也许会相遇 相遇在这个好地方</h3>
                        <div class="am-gallery-desc">
                            <div class="am-fr">北京</div>
                            <div class="am-fl">2016/11/11</div>
                        </div>
                    </a>
                </div>
            </li>
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
        <p>Amaze UI出品<br>© 2016 AllMobilize, Inc. Licensed under MIT license. Developed with WebStorm.</p>
        <div class="w2div">
            <ul data-am-widget="gallery" class="am-gallery am-avg-sm-2
  am-avg-md-2 am-avg-lg-2 am-gallery-overlay" data-am-gallery="{ pureview: true }" >
                <li class="w2">
                    <div class="am-gallery-item">
                        <a href="<%=basePath%>Temp-images/dd.jpg">
                            <img src="<%=basePath%>Temp-images/dd.jpg" />
                            <h3 class="am-gallery-title">订阅号：Amaze UI</h3>
                        </a>
                    </div>
                </li>
                <li   class="w2">
                    <div class="am-gallery-item">
                        <a href="<%=basePath%>Temp-images/dd.jpg">
                            <img src="<%=basePath%>Temp-images/dd.jpg"/>
                            <h3 class="am-gallery-title">服务号：Amaze UI</h3>
                        </a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</footer>
</body>
</html>
