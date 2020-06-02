<%--
  Created by IntelliJ IDEA.
  User: Zyoung
  Date: 2020/1/6
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String cssPath= application.getContextPath()+"/css/"; %>
<% String jsPath= application.getContextPath()+"/js/"; %>
<% String htmlPath= application.getContextPath()+"/html/"; %>
<% String jspPath= application.getContextPath()+"/jsp/"; %>
<% String imagePath= application.getContextPath()+"/image/"; %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<a href=<%=jspPath+"userLogin.jsp"%>>账号或密码错误 请点击返回</a>
</body>
</html>