<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>易备系统登录</title>
</head>
<body>
    <p>登录易备系统</p>
    <form action="${pageContext.request.contextPath}/user/login" method="post">
        <div>
            <label for="phoneNumber">手机号：</label>
            <input type="text" id="phoneNumber" name="phoneNumber" required placeholder="请输入手机号" maxlength="11px">
        </div>
        <div>
            <label for="checkCode">验证码：</label>
            <input type="text" id="checkCode" name="checkCode" required placeholder="请输入验证码" maxlength="6px">
            <img src="${pageContext.request.contextPath}/verify" title="看不清？换一张" />
        </div>
        <input type="submit" value="登录">
    </form>
    <span>${msg}</span>
    <p>新用户？<a href="${pageContext.request.contextPath}/entry/register">注册</a></p>
</body>
</html>
