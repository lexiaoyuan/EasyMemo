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

    <title>新建备忘录</title>
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
                <a href="${pageContext.request.contextPath}/entry/addMemo" class="list-group-item list-group-item-action active">新建</a>
                <a href="${pageContext.request.contextPath}/memo/lookMemo" class="list-group-item list-group-item-action">查看</a>
                <a href="${pageContext.request.contextPath}/user/logout" class="list-group-item list-group-item-action">退出登录</a>
                <a href="#" class="list-group-item list-group-item-action">注销账号</a>
            </div>
        </div>
        <div class="col-9">
            <h4>新建备忘录</h4>
            <form action="${pageContext.request.contextPath}/memo/addMemo" method="post">
                <div class="form-group mt-3">
                    <label for="content">内容</label>
                    <input type="text" id="content" class="form-control" name="memoContent" required placeholder="记录一下是哪个地方要用到的" maxlength="100px">
                </div>
                <div class="form-group">
                    <label for="account">账号</label>
                    <input type="text" id="account" class="form-control" name="memoAccount" required placeholder="记录一下账号" maxlength="50px">
                </div>
                <div class="form-group">
                    <label for="password">密码：</label>
                    <input type="text" id="password" class="form-control" name="memoPassword" required placeholder="记录一下密码" maxlength="50px">
                </div>
                <div class="form-group">
                    <label for="note">备注：</label>
                    <input type="text" id="note" class="form-control" name="memoNote" placeholder="备注~" maxlength="300px">
                </div>
                <div class="form-group">
                    <label for="date">时间：</label>
                    <input type="text" id="date" class="form-control" name="memoDate" required>
                </div>
                <button type="submit" class="btn btn-primary btn-block mb-2">保&nbsp;存</button>
            </form>
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
<script src="https://www.layuicdn.com/layDate/laydate.js"></script>

<script>
    $(function () {
        dayjs.locale('zh-cn')
        setInterval(function () {
            $("#nowTime").html(dayjs().format('YYYY-MM-DD HH:mm:ss dddd'));
        }, 0);
    });

    laydate.render({
        elem: '#date'
        , value: dayjs().format('YYYY-MM-DD')
    });
</script>
</body>
</html>
