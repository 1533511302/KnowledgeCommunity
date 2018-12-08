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


    <title>后台管理系统 - 音频管理</title>

    <link rel="shortcut icon" href="favicon.ico"> <link href="${baseUrl}admin/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${baseUrl}admin/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <!-- jqgrid-->
    <link href="${baseUrl}admin/css/plugins/jqgrid/ui.jqgrid.css?0820" rel="stylesheet">

    <!-- Sweet Alert -->
    <link href="${baseUrl}admin/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">


    <link href="${baseUrl}admin/css/animate.css" rel="stylesheet">
    <link href="${baseUrl}admin/css/style.css?v=4.1.0" rel="stylesheet">

    <style>
        /* Additional style to fix warning dialog position */

        #alertmod_table_list_2 {
            top: 900px !important;
        }
    </style>

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content  animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox ">
                <div class="ibox-title">
                    <h5>图文管理</h5>
                </div>
                <div class="ibox-content">

                    <hr>

                    <h4 class="m-t"></h4>


                    <div class="jqGrid_wrapper">
                        <table id="table_list_2"></table>
                        <div id="pager_list_2"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 全局js -->
<script src="${baseUrl}admin/js/jquery.min.js?v=2.1.4"></script>
<script src="${baseUrl}admin/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${baseUrl}admin/js/ajaxfileupload.js" type="text/javascript"></script>



<!-- Peity -->
<script src="${baseUrl}admin/js/plugins/peity/jquery.peity.min.js"></script>

<!-- jqGrid -->
<script src="${baseUrl}admin/js/plugins/jqgrid/i18n/grid.locale-cn.js?0820"></script>
<script src="${baseUrl}admin/js/plugins/jqgrid/jquery.jqGrid.min.js?0820"></script>


<!-- Page-Level Scripts -->
<script>
    $(document).ready(function () {

        var mydata
        $.jgrid.defaults.styleUI = 'Bootstrap';
        // Examle data for jqGrid
        $.ajax({
            type: 'GET',
            url: "${baseUrl}findAllQuestion",
            data:{

            },
            // dataType: "json",
            success: function (data) {
                mydata =data;


                //在表格的单元列中显示图片
                function imageFormat( cellvalue, options, rowObject ){
                    return '<img src="/img/'+cellvalue+ '"  style="width:80px;height:50px;" />';
                }


                // Configuration for jqGrid Example 2
                $("#table_list_2").jqGrid({
                    data: mydata,
                    datatype: "local",
                    height: 550,
                    autowidth: true,
                    shrinkToFit: true,
                    rowNum: 20,
                    rowList: [10, 20, 30],
                    colNames: ['编号', '标题','详情','话题','提问者','点赞量','浏览量','关注量','回答数','状态','创建时间'],
                    colModel: [
                        {
                            name: 'id',
                            index: 'id',
                            width: 60,
                            editable:true,
                            search: true
                        },
                        {
                            name: 'quesName',
                            index: 'quesName',
                            width: 120,
                            editrules:{edithidden:true,required:true,},
                            search: true

                        },
                        {
                            name: 'quesDescribe',
                            index: 'quesDescribe',
                            width: 150,
                            editrules:{edithidden:true,required:true},
                            search: true

                        },

                        {
                            name: 'topic',
                            index: 'topic',
                            width: 60,
                            editrules:{edithidden:true,required:true},
                            search: true

                        },
                        {
                            name: 'username',
                            index: 'username',
                            width: 60,
                            editrules:{edithidden:true,required:true},
                            search: true

                        },
                        {
                            name: 'likeNumb',
                            index: 'likeNumb',
                            width: 40,
                            editrules:{edithidden:true,required:true,number:true},
                            search: true

                        },
                        {
                            name: 'browseNumb',
                            index: 'browseNumb',
                            width: 40,
                            editrules:{edithidden:true,required:true,number:true},
                            search: true

                        },
                        {
                            name: 'attentionNumb',
                            index: 'attentionNumb',

                            width: 40,
                            editrules:{edithidden:true,required:true,number:true},
                            search: true

                        },
                        {
                            name: 'answerNumb',
                            index: 'answerNumb',

                            width: 40,
                            editrules:{edithidden:true,required:true,number:true},
                            search: true

                        },
                        {
                            name: 'status',
                            index: 'status',
                            editable: true,
                            width: 40,
                            editrules:{edithidden:true,required:true,number:true},
                            search: true

                        },


                        {
                            name: 'createTime',
                            index: 'createTime',
                            width: 100,


                        }

                    ],
                    pager: "#pager_list_2",
                    viewrecords: true,
                    caption: "音频信息",
                    add: false,
                    edit: true,
                    addtext: 'Add',
                    edittext: 'Edit',
                    hidegrid: false
                });

                // Add selection
                $("#table_list_2").setSelection(4, true);


                // Setup buttons
                $("#table_list_2").jqGrid('navGrid', '#pager_list_2', {
                        edit: true,
                        add: false,
                        del: true,
                        delfunc:deleteWorkgroup,
                        search: true
                    }
                    , {
                        url:"${baseUrl}adminUpdateQuestion",
                        height: 200,
                        reloadAfterSubmit: true,
                        editHidden:true,
                        recreateForm:true,
                        afterSubmit: showTipInfo,
                        closeAfterEdit:true

                    }

                    //, {
                    //     url:"http://localhost:8089/recruit/bg/category/delete",
                    //     height: 200,
                    //     reloadAfterSubmit: true,
                    //     recreateForm:true
                    // }, {
                    //
                    //     height: 200,
                    //     reloadAfterSubmit: true,
                    //     recreateForm:true
                    // }
                );

                //提示信息
                function showTipInfo() {
                    swal({
                        title: "成功",
                        text: "对目录信息进行了更改",
                        type: "success",
                        confirmButtonColor: "#4CAF50",
                        confirmButtonText: "OK",
                        closeOnConfirm: false
                    }, function () {
                        location.reload();
                    });
                }
              


                function deleteWorkgroup(){
                    {
                        var ids = $("#table_list_2").jqGrid('getGridParam','selrow');//
                        var rowData = $("#table_list_2").jqGrid("getRowData",ids);//
                        var id= rowData.id;


                        swal({
                                title: "您确定要删除这条信息吗",
                                text: "删除后将无法恢复，请谨慎操作！",
                                type: "warning",
                                showCancelButton: true,
                                confirmButtonColor: "#DD6B55",
                                confirmButtonText: "是的，我要删除！",
                                cancelButtonText: "让我再考虑一下…",
                                closeOnConfirm:  false,
                                closeOnCancel: false
                            },
                            function (isConfirm) {
                                if (isConfirm) {
                                    if(ids<1){


                                    }else {

                                        $.ajax({
                                            url: "${baseUrl}deleteQuestion",
                                            data: {
                                                "questionId": id
                                            },
                                            type: 'POST',
                                            success: function (data) {
                                                mydata2 = data;
                                            }
                                        });
                                    }
                                    if(mydata2){
                                        jQuery("#table_list_2").delRowData(ids);
                                        swal("删除成功！", "您已经永久删除了这条信息。", "success");
                                        location.reload();
                                    }else {

                                        swal("删除失败！", "过程中发生错误，请重试", "error");
                                    }
                                    // $.ajax({
                                    //     type: 'GET',
                                    //     url: "http://localhost:8089/recruit/ajax/category",
                                    //     data: {},
                                    //     // dataType: "json",
                                    //     success: function (data) {
                                    //         mydata = data;
                                    //         $("#jqGrid_ds").jqGrid('setGridParam',{  // 重新加载数据
                                    //
                                    //
                                    //
                                    //             datatype:'local',
                                    //             data : mydata,   //  newdata 是符合格式要求的需要重新加载的数据
                                    //             page:1
                                    //         }).trigger("reloadGrid");
                                    //     }
                                    // });


                                } else {
                                    swal("已取消", "您取消了删除操作！", "error");
                                }
                            });

                    }
                }



                // Add responsive to jqGrid
                $(window).bind('resize', function () {
                    var width = $('.jqGrid_wrapper').width();
                    $('#table_list_2').setGridWidth(width);
                });
            }

        })

    });






</script>

<!-- Sweet alert -->
<script src="js/plugins/sweetalert/sweetalert.min.js"></script>

</body>

</html>

