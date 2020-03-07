<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新建备忘录</title>
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
        <form action="${pageContext.request.contextPath}/memo/addMemo" method="post">
            <div>
                <label for="content">内容：</label>
                <input type="text" id="content" name="memoContent" required placeholder="记录一下是哪个地方要用到的" maxlength="100px">
            </div>
            <div>
                <label for="account">账号：</label>
                <input type="text" id="account" name="memoAccount" required placeholder="记录一下账号" maxlength="50px">
            </div>
            <div>
                <label for="password">密码：</label>
                <input type="text" id="password" name="memoPassword" required placeholder="记录一下密码" maxlength="50px">
            </div>
            <div>
                <label for="note">备注：</label>
                <input type="text" id="note" name="memoNote" placeholder="备注~" maxlength="300px">
            </div>
            <div>
                <label for="date">时间：</label>
                <input type="date" id="date" name="memoDate" required>
            </div>
            <input type="submit" id="save" value="保 存"/>
        </form>
        <span>${msg}</span>
    </div>
</div>
</body>
</html>
