<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="beans.Memo_User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <title>查看备忘录</title>

	<link rel="stylesheet" type="text/css" href="css/lookmemo.css">
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
				<li><a href="memo.jsp">新 建</a></li>
				<li><a href="LookMemoServlet" id="active">查 看</a></li>
				<li><a href="#">修 改</a></li>
				<li><a href="#">删 除</a></li>
			</ul>
    		<div id="btmdiv">
    			<c:forEach var="memoList" items="${memo_result }">
	   				<div class="show">
	   					<p>内容：${memoList.memo_content }</p>
			   			<p>账号：${memoList.memo_account }</p>
			   			<p>密码：${memoList.memo_password }</p>
			   			<p>备注：${memoList.memo_note }</p>
			   			<p>时间：${memoList.memo_date }</p>
	   				</div>
   				</c:forEach>
    		</div>
    	</div>
    </div>
  </div>
    
  </body>
</html>
