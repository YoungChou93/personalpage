<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/15
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <!-- 针对移动设备，为了确保适当的绘制和触屏缩放 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/bootstrap/js/jquery-2.2.1.min.js"></script>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/res/css/style.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <title>登录</title>
    <style type="text/css">
        html, body {
            font-size: 100%;
        }

        .banner {
            background-color:rgb(150,200,150);
            background-size: cover;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            min-height: 700px;
        }

        .banner-top {
            position:relative;
            top:150px;
            width: 30%;
            padding: 20px 40px;
            background: rgba(228, 232, 246, 0.56);
            margin: 0 auto;
            min-width: 250px;
        }

        .bnr-left {
            width: 60%;
            float: left;
        }

        .bnr-right {
            width: 40%;
            float: right;
        }

    </style>
</head>
<body>
<div class="banner">
    <div class="container">
        <div class="banner-top">
          <h1 class="text-center">Admin Login</h1>
            <div class="tab-content" align="center">
                <%--<img src="${pageContext.request.contextPath}/res/img/logo.png"
                     style="height: 90px; text-align: center;" />--%>

                <div class="tab-pane fade in active" id="login">

                    <font color="red">${errorMsg}</font>
                    <form class="form-horizontal" method="post" style="margin: 20px;"
                          action="${pageContext.request.contextPath}/user/login.action">
                        <div class="form-group">
                            <input type="text" name="email" class="form-control"
                                   id="inputEmail" placeholder="Email" value="${userCustom.email}">
                        </div>
                        <div class="form-group">
                            <input type="password" name="password" class="form-control"
                                   id="inputPassword" placeholder="Password">
                        </div>
                        <div class="form-group">
                            <div class="bnr-left">
                                <img
                                        src="${pageContext.request.contextPath}/user/getVerifyCode.action"
                                        id="loginVerifyCode" /> <a
                                    href="javascript:changeLoginVerifyCode()">换张图</a>
                            </div>
                            <div class="bnr-right">
                                <input type="text" name="verifyCode" class="form-control"
                                       placeholder="VerifyCode">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary btn-block">登录</button>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>

<script type="text/javascript">
    /*
     * 换一张验证码
     */
    function changeLoginVerifyCode() {
        /*
         * 1. 获取<img>元素
         * 2. 重新设置它的src
         * 3. 使用毫秒来添加参数
         */
        $("#loginVerifyCode").attr(
                "src",
                "${pageContext.request.contextPath}/user/getVerifyCode.action?a="
                + new Date().getTime());

    }

</script>
</body>
</html>
