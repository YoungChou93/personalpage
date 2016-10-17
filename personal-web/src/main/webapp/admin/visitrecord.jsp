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
        $(function() {
            $('#dg').datagrid({
                pageSize: 30,
                pagination : true,
                rownumbers : true,
                fit : true,
                singleSelect : true,
                url : "${pageContext.request.contextPath}/admin/getVisitRecords.action",
                loadFilter : function(result) {
                    if (null != result.data) {
                        return result.data;
                    } else {
                        $.messager.alert(result.errormsg, result.errorinfo);
                        return;
                    }
                }
            });
        });
    </script>
</head>
<body>

<table id="dg"  toolbar="#tb">
    <thead>
    <tr>
        <th field="id" width="150" align="center">ID</th>
        <th field="ipaddr" width="150" align="center">IP</th>
        <th field="date" width="150" align="center" >日期</th>
    </tr>
    </thead>
</table>

</body>
</html>
