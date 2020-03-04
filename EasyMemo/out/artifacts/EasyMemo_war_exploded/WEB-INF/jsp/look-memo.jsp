<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看备忘录</title>
</head>
<body>
    <c:forEach var="memo" items="${memoList }">
        <div class="show">
            <p>内容：${memo.memoContent }</p>
            <p>账号：${memo.memoAccount }</p>
            <p>密码：${memo.memoPassword }</p>
            <p>备注：${memo.memoNote }</p>
            <p>时间：${memo.memoDate }</p>
        </div>
    </c:forEach>
</body>
</html>
