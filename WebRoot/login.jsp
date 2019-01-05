<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <title>易备系统登录</title>
    <meta charset="UTF-8" />
	<link rel="stylesheet" type="text/css" href="css/login.css">
  </head>
  
  <body>
    <div id="div1">
  		<div id="div2">
  			<div id="div3">
  				<p>登录易备系统</p>
  			</div>
  			<form method="post" name="login_form" action="">
	    		<p class="username">手机号：<input name="userAccount"  type="text" placeholder="请输入手机号" maxlength="11px" /></p>
	    		<span id="msg">${userName_msg}</span>
	    		<p class="checkcode">验证码：<input type="text" name="checkcode" placeholder="请输入验证码" maxlength="6px"/>
	    			<img src="MakeCode" alt="验证码" title="验证码" />
	    			<input type="submit" value="换一张" id="change" onclick="login_form.action='LoginChangeCode' "/>
	    		</p>
	    		<span id="msg">${checkcode_msg}</span>
	    		<br>
	    		<input class="login" type="submit" value="登 录" onclick="login_form.action='LoginServlet'"/>
	    		<a href="register.jsp">注册</a>
    		</form>
  		</div>
    </div>
  </body>
</html>
