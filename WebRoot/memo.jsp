<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>备忘录页面</title>
	<link rel="stylesheet" type="text/css" href="css/memo.css">
	<script>
	function showTime()
	{
	 //创建Date对象
	 var today = new Date();
	 //分别取出年、月、日、时、分、秒
	 var year = today.getFullYear();
	 var month = today.getMonth()+1;
	 var day = today.getDate();
	 var hours = today.getHours();
	 var minutes = today.getMinutes();
	 var seconds = today.getSeconds();
	 //如果是单个数，则前面补0
	 month  = month<10  ? "0"+month : month;
	 day  = day <10  ? "0"+day : day;
	 hours  = hours<10  ? "0"+hours : hours;
	 minutes = minutes<10 ? "0"+minutes : minutes;
	 seconds = seconds<10 ? "0"+seconds : seconds;
	  
	 //构建要输出的字符串
	 var str = year+"-"+month+"-"+day+" "+hours+":"+minutes+":"+seconds;
	  
	 //获取id=nowtime的对象
	 var obj = document.getElementById("nowtime");
	 //将str的内容写入到id=result的<div>中去
	 obj.innerHTML = str;
	 //延时器
	 window.setTimeout("showTime()",1000);
	}
	</script>
  </head>
  
  <body onload="showTime()">
  <div id="div1">
  	<div id="div2">
		<div id="LOGO">
			<img src="img/logo.jpg" alt="logo" title="易备" />	
		</div>
    	<div id="top">
    		<p>当前用户：${sessionScope.userAccount }
    			<a href="login.jsp">退出登录</a>
    		</p>
    		<p>当前时间：<span id="nowtime"></span></p>
    	</div>
    	<div id="bottom">
			<ul>
				<li><a href="memo.jsp" id="active">新 建</a></li>
				<li><a href="LookMemoServlet">查 看</a></li>
				<li><a href="#">修 改</a></li>
				<li><a href="#">删 除</a></li>
			</ul>
    		<br>
    		<form action="MemoServlet" method="post" name="">
    			<p>内容：<input type="text" name="content" placeholder="记录一下是哪个地方要用到的" maxlength="100px"/></p>
    			<p>账号：<input type="text" name="account" placeholder="记录一下账号" maxlength="50px"/></p>
    			<p>密码：<input type="text" name="password" placeholder="记录一下密码" maxlength="50px" /></p>
    			<p>备注：<input type="text" name="note" maxlength="300px"  placeholder="备注~" /></p>
    			<p>时间：<input type="date" class="textinput" name="onetime"/></p>
    			<p id="msg">${save_msg}</p>
    			<input type="submit" id="save" value="保 存"/>
    		</form>
    	</div>
    </div>
  </div>
    
  </body>
</html>
