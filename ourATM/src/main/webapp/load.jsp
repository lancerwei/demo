<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>登录界面</title>
</head>
<body style="font-size:30px;">
<link rel="stylesheet" href="css/load-page.css"/>
<script>
   window.onload=function(){
	   start();
   }
   function start(){
	   var num = document.getElementById("timer");
	   var i =6000;
	   setInterval(function(){
		   num.innerHTML = i;
		   i--;
		   if(i<0){
			   window.location.href="index-page.html"
		   }
	   },1000);
   }
   function clear1(){
	   document.getElementById("card").value="";
	   document.getElementById("password").value="";
   }
</script>
</head>
<body>
	<form  class="form" action="load" method="post">
	   <div class="head">
	      <img class="logo" src = "image/logo.jpg"/>
	      <img class="upay" src = "image/UnionPay.jpg"/>
	   </div>
		<img class="pic" src="image/pwd.png"/>
		<a href="index-page.html"><input class="exit" type = "button" value="结束交易"/></a>
		<input class="enter" type = "submit" value="确定"/>
		<input class="correct" type = "button" value="更正" onclick="clear1();"/>
		<div class="text">
			请输入您的卡号：<input id="card" name="card" type="text" style="font-size:25px;"/>
			<br/>
			<p></p>
			请输入您的密码：<input id="password" name="password" type="password" style="font-size:25px;"/>
			<p></p>
			<span>倒计时：</span><span id="timer" style="color:red"></span><br/>
			<%
				String msg = (String)request.getAttribute("login_failed");
			%> 
			<span style="color:red;">
			<%=(msg == null ? "" : msg) %>
			</span>
		</div>
	</form>
</body>
</html>