<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2018/12/5
  Time: 11:12
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


    <title>人纹招聘后台管理系统 - Morris.js图表</title>

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <!-- orris -->
    <link href="css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">

    <div class="row">

        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>图文热门标签统计柱状图</h5>
                <div class="ibox-tools">
                    <a class="collapse-link">
                        <i class="fa fa-chevron-up"></i>
                    </a>
                    <a class="dropdown-toggle" data-toggle="dropdown" href="graph_morris.html#">
                        <i class="fa fa-wrench"></i>
                    </a>


                </div>
            </div>
            <div class="ibox-content">
                <div id="morris-bar-chart1"></div>
            </div>
        </div>

    </div>

    <div class="row">

        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>问答热门标签统计柱状图</h5>
                <div class="ibox-tools">
                    <a class="collapse-link">
                        <i class="fa fa-chevron-up"></i>
                    </a>
                    <a class="dropdown-toggle" data-toggle="dropdown" href="graph_morris.html#">
                        <i class="fa fa-wrench"></i>
                    </a>


                </div>
            </div>
            <div class="ibox-content">
                <div id="morris-bar-chart2"></div>
            </div>
        </div>

    </div>


</div>


<!-- 全局js -->
<script src="js/jquery.min.js?v=2.1.4"></script>
<script src="js/bootstrap.min.js?v=3.3.6"></script>



<!-- Morris -->
<script src="js/plugins/morris/raphael-2.1.0.min.js"></script>
<script src="js/plugins/morris/morris.js"></script>

<!-- 自定义js -->
<script src="js/content.js?v=1.0.0"></script>




<!-- Morris demo data-->
<script>
    $(function() {

        $.ajax({
            type: 'GET',
            url: "${baseUrl}count/labelByMassage",
            data: {},
            // dataType: "json",
            success: function (data) {
                var mydata =data

                Morris.Bar({
                    element: 'morris-bar-chart1',
                    data: mydata,
                    xkey: 'label',
                    ykeys: ['value'],
                    labels: ['图文'],
                    hideHover: 'auto',
                    resize: true,
                    barColors: ['#1a8394'],
                });


            }
        });


        $.ajax({
            type: 'GET',
            url: "${baseUrl}count/labelByQuestion",
            data: {},
            // dataType: "json",
            success: function (data) {
                var mydata =data

                Morris.Bar({
                    element: 'morris-bar-chart2',
                    data: mydata,
                    xkey: 'label',
                    ykeys: ['value'],
                    labels: ['问答'],
                    hideHover: 'auto',
                    resize: true,
                    barColors: ['#1a8394'],
                });


            }
        });






    });

    // $(function() {
    //
    //
    //
    //     Morris.Donut({
    //         element: 'morris-donut-chart',
    //         data: [{
    //             label: "A系列",
    //             value: 12
    //         }, {
    //             label: "B系列",
    //             value: 30
    //         }, {
    //             label: "C系列",
    //             value: 20
    //         }],
    //         resize: true,
    //         colors: ['#87d6c6', '#54cdb4','#1ab394'],
    //     });
    //
    //     Morris.Bar({
    //         element: 'morris-bar-chart',
    //         data: [{
    //             y: '2006',
    //             a: 60,
    //             b: 50
    //         }, {
    //             y: '2007',
    //             a: 75,
    //             b: 65
    //         }, {
    //             y: '2008',
    //             a: 50,
    //             b: 40
    //         }, {
    //             y: '2009',
    //             a: 75,
    //             b: 65
    //         }, {
    //             y: '2010',
    //             a: 50,
    //             b: 40
    //         }, {
    //             y: '2011',
    //             a: 75,
    //             b: 65
    //         }, {
    //             y: '2012',
    //             a: 100,
    //             b: 90
    //         }],
    //         xkey: 'y',
    //         ykeys: ['a', 'b'],
    //         labels: ['A系列', 'B系列'],
    //         hideHover: 'auto',
    //         resize: true,
    //         barColors: ['#1ab394', '#cacaca'],
    //     });
    //
    //
    //
    // });


</script>

</body>

</html>
