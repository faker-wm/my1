<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="http://g.alicdn.com/bui/bui/1.1.21/css/bs3/dpl.css" rel="stylesheet">
    <link href="http://g.alicdn.com/bui/bui/1.1.21/css/bs3/bui.css" rel="stylesheet">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="font/iconfont.css">
</head>
<body>
<script src="js/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	 $(".sel3").val("${banner.order}");
})
</script>
<div class="box">
    <form action="" id="form_2">
    <div class="row">
        <div class="control-group">
            <label class="control-label">目录名字：</label>
            <input type="text"  name="module" class="control-text" value="${banner.title}">
        </div>
    </div>
     <div class="row">
        <div class="control-group">
            <label class="control-label">目录级别</label>
            <select name="grade" >
            		<option value="1">1级</option>
            		<option value="2">2级</option>
            </select>
        </div>
    </div>
    <div class="row">
        <div class="control-group">
            <label class="control-label">上级目录</label>
            <select name="superior_module" >
            	<option>请选择</option>
            	<c:forEach items="${privilege }" var="obj">
            		<option value="${obj.id}">${obj.module }</option>
            	</c:forEach>
            </select>
        </div>
    </div>
    <div class="row">
        <div class="control-group">
            <label class="control-label"><s>*</s>URL：</label>
            <input type="text"  name="url" class="control-text" value="${banner.URL }">
        </div>
    </div>
    <div class="btn" id="submit">
        <span>添加</span>
    </div>
</form>
</div>
</body>
<script>
$(document).ready(function(){
	 $('#submit').eq(0).click(function(){
		 alert("aa");
            $.ajax({
               url:'privilege',
               type:"POST",
               data:$('#form_2').serialize(),
               dataType:"json",
               success: function(data) {
                   if(data.message=="成功"){
                       $('#pos1').css({'display':'block'});
                       $('#pos2').addClass('dis-none');
                       window.location.href="privilegeSelect";
                   }else{
                       $('#pos2').css({'display':'block'});
                       $('#pos1').addClass('dis-none');
                   }
               }
           });
	 })
})
</script>
</html>