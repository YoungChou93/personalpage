<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/15
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
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
    <title></title>
    <script type="text/javascript">
        function formatStatus(value, row, index) {
            if (true == value) {
                return "启用";
            } else if (false == value) {
                return "禁用";
            }
        }

        function add() {
            $("#add").dialog("open").dialog("setTitle", "添加");
        }
        function savePersonal(){
            if (false == $("#fm").form("validate")){
                return;
            }
            $("#fm").submit();

        }
        function closeAdd() {
            $("#add").dialog("close");

        }
        function deletePersonal() {
            var selectedRows = $("#dg").datagrid('getSelections');
            if (selectedRows.length == 0) {
                $.messager.alert("系统提示", "请选择！");
                return;
            }

            var row = selectedRows[0];
            url = "${pageContext.request.contextPath}/admin/deletePersonal.action";
            $.post(url, {
                id : row.id
            }, function(result) {
                if (true == result.success) {
                    $.messager.alert("系统提示", "删除成功！");
                    $("#dg").datagrid("reload");
                } else {
                    $messager.alert("系统提示","未知错误");
                    return;
                }
            }, "json");

        }
        function enable() {
            var selectedRows = $("#dg").datagrid('getSelections');
            if (selectedRows.length == 0) {
                $.messager.alert("系统提示", "请选择！");
                return;
            }

            var row = selectedRows[0];
            url = "${pageContext.request.contextPath}/admin/enablePersonal.action";
            $.post(url, {
                id : row.id
            }, function(result) {
                if (true == result.success) {
                    $.messager.alert("系统提示", "启用成功！");
                    $("#dg").datagrid("reload");
                } else {
                    $messager.alert("系统提示","未知错误");
                    return;
                }
            }, "json");

        }
        function disable() {
            var selectedRows = $("#dg").datagrid('getSelections');
            if (selectedRows.length == 0) {
                $.messager.alert("系统提示", "请选择！");
                return;
            }

            var row = selectedRows[0];
            url = "${pageContext.request.contextPath}/admin/disablePersonal.action";
            $.post(url, {
                id : row.id
            }, function(result) {
                if (true == result.success) {
                    $.messager.alert("系统提示", "禁用成功！");
                    $("#dg").datagrid("reload");
                } else {
                    $messager.alert("系统提示","未知错误");
                    return;
                }
            }, "json");
        }
        function look(){
            var selectedRows = $("#dg").datagrid('getSelections');
            if (selectedRows.length == 0) {
                $.messager.alert("系统提示", "请选择！");
                return;
            }

            var row = selectedRows[0];
            $("#dlg").dialog("open").dialog("setTitle", "背景图");
            $("#photo").attr("src","${pageContext.request.contextPath}"+row.photourl);

        }
        $(function() {
            $('#dg').datagrid({
                pagination : true,
                rownumbers : true,
                fit : true,
                singleSelect : true,
                url : "${pageContext.request.contextPath}/admin/getPersonals.action",
                loadFilter : function(result) {
                    if (null != result.data) {
                        return result.data;
                    } else {
                        $.messager.alert(result.errormsg, result.errorinfo);
                        return;
                    }
                },
                onDblClickRow : function(rowIndex, rowData) {
                    $("#dlg").dialog("open").dialog("setTitle", "背景图");
                    $("#photo").attr("src","${pageContext.request.contextPath}"+rowData.photourl);
                }

            });
        });

    </script>
</head>
<body>
<table id="dg" title="背景管理" toolbar="#tb">
    <thead>
    <tr>
        <th field="id" width="50" align="center">ID</th>
        <th field="title" width="150" align="center">标题</th>
        <th field="photourl" width="100" align="center" >路径</th>
        <th field="description" width="350" align="center">一句话</th>
        <th field="status" width="100" align="center" formatter="formatStatus">状态</th>
        <th field="uploaddate" width="150" align="center">日期</th>
    </tr>
    </thead>
</table>

<div id="tb">
    <a href="javascript:add()" class="easyui-linkbutton"  iconCls="icon-add" plain="true">添加</a>
    <a href="javascript:deletePersonal()" class="easyui-linkbutton"  iconCls="icon-edit" plain="true">删除</a>
    <a href="javascript:enable()" class="easyui-linkbutton"  iconCls="icon-add" plain="true">启用</a>
    <a href="javascript:disable()" class="easyui-linkbutton"  iconCls="icon-edit" plain="true">禁用</a>
    <a href="javascript:look()" class="easyui-linkbutton"  iconCls="icon-edit" plain="true">查看</a>
</div>
<div id="dlg" class="easyui-dialog" closable="true"
     style="width: 800px; height: 450px; padding: 5px 5px" closed="true"
     buttons="#dlg-buttons" >

<img id="photo" src="" style="width: 100%; height: 100%;"/>

</div>
<div id="add" class="easyui-dialog" closable="false"
     style="width: 270px; height: 200px; padding: 5px 5px" closed="true"
     buttons="#add-buttons" >
    <form id="fm" method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/admin/addPersonal.action">
        <table cellspacing="8px">
            <tr>
                <td>标题：</td>
                <td><input type="text" id="title" name="title"
                           class="easyui-validatebox" style="width: 160px" required="true"/></td>
            </tr>
            <tr>
                <td>描述：</td>
                <td><textarea name="description" id="description" class="easyui-validatebox" required="true" style="width: 160px"></textarea></td>
            </tr>
            <tr>
                <td>照片：</td>
                <td><input  type="file" name="file" id="" accept=".jpg" style="width: 160px"></td>
            </tr>


        </table>
    </form>

</div>
<div id="add-buttons">
    <a href="javascript:savePersonal()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a>
    <a href="javascript:closeAdd()"
       class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>
</body>
</html>
