<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="http://g.alicdn.com/bui/bui/1.1.21/css/bs3/dpl.css" rel="stylesheet">
    <link href="http://g.alicdn.com/bui/bui/1.1.21/css/bs3/bui.css" rel="stylesheet">
    <!--<link rel="stylesheet" href="css/common.css">-->
    <link rel="stylesheet" href="font/iconfont.css">
    <!--<link rel="stylesheet" href="css/supplier-mes.css">-->
    <link rel="stylesheet" href="css/index.css">
    <script src="js/jquery.min.js"></script>
</head>
<style>
</style>
<body>

<div class="doc-content">
    <ul class="breadcrumb breadcrumb2"></ul>
    <ul class="breadcrumb">
        <li>
            <span class="iconfont icon-shouye"></span>
            <a href="#">首页</a> <span class="divider"><span class="iconfont icon-down-trangle1"></span></span>
        </li>
        <li class="active">
            <a href="#">角色管理</a> <span class="divider"><span class="iconfont"></span></span>
        </li>
    </ul>
    <div class="tit">
        <span class="iconfont icon-guanlianniu"></span>
        <span>角色选择</span>
        <span class="iconfont icon-down-trangle2"></span>
    </div>


    <form class="form-horizontal gd" style="padding-top: 20px;" >
        <div class="row">
            <div class="control-group span8">
                <label class="control-label">角色：</label>
                <div class="controls">
                    <select class="sel1" onchange="role()">
                    		<option  value="0">请选择</option>
                		<c:forEach items="${role}" var="ro" >
                			<option  value="${ro.id}">${ro.role_name}</option>
                		</c:forEach>
                    </select>
                </div>
            </div>
        </div>
        <hr>
    </form>
    <div class="tit">
        <span class="iconfont icon-guanlianniu"></span>
        <span>售后申请列表</span>
        <span class="iconfont icon-down-trangle2"></span>
    </div>
    <div class="span95">
        <table cellspacing="0" class="table table-head-bordered table-bordered qx table-sm">
	        <a href="updateprivilege?type=add">
	            <div class="s-btn">
	                <span style="color: black">新增</span>
	            </div>
	        </a>
            <thead>
            <tr style="">
                <th>目录ID</th>
                <th>目录名称</th>
                <th>上级目录名称</th>
                <th>目录级别</th>
                <th>是否可访问</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${privilege}" var="obj">
             <tr>
                <td>${obj.id}</td>
                <td>${obj.module }</td>
                <td>${obj.superior_module_name }</td>
                <td>${obj.grade }</td>
                <td>
	                是：<input <c:if test="${obj.isvisit==1}">checked</c:if> type="radio" value="1" name="isvisit${obj.id}" onchange="privilege('${obj.id}','1')">
	                否：<input <c:if test="${obj.isvisit==0}">checked</c:if> type="radio" value="0" name="isvisit${obj.id}" onchange="privilege('${obj.id}','0')">
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>

<!-- script end -->
<script type="text/javascript">
$(function(){
	$(".sel1").val("${role_id}");
})
function role(){
	var  role_id = $(".sel1").val();
		window.location.href="privilegeSelect?role_id="+role_id+"";
}

function privilege(privilege_id,isvisit){
	var  role_id = $(".sel1").val();
	if(role_id==0){
		alert("请选择角色");
	}else{
		$.ajax({
	        url : '<%= request.getContextPath()%>/update_privilege_role',
	        type : "POST",
	        data : {"privilege_id":privilege_id,"isvisit":isvisit,"role_id":role_id},
	        dataType : "text",
	        success : function(data) {
	        	console.log(data);
	        	if(data=="成功"){
// 	        		window.location.href="privilegeSelect";
	        		role()
	        	}
	        }
	     });
	}
		
}
</script>

</body>
</html>