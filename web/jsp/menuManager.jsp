
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% String cssPath= application.getContextPath()+"/css/"; %>
<% String jsPath= application.getContextPath()+"/js/"; %>
<% String htmlPath= application.getContextPath()+"/html/"; %>
<% String jspPath= application.getContextPath()+"/jsp/"; %>
<% String imagePath= application.getContextPath()+"/image/"; %>

<html>
<head>
    <title>菜单管理</title>
</head>
<body >
<input type="hidden" value=<%=jspPath%> id="jspPathInput">
<h2 align="center">菜单管理</h2>
</body>
</html>
