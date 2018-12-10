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


    <title>H+ 后台主题UI框架 - 首页示例二</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico"> <link href="${baseUrl}admin/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${baseUrl}admin/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <!-- Morris -->
    <link href="${baseUrl}admin/css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">

    <!-- Gritter -->
    <link href="${baseUrl}admin/js/plugins/gritter/jquery.gritter.css" rel="stylesheet">

    <link href="${baseUrl}admin/css/animate.css" rel="stylesheet">
    <link href="${baseUrl}admin/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-sm-3">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <span class="label label-success pull-right">全部</span>
                    <h5>图文数</h5>
                </div>
                <div class="ibox-content">
                    <h1 class="no-margins" id="massageNumb">40 886,200</h1>
                    <div class="stat-percent font-bold text-success">100% <i class="fa fa-level-up"></i>
                    </div>
                    <small>图文总数</small>
                </div>
            </div>
        </div>
        <div class="col-sm-3">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <span class="label label-info pull-right">全部</span>
                    <h5>音频数</h5>
                </div>
                <div class="ibox-content">
                    <h1 class="no-margins" id="audioNumb">275,800</h1>
                    <div class="stat-percent font-bold text-info">100% <i class="fa fa-level-up"></i>
                    </div>
                    <small>音频总数</small>
                </div>
            </div>
        </div>
        <div class="col-sm-3">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <span class="label label-primary pull-right">全部</span>
                    <h5>问题数</h5>
                </div>
                <div class="ibox-content">
                    <h1 class="no-margins" id="questionNumb">106,120</h1>
                    <div class="stat-percent font-bold text-navy">100% <i class="fa fa-level-up"></i>
                    </div>
                    <small>问题总数</small>
                </div>
            </div>
        </div>
        <div class="col-sm-3">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <span class="label label-danger pull-right">全部</span>
                    <h5>用户数</h5>
                </div>
                <div class="ibox-content">
                    <h1 class="no-margins" id="userNumb">80,600</h1>
                    <div class="stat-percent font-bold text-danger">100% <i class="fa fa-level-up"></i>
                    </div>
                    <small>用户总数</small>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-4">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>消息</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content ibox-heading">
                    <h3><i class="fa fa-envelope-o"></i> 新消息</h3>
                    <small><i class="fa fa-tim"></i> 您有未处理的消息</small>
                </div>
                <div class="ibox-content">
                    <div id="feed-activity" class="feed-activity-list">


                    </div>
                </div>
            </div>
        </div>

        <div class="col-sm-8">

            <div class="row">
                <div class="col-sm-6">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>最活跃用户列表</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <table class="table table-hover no-margins">
                                <thead>
                                <tr>
                                    <th>用户</th>
                                    <th>性别</th>
                                    <th>简介</th>
                                    <th>角色</th>
                                </tr>
                                </thead>
                                <tbody id="hotUser">

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>修改个人信息</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <form class="form-horizontal" onsubmit="return onClickUpdatePasswordBtn()">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">用户名</label>

                                    <div class="col-sm-10">
                                        <input id="username" type="text" class="form-control" >
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">旧密码</label>

                                    <div class="col-sm-10">
                                        <input id="oldPassword" type="password" class="form-control" >
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">新密码</label>

                                    <div class="col-sm-10">
                                        <input id="newPassword" type="password" class="form-control" >
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">确认密码</label>

                                    <div class="col-sm-10">
                                        <input id="confirm" type="password" class="form-control">
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <div class="col-sm-4 col-sm-offset-2">
                                        <button class="btn btn-primary" type="submit">提交</button>
                                    </div>
                                </div>
                            </form>
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



<!-- Flot -->
<script src="${baseUrl}admin/js/plugins/flot/jquery.flot.js"></script>
<script src="${baseUrl}admin/js/plugins/flot/jquery.flot.tooltip.min.js"></script>
<script src="${baseUrl}admin/js/plugins/flot/jquery.flot.spline.js"></script>
<script src="${baseUrl}admin/js/plugins/flot/jquery.flot.resize.js"></script>
<script src="${baseUrl}admin/js/plugins/flot/jquery.flot.pie.js"></script>
<script src="${baseUrl}admin/js/plugins/flot/jquery.flot.symbol.js"></script>

<!-- Peity -->
<script src="${baseUrl}admin/js/plugins/peity/jquery.peity.min.js"></script>
<script src="${baseUrl}admin/js/demo/peity-demo.js"></script>

<!-- 自定义js -->
<script src="${baseUrl}admin/js/content.js?v=1.0.0"></script>


<!-- jQuery UI -->
<script src="${baseUrl}admin/js/plugins/jquery-ui/jquery-ui.min.js"></script>


<script>
    //修改个人信息
      function onClickUpdatePasswordBtn() {
          console.log("33232");
          var username=$("#username").val();
          if (username==""){

              alert("用户名不能为空！");
              return false;//因为这是submit表单提交 返回false 不进行请求
          }else {
              var oldPassword=$("#oldPassword").val();
              if (oldPassword==""){
                  alert("旧密码不能为空！");
                  return false;
              }

              var newPassword=$("#newPassword").val();
              if (newPassword==""){
                  alert("新密码不能为空！");
                  return false;
              }
              var confirm=$("#confirm").val();
              if(confirm !=newPassword){
                  alert("确认密码不相等！");
              }else {
                  $.ajax({
                      type: 'post',
                      url: "${baseUrl}updateUserPassword",
                      data: {username:username,oldPassword:oldPassword,newPassword:newPassword},
                      success: function (data) {
                          if(data=="2"){
                              alert("修改成功！");
                              window.location.href="${baseUrl}userInfo/${user.id}";
                          }
                          if(data=="1"){
                              alert("用户名或旧密码输入错误！")
                          }
                          if(data=="0"){
                              alert("修改操作失败！")
                          }

                      }
                  });
              }
          }

      }

      //加载用户、图文、问题、音频统计数
    $.post("${baseUrl}indexCount",null,function (data) {
        $.each(data,function (i,countForm) {
           if(countForm.label=="user"){
               $("#userNumb").text(countForm.value);
           }
            if(countForm.label=="massage"){
                $("#massageNumb").text(countForm.value);
            }
            if(countForm.label=="audio"){
                $("#audioNumb").text(countForm.value);
            }
            if(countForm.label=="question"){
                $("#questionNumb").text(countForm.value);
            }
        });
    });

      //加载用户请求
    $.post("${baseUrl}findApplyByStatus",null,function (data) {
        $.each(data,function (i,apply) {
            if(apply.status=="3"){
                $("#feed-activity").append(" <div class=\"feed-element\">\n" +
                    "                            <div>\n" +
                    "                                <small class=\"pull-right text-navy\"><a onclick=\"onClickDeleteApply("+apply.id+")\"><span class=\"label label-warning\">删除</span></a></small>\n" +
                    "                                <strong>系统通知</strong>\n" +
                    "                                <div>"+apply.content+"</div>\n" +
                    "                                <small class=\"text-muted\">"+apply.createTime+"</small>\n" +
                    "                            </div>\n" +
                    "                        </div>");
            }else {
                $("#feed-activity").append(" <div class=\"feed-element\">\n" +
                    "                            <div>\n" +
                    "                                <small class=\"pull-right text-navy\"><a onclick=\"onClickToVUser("+apply.userId+","+apply.id+")\"><span class=\"label label-primary\">同意</span></a><a onclick=\"onClickDeleteApply("+apply.id+")\"><span class=\"label label-warning\">删除</span></a></small>\n" +
                    "                                <strong>申请信息</strong>\n" +
                    "                                <div>"+apply.content+"</div>\n" +
                    "                                <small class=\"text-muted\">"+apply.createTime+"</small>\n" +
                    "                            </div>\n" +
                    "                        </div>");
            }

        });
    });

    //加载热门用户
    $.post("${baseUrl}findHotUser",null,function (data) {
        console.log(data);
        $.each(data,function (i,user) {
            var gender = (user.gender=="1"?"男":"女");
            var role =(user.role=="1"?"普通用户":"认证用户")
            $("#hotUser").append(" <tr>\n" +
                "                                    <td>"+user.realname+"</td>\n" +
                "                                    <td>"+gender+"</td>\n" +
                "                                    <td>"+user.autograph+"</td>\n" +
                "                                    <td class=\"text-navy\"> "+role+"</td>\n" +
                "                                </tr>");
        });
    });


      function onClickToVUser(userId,id) {
          $.post("${baseUrl}updateUserRole",{userId:userId,id:id},function (data) {
              if(data){
                  alert("修改角色成功");
                  location.reload();
              }
          });
      }

      function onClickDeleteApply(id) {
          $.post("${baseUrl}deleteApply",{id:id},function (data) {
              if(data){
                  alert("删除成功");
                  location.reload();
              }
          });
      }

</script>

</body>

</html>
