<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>取款界面</title>
<link rel="stylesheet" href="css/withdraw-page.css"/>
<script src="js/jquery-1.11.1.js"></script>
<script>
	function other(){
	 $("#d1").show();
	}
	function f2(){
	 $("#d1").hide();
	}
	function f3(e){
		var money = $(e).val();
		console.log(money);
		var balance = $("#before").val();
		console.log(balance);
		$("#after").val(balance-money);
		console.log(balance-money);
	}
	
</script>
</head>
<body>
	<div class="head">
		<img class="logo" src = "image/logo.jpg"/>
		<img class="upay" src = "image/UnionPay.jpg"/>
	</div>
	<div style="margin:20px 0;font-size:40px;color:red;text-align:center;
		font-family:'微软雅黑','文泉驿正黑','黑体';">请选择取款金额:</div>
	<div class="btns">
		<input class="one" type="button" value="100" onclick="f3(this);"/>
		<input class="three" type="button" value="300" onclick="f3(this);"/>
		<input class="five" type="button" value="500" onclick="f3(this);"/>
		<a href="index-page.html">
		<input class="exit" type="button" value="退卡"/></a>
		<input class="thousand" type="button" value="1000" onclick="f3(this);"/>
		<input class="twoth" type="button" value="2000" onclick="f3(this);"/>
		<input class="other" type="button" value="其它金额" onclick="other();"/>
		<a href="main-page.html"><input class="back" type="button" value="返回"/></a>
	</div>
	<div class="add" id="d1" style="display:none;">
		<p style="text-align:center;">请输入取款金额，并点击确认按钮：</p>
		<input type="text" style="font-size:25px;margin-left:80px;" id=""><br/>
		<p></p>
		<input type="submit" value="确认" style="border:1px solid red;width:100px;height:30px;font-size:20px;margin-left:100px;"/>
		<input type="button" value="取消" style="border:1px solid red;width:100px;height:30px;font-size:20px;margin-left:40px;" onclick="f2()"/>
	</div>
	<form action="withdraw" method="post" >
		取款前余额：<input type="button" id="before" value="<%=request.getAttribute("balance") %>"/>
		取款后余额：<input type="button" id="after" name="balance"/>
		<input type="submit" value="确认取款"/>
	</form>
</body>
</html>