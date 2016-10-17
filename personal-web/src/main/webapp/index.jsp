<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/15
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/bootstrap/js/jquery-2.2.1.min.js"></script>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/templatemo-style.css">
    <title>首页</title>
    <style type="text/css">
        body{
            width: 100%;
            height: 100%;
        }
        .banner {
            background:
                    url(${pageContext.request.contextPath}${personal.photourl})
                    no-repeat center top;
            background-size: cover;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            min-height: 700px;
        }
        .banner p{
            padding-top:5px;
            padding-left:5px;
            font-family:微软雅黑;
            font-size: 1 em;
            color:white;
        }
        .index-bottom {
            background: #555;
            padding: 2em 0;
            text-align: center;
        }


        .index-bottom p {
            font-family:微软雅黑;
            color: #fff;
            font-size: 0.85em;
            margin: 1em 0 0 0;
        }
        h2{
            font-family:微软雅黑;
            color:white;
        }
    </style>
</head>
<body>
<div class="banner">
    <p>${personal.title}</p>
    <div class="container" style="padding:20px;padding-top:30px;">
        <div class="row">
            <div class="col-md-12 text-center">
                <img src="${pageContext.request.contextPath}${headpicture.photourl}" alt="..." class="img-circle" style="width:200px;box-shadow: 3px 2px 2px;">
                <h1>ZhouYang</h1>
            </div>
            <div class="col-md-3 col-xs-3 text-center">
            </div>
            <div class="col-md-1 col-xs-1 text-center">
                <a href="http://weibo.com/zhouyangalan" target="_blank">
                    <img src="${pageContext.request.contextPath}/res/img/weibo.png" alt="..." class="img-circle" style="width:50px;">
                </a>
            </div>

            <div class="col-md-1 col-xs-1 text-center">
                <a href="https://youngzhou.tuchong.com/" target="_blank">
                    <img src="${pageContext.request.contextPath}/res/img/tuchong.jpg" alt="..." class="img-circle" style="width:47px;">
                </a>
            </div>
            <div class="col-md-1 col-xs-1 text-center">
                <a href="http://youngchou93.lofter.com/" target="_blank">
                    <img src="${pageContext.request.contextPath}/res/img/lofter.png" alt="..." class="img-circle" style="width:47px;">
                </a>
            </div>
            <div class="col-md-1 col-xs-1 text-center">
                <a href="https://500px.com/apoorcameraman" target="_blank">
                    <img src="${pageContext.request.contextPath}/res/img/500px.png" alt="..." class="img-circle" style="width:50px;">
            </div>
            <div class="col-md-1 col-xs-1 text-center">
                <a href="https://github.com/YoungChou93" target="_blank">
                    <img src="${pageContext.request.contextPath}/res/img/github.png" alt="..." class="img-circle" style="width:48px;">
            </div>
            <div class="col-md-1 col-xs-1 text-center">
                <a href="http://www.docker.com/" target="_blank">
                    <img src="${pageContext.request.contextPath}/res/img/docker.png" alt="..." class="img-circle" style="width:55px;">
                </a>
            </div>
            <div class="col-md-12 col-xs-12 text-center" style="position:relative;top:50px;">
                <h2 style="text-shadow:2px 2px 2px black;">${personal.description}</h2>
            </div>
        </div>

    </div>
</div>
<div class="container" style="background-color:rgb(228, 232, 246);width:100%;padding-bottom:30px;">
    <div class="row">
        <div class="col-md-12 text-center" style="margin-bottom:20px;padding-top:20px;">
            <h1>City Point</h1>
        </div>
        <div class="col-md-6 col-xs-6 text-right">
            <img src="${pageContext.request.contextPath}/res/img/citypoint1.jpg" alt="..."  style="width:80%;">
        </div>
        <div class="col-md-6 col-xs-6 text-left">
            <img src="${pageContext.request.contextPath}/res/img/citypoint2.jpg" alt="..."  style="width:80%;">
        </div>
        <div class="col-md-12 col-xs-12 text-center" style="margin-top:20px;">
            <a href="http://zhouyangalan.com.cn/point-web" class="btn btn-primary" target="_blank">start with City Point</a>
        </div>
    </div>
</div>
<div class="container" style="background-color:rgb(220, 220, 220);width:100%;padding-bottom:30px;">
    <div class="row">
        <div class="col-md-12 text-center" style="margin-bottom:20px;padding-top:20px;">
            <h1>CUG IN MOTION</h1>
        </div>
        <div class="col-md-6 col-xs-6 text-right">
            <img src="${pageContext.request.contextPath}/res/img/cug1.jpg" alt="..."  style="width:90%;">
        </div>
        <div class="col-md-3 col-xs-3 text-center">
            <img src="${pageContext.request.contextPath}/res/img/cug2.jpg" alt="..."  style="width:88%;">
            <img src="${pageContext.request.contextPath}/res/img/cug3.jpg" alt="..."  style="width:88%;margin-top:9%;">
        </div>
        <div class="col-md-3 col-xs-3 text-left">
            <img src="${pageContext.request.contextPath}/res/img/cug4.jpg" alt="..."  style="width:88%;">
            <img src="${pageContext.request.contextPath}/res/img/cug5.jpg" alt="..."  style="width:88%;margin-top:9%;">
        </div>
        <div class="col-md-12 col-xs-12 text-center" style="margin-top:40px;">
            <a href="http://v.youku.com/v_show/id_XMTU3MzcyMzI0NA==.html?from=s1.8-1-1.2&spm=a2h0k.8191407.0.0" class="btn btn-primary" target="_blank">watch CUG IN MOTION</a>
        </div>


    </div>
</div>
<div class="index-bottom">
    <div class="container">
        <p>您是今天第${today}位访客，总第${total}位！Copyright &copy; 2016.Zhou Yang All rights reserved.</p>
        <p>联系方式：zhouyang.alan@gmail.com</p>
    </div>
</div>



<div id="loader-wrapper">
    <div id="loader"></div>
    <div class="loader-section section-left"></div>
    <div class="loader-section section-right"></div>
</div>
<script>
    $(window).load(function(){
        $('body').addClass('loaded');
    });
</script>
</body>
</html>

