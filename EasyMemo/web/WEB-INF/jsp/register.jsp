<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/login.css">

    <title>易备系统注册</title>

</head>
<body class="bg-light">
<div class="container-fluid">
    <div class="row">
        <div class="col text-center py-4 mt-2">
            <img class="img-fluid" src="${pageContext.request.contextPath}/statics/img/memo.png" alt="易备">
        </div>
    </div>
    <div class="row">
        <div class="col text-center">
            <h4 class="text-dark font-weight-light mt-1">注册一个你的账号</h4>
        </div>
    </div>
    <div class="row row-custom">
        <div class="col">
            <div class="bg-white p-4 mt-3 border rounded">
                <form action="${pageContext.request.contextPath}/user/register" method="post">
                    <div class="form-group">
                        <label for="userAccount" class="text-dark font-weight-bold">手机号</label>
                        <input type="number" class="form-control form-control-sm" id="userAccount" name="phoneNumber"
                               required placeholder="请输入手机号" maxlength="11px">
                    </div>
                    <div class="form-group">
                        <label for="kaptcha" class="text-dark font-weight-bold d-block">验证码</label>
                        <img src="http://localhost:8080/EasyMemo/kaptcha/verify" id="verify" class="rounded-sm float-right" title="看不清？换一张"/>
                        <input type="text" class="form-control form-control-sm w-50" id="kaptcha" name="checkCode"
                               required placeholder="请输入验证码" maxlength="4px">
                    </div>
                    <button type="submit" class="btn rounded-sm btn-primary-custom btn-block btn-sm text-white mt-4">
                        注&nbsp;册
                    </button>
                </form>
            </div>
        </div>
    </div>
    <div class="row mt-3 row-custom">
        <div class="col text-center">
            <div class="border py-3 rounded">
                <span>已注册？直接</span>
                <a href="${pageContext.request.contextPath}/entry/login">登录</a>
            </div>
        </div>
    </div>
</div>
<%--<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>--%>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>

<script>
    $(function () {
        //刷新验证码
        $("#verify").click(function () {
            $(this).attr("src", "http://localhost:8080/EasyMemo/kaptcha/verify");
        });
    });
</script>
</body>
</html>
