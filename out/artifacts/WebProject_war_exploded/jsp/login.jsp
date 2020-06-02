<%@ page import="java.util.Calendar" %><%--
  Created by IntelliJ IDEA.
  User: Zyoung
  Date: 2020/1/2
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../css/login.css">
    <script src="../js/jquery-3.4.1.js"></script>
    <script src="../js/login.js"></script>
</head>
<body>

<div id="header">
    <h2>爱我中华招聘系统管理员登录</h2>
</div>

<div id="context" onload="ff()">
    <div id="backGround">
        <img src="../../image/login/1001.jpg" id="image1">
        <img src="../../image/login/1000.jpg" id="image2">
        <div id="backColor"></div>
    </div>
    <div id="Login">

        <div id="div_login">
            <h2>
                <% String data;
                    if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY)>22||Calendar.getInstance().get(Calendar.HOUR_OF_DAY)<4){
                        data="夜深了";
                    }else if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY)>18){
                        data="晚上好";
                    }else if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY)>14){
                        data="下午好";
                    }else if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY)>10){
                        data="中午好";
                    }else if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY)>6){
                        data="早上好";
                    }else if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY)>4){
                        data="清晨了";
                    }else{
                        data="Hi";
                    }
                %>
            <%=data%>
            ,亲爱的管理员</h2>
            <form action="../LoginServlet" method="post">
                <div class="div_input">
                    <label for="AdminNumber">账号：</label>
                    <input type="text" name="AdminNumber" id="AdminNumber" placeholder="请输入账号">
                    <br>
                </div>
                <div class="div_input">
                    <label for="AdminPassword">密码：</label>
                    <input type="password" name="AdminPassword" id="AdminPassword" placeholder="请输入密码">
                </div>
                <input type="submit" id="bt_login" value="立即登录" onclick="return register()  ">
                <br>
            </form>
        </div>
    </div>
</div>

<div id="footer">
    Copyright © 2019 jmcy chenzeyang
</div>
</body>
</html>
