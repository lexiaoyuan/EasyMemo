<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <title>易备系统注册</title>
	<link rel="stylesheet" type="text/css" href="css/register.css">

  </head>
  
  <body>
    <div id="div1">
  		<div id="div2">
			<div id="div3">
  				<p>注册易备系统</p>
  			</div>
			<form method="post" name="register_form" action="">
				<p class="username">手机号：<input name="userAccount"  type="text" placeholder="请输入手机号" maxlength="11px" /></p>
				<span id="msg">${userName_msg}</span>
				<p class="checkcode">验证码：<input type="text" name="checkcode" placeholder="请输入验证码" maxlength="6px"/>
					<img src="MakeCode" alt="验证码" title="验证码" />
					<input type="submit" value="换一张" id="change" onclick="register_form.action='RegisterChangeCode' "/>
				</p>
				<span id="msg">${checkcode_msg}</span>
				<br>
				<input type="submit" value="注 册" id="register" onclick="register_form.action='RegisterServlet'"/>
			</form>    
    	</div>
  	</div>
    
  </body>
</html>