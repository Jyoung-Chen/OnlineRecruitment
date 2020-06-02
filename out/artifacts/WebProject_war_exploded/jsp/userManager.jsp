<%@ page import="java.util.List" %>
<%@ page import="com.net.javabean.Users" %>
<%@ page import="com.net.dao.DaoFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<Users> list= DaoFactory.getUsersImpl().findUser(1,5);
    for (Users users:list){
        out.write(users.toString());
    }
%>
</body>
</html>
