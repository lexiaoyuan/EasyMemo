<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>易备系统</title>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
    <script>
      $(function () {
        $("#app").load("${pageContext.request.contextPath}/memo/lookMemo");
      });
    </script>
  </head>
  <body>
  <div id="app"></div>
  </body>
</html>
