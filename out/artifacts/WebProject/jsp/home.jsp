<%@ page import="com.net.javabean.Menu" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% String cssPath= application.getContextPath()+"/css/"; %>
<% String jsPath= application.getContextPath()+"/js/"; %>
<% String htmlPath= application.getContextPath()+"/html/"; %>
<% String jspPath= application.getContextPath()+"/jsp/"; %>
<% String imagePath= application.getContextPath()+"/image/"; %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>后台管理系统</title>
    <link rel="stylesheet"  href="<%= cssPath+"home.css"%>">
    <script src="<%= jsPath+"home.js"%>"></script>
    <script src=<%=jsPath+"jquery-3.4.1.js"%>></script>
</head>

<body>
<div id="header">
    <h2 ><a >人才招聘系统后台管理</a></h2>;
    <div id="headerMenu">
        <p><strong>欢迎你，</strong> ${name}<p><strong>/ </strong></p>
        <a <%="href='"+jspPath+"login.jsp'"%>>注销登录</a>
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
                        out.write("<li><a target='myiframe' href='"+ jspPath+menu.getMenuPath()+"'>" + menu.getThisTitle() + "</a></li>");
                    }
                    out.write("</ul>");
                    out.write("</div>");
                }
            }
        %>
    </div>
    <div id="section" >
        <iframe <%="src='"+htmlPath+"front/welcome.html'"%> id="frame"name="myiframe"></iframe>
    </div>
</div>

</body>
</html>
