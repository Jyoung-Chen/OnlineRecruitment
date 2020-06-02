<%@ page import="com.net.javabean.Menu" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Zyoung
  Date: 2019/12/31
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String cssPath=application.getContextPath()+"/css/"; %>
<% String jsPath=application.getContextPath()+"/js/"; %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>嘎嘎嘎</title>
    <link rel="stylesheet" type="text/css" href="<%= cssPath+"home.css"%>">
    <script src="<%= jsPath+"home.js"%>"></script>
</head>

<body>
<div id="header">
    <h2 ><a href="#">人才招聘系统后台管理</a></h2>;
    <div id="headerMenu">
        <p><strong>欢迎你，</strong> ${name}<p><strong>/ </strong></p>
        <a href=../jsp/login.jsp>注销登录</a>
    </div>
</div>
<div id="content">
    <div id="aside">
        <%
            if(request.getAttribute("menu")!=null){
                Map<String, List<Menu>> map1 = (Map<String, List<Menu>>) request.getAttribute("menu");
                for (String key : map1.keySet()) {
                    out.write("<h2 onclick=menuOnClick(this)>" + key + "</h2>");
                    out.write("<div style='display: none'>>");
                    out.write("<ul>");
                    for (Menu menu : map1.get(key)) {
                        out.write("<li><a target='myiframe' href='"+menu.getMenuPath()+"'>" + menu.getThisTitle() + "</a></li>");
                    }
                    out.write("</ul>");
                    out.write("</div>");
                }
            }
        %>
    </div>
    <div id="section" >
        <iframe src="../html/front/welcome.html" id="frame"name="myiframe"></iframe>
    </div>
</div>
<!--<div id="footer">-->
<!--    Copyright © 2019 jmcy chenzeyang-->
<!--</div>-->
</body>
</html>
