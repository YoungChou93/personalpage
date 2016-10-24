<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/15
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/jquery-easyui-1.4.4/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/jquery-easyui-1.4.4/themes/icon.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/jquery-easyui-1.4.4/jquery.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/jquery-easyui-1.4.4/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/jquery-easyui-1.4.4/locale/easyui-lang-zh_CN.js"></script>
    <title>管理员主页</title>
    <script type="text/javascript">
        function openTab(text, url) {
            if ($("#tabs").tabs("exists", text)) {
                $("#tabs").tabs("select", text);
            } else {
                var content = "<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='${pageContext.request.contextPath}/admin/"
                        + url + "'></iframe>";
                $("#tabs").tabs("add", {
                    title : text,
                    closable : true,
                    content : content
                });
            }
        }

        $(function() {
                window.setInterval(function () {
                    $.post("${pageContext.request.contextPath}/user/timer.action", function (result) {
                        if( true != result.success ){
                            window.location.href = '${pageContext.request.contextPath}/login.action';
                        }
                        return;
                    },'json');
                }, 30000);
            $("#usertree").tree({
                data : [ {
                    "id" : 1,
                    "text" : "背景管理",
                    "attributes" : "personal.jsp",
                }, {
                    "id" : 2,
                    "text" : "头像管理",
                    "attributes" : "headpicture.jsp",
                }, {
                    "id" : 3,
                    "text" : "访问记录",
                    "attributes" : "visitrecord.jsp",
                },{
                    "id" : 4,
                    "text" : "访问统计",
                    "attributes" : "visittotal.jsp",
                }],
                onClick : function(node) {
                    var tabTitle = node.text;
                    var url = node.attributes;
                    openTab(tabTitle, url);
                }
            });
        });
    </script>
</head>
<body class="easyui-layout">

<div region="center">
    <div id="tabs" class="easyui-tabs" fit="true" border="false">
        <div title="首页" data-options="iconCls:'icon-home'">
            <div align="center" style="padding-top: 100px">
                <img
                        src="${pageContext.request.contextPath}/res/img/logo.png"
                        style="height: 180px; margin-top: -15px;" />
                <p style="font-size:30px;">欢迎您，管理员！</p>
            </div>
        </div>
    </div>
</div>
<div region="west" style="width: 200px" title="管理员" split="true">
    <div id="nvgtmenu" class="easyui-accordion"
         data-options="border:false">
        <div title="用户管理">
            <ul id="usertree">
            </ul>
        </div>
    </div>
</div>

</body>
</html>
