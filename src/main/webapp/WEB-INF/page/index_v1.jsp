<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2018/12/5
  Time: 10:21
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


    <title>人纹招聘后台管理系统 - 主页</title>

    <link rel="shortcut icon" href="favicon.ico"> <link href="${baseUrl}admin/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${baseUrl}admin/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${baseUrl}admin/css/animate.css" rel="stylesheet">
    <link href="${baseUrl}admin/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="row">
    <div class="col-sm-12">

        <div class="wrapper wrapper-content">
            <div class="row animated fadeInRight">
                <div class="col-sm-12">
                    <div class="ibox float-e-margins">
                        <div class="text-center float-e-margins p-md">
                            <span>预览：</span>
                            <a href="#" class="btn btn-xs btn-primary" id="lightVersion">浅色</a>
                            <a href="#" class="btn btn-xs btn-primary" id="darkVersion">深色</a>
                            <a href="#" class="btn btn-xs btn-primary" id="leftVersion">布局切换</a>
                        </div>
                        <div class="" id="ibox-content">

                            <div id="vertical-timeline" class="vertical-container light-timeline">
                                <div class="vertical-timeline-block">
                                    <div class="vertical-timeline-icon navy-bg">
                                        <i class="fa fa-file-text"></i>
                                    </div>

                                    <div class="vertical-timeline-content">
                                        <h2>目录总计</h2>
                                        <p>系统当前拥有目录<span id="categoryTotal" style="font-size: 22px;color: #00E8D7"></span>条
                                        </p>

                                        <span class="vertical-date">
                                        统计 <br>
                                        <small>今天</small>
                                    </span>
                                    </div>
                                </div>

                                <div class="vertical-timeline-block">
                                    <div class="vertical-timeline-icon blue-bg">
                                        <i class="fa fa-file-text"></i>
                                    </div>

                                    <div class="vertical-timeline-content">
                                        <h2>申请总计</h2>
                                        <p>系统当前申请总计为<span id="acceptTotal"  style="font-size: 22px;color: #00E8D7"></span>条</p>

                                        <span class="vertical-date">
                                        统计 <br>
                                        <small>今天</small>
                                    </span>
                                    </div>
                                </div>

                                <div class="vertical-timeline-block">
                                    <div class="vertical-timeline-icon lazur-bg">
                                        <i class="fa fa-file-text"></i>
                                    </div>

                                    <div class="vertical-timeline-content">
                                        <h2>公司总计</h2>
                                        <p>系统当前公司总计为<span id="companyTotal"  style="font-size: 22px;color: #00E8D7"></span>个</p>

                                        <span class="vertical-date"> 统计 <br><small>今天</small></span>
                                    </div>
                                </div>

                                <div class="vertical-timeline-block">
                                    <div class="vertical-timeline-icon yellow-bg">
                                        <i class="fa fa-file-text"></i>
                                    </div>

                                    <div class="vertical-timeline-content">
                                        <h2>职位总计</h2>
                                        <p>系统当前职位总计为<span id="jobTotal"  style="font-size: 22px;color: #00E8D7"></span>个</p>
                                        <span class="vertical-date">统计 <br><small>今天</small></span>
                                    </div>
                                </div>

                                <div class="vertical-timeline-block">
                                    <div class="vertical-timeline-icon lazur-bg">
                                        <i class="fa fa-file-text"></i>
                                    </div>

                                    <div class="vertical-timeline-content">
                                        <h2>资讯总计</h2>
                                        <p>系统当前资讯总计为<span id="messageTotal"  style="font-size: 22px;color: #00E8D7"></span>条</p>
                                        <span class="vertical-date">统计 <br><small>今天</small></span>
                                    </div>
                                </div>


                                <div class="vertical-timeline-block">
                                    <div class="vertical-timeline-icon yellow-bg">
                                        <i class="fa fa-file-text"></i>
                                    </div>

                                    <div class="vertical-timeline-content">
                                        <h2>求职者总数</h2>
                                        <p>系统当前求职者总计为<span id="jobHunterTotal"  style="font-size: 22px;color: #00E8D7"></span>位</p>
                                        <span class="vertical-date">统计 <br><small>今天</small></span>
                                    </div>
                                </div>

                                <div class="vertical-timeline-block">
                                    <div class="vertical-timeline-icon lazur-bg">
                                        <i class="fa fa-file-text"></i>
                                    </div>

                                    <div class="vertical-timeline-content">
                                        <h2>简历总计</h2>
                                        <p>系统当前简历总计为<span id="resumeTotal" style="font-size: 22px;color: #00E8D7"></span>条</p>
                                        <span class="vertical-date">统计 <br><small>今天</small></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>


</div>
<!-- 全局js -->
<script src="${baseUrl}admin/js/jquery.min.js?v=2.1.4"></script>
<script src="${baseUrl}admin/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${baseUrl}admin/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${baseUrl}admin/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${baseUrl}admin/js/plugins/layer/layer.min.js"></script>

<script src="${baseUrl}admin/js/hplus.js?v=4.1.0"></script>





<script>
    $(document).ready(function () {

        // Local script for demo purpose only
        $('#lightVersion').click(function (event) {
            event.preventDefault()
            $('#ibox-content').removeClass('ibox-content');
            $('#vertical-timeline').removeClass('dark-timeline');
            $('#vertical-timeline').addClass('light-timeline');
        });

        $('#darkVersion').click(function (event) {
            event.preventDefault()
            $('#ibox-content').addClass('ibox-content');
            $('#vertical-timeline').removeClass('light-timeline');
            $('#vertical-timeline').addClass('dark-timeline');
        });

        $('#leftVersion').click(function (event) {
            event.preventDefault()
            $('#vertical-timeline').toggleClass('center-orientation');
        });


    });
</script>

<script>
    $(document).ready(function () {

        // Examle data for jqGrid
        $.ajax({
            type: 'GET',
            url: "http://localhost:8089/recruit/ajax/totalCount",
            data: {},
            // dataType: "json",
            success: function (data) {
                console.log(data);
                var mydata = data;
                var categoryTotal=document.getElementById("categoryTotal");
                var messageTotal=document.getElementById("messageTotal");
                var acceptTotal=document.getElementById("acceptTotal");
                var jobHunterTotal=document.getElementById("jobHunterTotal");
                var jobTotal=document.getElementById("jobTotal");
                var resumeTotal=document.getElementById("resumeTotal");
                var companyTotal=document.getElementById("companyTotal");

                categoryTotal.textContent=mydata.categoryTotal;
                messageTotal.textContent=mydata.messageTotal;
                acceptTotal.textContent=mydata.acceptTotal;
                jobHunterTotal.textContent=mydata.jobHunterTotal;
                jobTotal.textContent=mydata.jobTotal;
                resumeTotal.textContent=mydata.resumeTotal;
                companyTotal.textContent=mydata.companyTotal;


            }
        });
    });
</script>

</body>

</html>
