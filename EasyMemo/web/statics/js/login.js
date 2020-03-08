$(function () {
    //刷新验证码
   $("#verify").click(function () {
      $(this).attr('src', 'kaptcha/verify');
   });
});