<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看备忘录</title>
</head>
<body>
<p>欢迎你：${userAccount}</p>
<a href="${pageContext.request.contextPath}/user/logout">退出登录</a>
<div>
    <div>
        <ul>
            <li><a href="${pageContext.request.contextPath}/entry/addMemo">新 建</a></li>
            <li><a href="${pageContext.request.contextPath}/memo/lookMemo">查 看</a></li>
            <li><a href="#">修 改</a></li>
            <li><a href="#">删 除</a></li>
        </ul>
    </div>

    <div>
        <c:forEach var="memo" items="${memoList }">
            <div class="show">
                <p>内容：${memo.memoContent }</p>
                <p>账号：${memo.memoAccount }</p>
                <p>密码：${memo.memoPassword }</p>
                <p>备注：${memo.memoNote }</p>
                <p>时间：${memo.memoDate }</p>
            </div>
        </c:forEach>
        <span>${msg}</span>
    </div>
</div>


</body>
</html>
