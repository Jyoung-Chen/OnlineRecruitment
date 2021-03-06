<%@ page  import="java.util.List" %>
<%@ page  import="com.net.javabean.Users" %>
<%@ page  import="com.net.impl.DaoFactory" %>
<%@ page import="com.net.dao.EnterpriseDao" %>
<%@ page import="com.net.javabean.Enterprises" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<% String cssPath= application.getContextPath()+"/css/"; %>
<% String jsPath= application.getContextPath()+"/js/"; %>
<% String htmlPath= application.getContextPath()+"/html/"; %>
<% String jspPath= application.getContextPath()+"/jsp/"; %>
<% String imagePath= application.getContextPath()+"/image/"; %>
<%
    int pageNum=5;
    int rowCount = 0;
    int pageCount=0;
    int nowPage=1;
    EnterpriseDao enterprise=DaoFactory.getEnterpriseImpl();
    rowCount=enterprise.findCount();
    pageCount = rowCount / pageNum;
    if (rowCount % pageNum != 0) {
        pageCount +=  1;
    }
    String requestPage = request.getParameter("page");
    if(requestPage!=null){
        nowPage=Integer.valueOf(requestPage);
        if (nowPage < 1) {
            nowPage = 1;
        }
        if (nowPage >pageCount) {
            nowPage = pageCount;
        }
    }
    List<Enterprises> list=enterprise.findEnterprise(nowPage,pageNum);
    pageContext.setAttribute("list", list);
%>


<html>
<head>
    <title>企业管理</title>
    <link rel="stylesheet" href="../css/userManger.css">
    <meta charset="UTF-8">
    <style>
        *{
            margin: 0px;
            padding: 0px;
            background-color: #EEEEEE;
            user-select:none;
        }
        table,td,tr,th{
            height: 55px;
            font-size: 20px;
        }
        button{
            font-size: 18px;
            color: black;
            margin-right: 4%;
            cursor: pointer;
        }
        button:hover{
            font-size: 20px;
        }
    </style>
    <script src=<%=jsPath+"jquery-3.4.1.js"%>></script>
    <script type="text/javascript">
        function gotoEditPage(enterpriseID,nowPage) {
            // window.location.href = $("#jspPathInput").val()+"user_edit.jsp?userID=" + userID;
            window.location.href = "<%=jspPath%>enterprise_edit.jsp?nowPage="+nowPage+"&&enterpriseID=" + enterpriseID;
        }
        function deleteEnterprise(enterpriseID,nowPage) {
            var url="/WebProject/DeleteEnterpriseServlet";
            if(confirm("确定删除？")){
                $.post(url,{ EnterpriseID: enterpriseID}, function(data, status) {
                    var list = $.parseJSON(data);
                    console.log("data = " + data);
                    console.log("status = " + status);
                    if (status=="success"){
                        alert("删除成功");
                        window.location.href = "<%=jspPath%>enterpriseManager.jsp?page="+nowPage;
                    }else {
                        alert("删除失败");
                    }
                });
            }
        }

        function setUpEnterprise(enterpriseID,nowPage) {
            var url="/WebProject/SetEStatusServlet";
            if(confirm("确定启用？")){
                $.post(url,{EnterpriseID: enterpriseID,Status:'1'}, function(data, status) {
                    var list = $.parseJSON(data);
                    console.log("data = " + data);
                    console.log("status = " + status);
                    if (status=="success"){
                        alert("已启用");
                        window.location.href = "<%=jspPath%>enterpriseManager.jsp?page="+nowPage;
                    }else {
                        alert("启用失败");
                    }
                });
            }
        }

        function setDownEnterprise(enterpriseID,nowPage) {
            var url="/WebProject/SetEStatusServlet";
            if(confirm("确定禁用？")){
                $.post(url,{ EnterpriseID: enterpriseID,Status:'0'}, function(data, status) {
                    var list = $.parseJSON(data);
                    console.log("data = " + data);
                    console.log("status = " + status);
                    if (status=="success"){
                        alert("已禁用");
                        window.location.href = "<%=jspPath%>enterpriseManager.jsp?page="+nowPage;
                    }else {
                        alert("禁用失败");
                    }
                });
            }
        }

        function createXHR() {
            if(typeof XMLHttpRequest!='undefined')
            {
                return new XMLHttpRequest();
            }else if(typeof ActiveXObject != 'undefined'){
                var versions = [
                    'MSXML2.XMLHttp.6.0',
                    'MSXML2.XMLHttp.3.0',
                    'MSXML2.XMLHttp'
                ];
                for (var i = 0; i < versions.length; i ++) {
                    try {
                        return new ActiveXObject(version[i]);
                    } catch (e) {

                    }
                }
            }else {
                throw new Error('您的浏览器不支持XHR对象！');
            }
        }

    </script>
</head>
<body >
<h2 align="center">企业管理界面</h2>
<br>
<center>
    <table border="0" align="center" width="80%" cellspacing="0">
        <tr>
            <th align="center" width="40%"><input id="searchText" type="text" width="100%" height="25px" style="border: solid 1px black;height: 25px;width: 50%" /></th>
            <th align="left" width="20%"><a href="user_insert.jsp">新增</a></th>
            <th align="left" width="20%"><a href="user_edit.jsp">删除</a></th>
            <th align="left" width="20%"><a href="user_manger.jsp">查询</a></th>
        </tr>
    </table>
    <br><br>
    <table id="userTable" border="1" align="center" width="80%" cellspacing="0" cellpadding="10" >
        <tr style="line-height: 30px;font-size: 20px;">
            <th style="width: 10%">企业ID</th><th style="width: 25%">企业名称</th><th style="width: 25%">企业密码</th><th style="width: 10%">企业状态</th><th style="width: 30%">操作</th>
        </tr>
        <%
            for (Enterprises enterprises:list) {
                out.write("<tr align='center' ondblclick='gotoEditPage("+enterprises.getEnterpriseId()+","+nowPage+")'>");
                if(enterprises.getEnterpriseStatus()==1) {
                    out.write("<td>" + enterprises.getEnterpriseId() + "</td><td>" + enterprises.getEnterpriseName() + "</td><td>" + enterprises.getEnterprisePassword()+ "</td><td>可用</td>");
                }else {
                    out.write("<td>" + enterprises.getEnterpriseId() + "</td><td>" + enterprises.getEnterpriseName() + "</td><td>" + enterprises.getEnterprisePassword()+ "</td><td>禁用</td>");
                }
                out.write("<td><button style='color: blue' onclick='gotoEditPage("+enterprises.getEnterpriseId()+","+nowPage+")'>编辑</button>&nbsp;&nbsp;&nbsp;");
                out.write("<button style='color: blue' onclick='deleteEnterprise("+enterprises.getEnterpriseId()+","+nowPage+")'>删除</button>&nbsp;&nbsp;&nbsp;");
                if(enterprises.getEnterpriseStatus()==1) {
                    out.write("<button disabled='disabled'>启用</button>&nbsp;&nbsp;&nbsp;");
                    out.write("<button style='color: red' onclick='setDownEnterprise("+enterprises.getEnterpriseId()+","+nowPage+")'>禁用</button></td>");
                }else {
                    out.write("<button style='color: green' onclick='setUpEnterprise("+enterprises.getEnterpriseId()+","+nowPage+")'>启用</button>&nbsp;&nbsp;&nbsp;");
                    out.write("<button disabled='disabled'>禁用</button></td>");
                }
                out.write("</tr>");
            }
        %>
    </table>
    <br>
    <%
        if (nowPage>1){
            out.write("<a href='"+jspPath+"enterpriseManager.jsp?page="+(nowPage - 1)+"'>上一页</a>");
        }else {
            out.write("上一页");
        }
        out.write("&nbsp;&nbsp;&nbsp; 第"+nowPage+"页 / 共"+pageCount+"页 &nbsp;&nbsp;&nbsp;");
        if (nowPage< pageCount){
            out.write("<a href='"+jspPath+"enterpriseManager.jsp?page="+(nowPage + 1)+"'>下一页</a>");
        }else {
            out.write("下一页");
        }
    %>
</center>
</body>
</html>

