<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>掌方圆商城管理后台</title>
    <link rel="stylesheet" href="/ajax2/font/iconfont.css">
    <link rel="stylesheet" type="text/css" href="/ajax2/css/login.css" />
</head>
<script src="/ajax2/js/jquery.min.js"></script>
<body>
<img src="/ajax2/img/8.jpg" alt="" class="ig1">
<img src="/ajax2/img/login.png" alt="" class="ig2">
<div class="title">
    <span>掌方圆商城管理后台</span>
</div>
<div class="login">
    <div class="form-title">用户登录</div>
    <div class="lin"></div>
       <form id='form1' name='form1' method='post' action=''>
            <ul class="list">
                <li>
                    <span class="iconfont icon-yonghuming logo"></span>
                    <input type="text" name="username" id="username" placeholder="用户名"/>
                    <div class="error"></div>
                </li>
                <li>
                    <span class="iconfont icon-mima logo"></span>
                    <input type="password" name="password" id="password" placeholder="密码"/>
                    <div class="error"></div>
                </li>
            </ul>
           <div type="submit"  class="submit submit2">登 &nbsp;&nbsp;&nbsp;&nbsp;录</div>
       </form>
</div>
</body>
<script>
    $(document).ready(function(){
        var name=false;
        var pass=false;
        var reg = new RegExp("[\\u4E00-\\u9FFF]+","g");
        var reg2= new RegExp("^[a-z]");
/* //用户名校验
        $("#username").blur(function() {
            var that=$('#username').siblings('.error').get(0);
            name=false;
             if($(this).val().trim()===''){
                 that.innerText='用户名不能为空！';
             }else if(reg.test($(this).val())){
                 that.innerText='用户名不能为汉字';
             }
             else{
                 name=true;
                 that.innerText=''
             }
        });
//密码校验
        $("#password").blur(function() {
            var that=$('#password').siblings('.error').get(0);
            pass=false;
            if($(this).val().trim()===''){
                that.innerText='密码不能为空！'
            }else if(reg.test($(this).val())){
                that.innerText='密码不能为汉字';
            }else{
                pass=true;
                that.innerText=''
            }
        }); */
//提交处理
        $('.submit').eq(0).click(function(){
        	alert("aa");
//             if(pass===true&&name===true){
                $.ajax({
                    url:'<%=request.getContextPath() %>/login',
                    type:"POST",
                    data:$('#form1').serialize(),
                    dataType:"json",
                    success: function(data) {
                    	console.log(data);
                        if(data.message=="成功"){
                            $('#password').siblings('.error').get(0).innerText='提交成功！';
                            window.location.href="http://localhost/ajax2/index";
                        }else{
                            $('#password').siblings('.error').get(0).innerText='提交失败！';
                        }
                    }
                });
//             }else{
//                 $('#password').siblings('.error').get(0).innerText='提交失败！';
//             }
        })



    })
</script>
</html>