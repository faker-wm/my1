<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/ajax2/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
function sub(){
	$.ajax({
		 type : "post",                         //请求方式有get和post两种
		 url : '/ajax2/userinfo',               //请求的路径(用绝对路径)
		 data: $('#xxx').serialize(),  //要提交的表单进行序列化
		 dataType : "json",               //返回的数据格式：json/xml/html/script/jsonp/text
		 success : function(returnedData){        //returnedData是返回的结果
		 alert(returnedData);
		 },
		error: function(returnedData) {  
		 alert("加载彩票数据出错!");
		}             
	}); 
}
function preview() {
   var formData = new FormData($("#xxx")[0]);
   $.ajax({
      url : '<%= request.getContextPath()%>/img',
      type : "POST",
      data : formData,
      dataType : "json",
      processData : false, //必须false才会避开jQuery对 formdata 的默认处理
      contentType : false, //必须false才会自动加上正确的Content-Type
      cache : false, //true的话会读缓存
      success : function(data) {
      	console.log(data);
    	$.each(data,function(i,obj){
    		$("#preview").append('<img alt="图片" src="/ajax2/file/'+$(obj)[0].saveFilename+'">');
    		$("#xxx").append('<input type="hidden" name="headimg" value="'+$(obj)[0].saveFilename+'">');
    	})
      }
   });
}
</script>
</head>
<body>

<form id="xxx" action="/ajax2/userinfo"  method="post">
用户名：<input type="text" name="username" value=""> <br><br>
密码：<input type="text" name="password" value=""> <br><br>
年龄：<input type="text" name="age" value=""> <br><br>

<select  name="address">
<option value="太原">太原</option>
<option value="晋中">晋中</option>
<option value="长治">长治</option>
</select><br><br>

男： <input  type="radio" value="男"  name="sex" > 
女：<input type="radio" value="女" name="sex" >  <br><br>

蓝球：<input value="蓝球" type="checkbox" name="hobby">  
足球：<input  value="足球" type="checkbox" name="hobby"> 
排球：<input value="排球"  type="checkbox" name="hobby"> <br><br>

头像：<input type="file" name="file" onchange="preview()"> <br><br>
<input type="submit">
</form>

<div id="preview">


</div>



</body>
</html>