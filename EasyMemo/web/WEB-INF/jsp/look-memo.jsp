<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <style>
        .row-custom {
            width: 700px;
            margin: 0 auto;
        }
        .card img {
            width: 48px !important;
        }
    </style>

    <title>查看备忘录</title>
</head>
<body class="bg-light">

<div class="container-fluid">
    <div class="row row-custom mt-3 justify-content-center align-items-center">
        <div class="col text-right">
            <img src="${pageContext.request.contextPath}/statics/img/memo.png" alt="易备">
        </div>
        <div class="col">
            <h4 class="text-muted mt-1">易备系统</h4>
        </div>
    </div>
    <div class="row row-custom mt-3">
        <div class="col-3">
            <div class="card">
                <img class="card-img-top mx-auto d-block mt-3" src="${pageContext.request.contextPath}/statics/img/memo.png" alt="avatar">
                <div class="card-body text-center">
                    <h6 class="card-title mt-n2">${userAccount}</h6>
                    <p class="card-text mt-n1 mb-n2">
                        <small id="nowTime"></small>
                    </p>
                </div>
            </div>
            <div class="list-group mt-3">
                <a href="${pageContext.request.contextPath}/entry/addMemo" class="list-group-item list-group-item-action">新建</a>
                <a href="${pageContext.request.contextPath}/memo/lookMemo" class="list-group-item list-group-item-action active">查看</a>
                <a href="${pageContext.request.contextPath}/user/logout" class="list-group-item list-group-item-action">退出登录</a>
                <a href="#" class="list-group-item list-group-item-action">注销账号</a>
            </div>
        </div>
        <div class="col-9">
            <ul class="list-unstyled">
                <c:forEach var="memo" items="${memoList}">
                    <li class="media mb-4 bg-white p-3 shadow rounded">
                        <img class="mr-3" src="${pageContext.request.contextPath}/statics/img/memo.png" title="易备" alt="头像">
                        <div class="media-body">
                            <div class="row justify-content-between">
                                <div class="col-8">
                                    <h5 class="mt-0 mb-1">${memo.memoContent }</h5>
                                </div>
                                <div class="col-4">
                                    <small class="float-right">
                                        <a href="#">修改</a>
                                        <a href="#" class="ml-2">删除</a>
                                    </small>
                                </div>
                            </div>
                            <p>
                                <small>${userAccount}</small>
                                <small class="float-right">${memo.memoDate }</small>
                            </p>

                            <ul class="list-group">
                                <li class="list-group-item list-group-item-action list-group-item-primary">账号：${memo.memoAccount }</li>
                                <li class="list-group-item list-group-item-action list-group-item-success">密码：${memo.memoPassword }</li>
                                <li class="list-group-item list-group-item-action list-group-item-info">备注：${memo.memoNote }</li>
                            </ul>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
<script src="https://unpkg.com/dayjs@1.8.21/dayjs.min.js"></script>
<script src="https://unpkg.com/dayjs@1.8.21/locale/zh-cn.js"></script>

<script>
    $(function () {
        dayjs.locale('zh-cn')
        setInterval(function () {
            $("#nowTime").html(dayjs().format('YYYY-MM-DD HH:mm:ss dddd'));
        }, 0);
    });
</script>
</body>
</html>
