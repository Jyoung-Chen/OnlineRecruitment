<%@ page import="com.net.dao.UsersDao" %>
<%@ page import="com.net.impl.DaoFactory" %>
<%@ page import="com.net.javabean.Users" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../js/jquery-3.4.1.js"></script>
    <style>
        *{
            user-select: none;
        }
        #userId::-webkit-outer-spin-button,#userId::-webkit-inner-spin-button{
            -webkit-appearance: none !important;
            margin: 0;

        }
        #userId{
            -moz-appearance:textfield;
        }
        input{
            margin-bottom: 20px;
        }
        form{
            margin-left: 40%;
        }
    </style>
</head>
<body>
<h2 align="center">用户编辑页面</h2>
<%
    UsersDao usersImpl= DaoFactory.getUsersImpl();
    Users users;
    int nowPage=1;
    if(request.getParameter("nowPage")!=null){
        nowPage=Integer.parseInt(request.getParameter("nowPage"));
    }
    pageContext.setAttribute("nowsPage",nowPage);
    int userID=1;
    if (request.getParameter("userID")!=null){
        userID=Integer.parseInt(request.getParameter("userID"));
    }
    users=usersImpl.queryDataById(userID);
    pageContext.setAttribute("User",users);
%>
    <br>
    <form <%= "action="+application.getContextPath()+"/UserManagerServlet"%> method="post">
        <input type="hidden" name="nowPage" id="nowPage" value=<%=nowPage%>>
        <input type="hidden" name="oldId" id="oldId" value=<%=users.getUserId()%>>
        <label for="userId" >用户 I D&nbsp;：</label><input type="number" onfocusout="queryById(this)" id="userId" name="userId" value=<%=users.getUserId()%>><label id="tisId" ></label>
        <br>
        <label for="userNumber">用户名称：</label><input type="text" onfocusout="queryByNumber(this)" id="userNumber" name="userNumber" value=<%=users.getUserNumber()%>><label id="tisNumber"></label>
        <br>
        <label for="userPassword">用户密码：</label><input type="password" id="userPassword" name="userPassword" value=<%=users.getUserPassword()%>>
        <br>

        <br> 用戶状态：
        <%
            if (users.getUserStatus()==0){
                out.write("&nbsp;&nbsp;&nbsp;<input type='radio' name='userStatus' value='1' ><label>可用</label>");
                out.write("&nbsp;&nbsp;&nbsp;<input type='radio' name='userStatus' value='0' checked><label>禁用</label>");
            }else{
                out.write("&nbsp;&nbsp;&nbsp;<input type='radio' name='userStatus' value='1' checked><label>可用</label>");
                out.write("&nbsp;&nbsp;&nbsp;<input type='radio' name='userStatus' value='0' ><label>禁用</label>");
            }
        %>

        <br> <input type="submit" onclick="return yanzheng();" value="确认">&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置">
    </form>
</body>
<script>

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
    function queryById(userid) {
        var url="/WebProject/AjaxServlet";
        if ($(userid).val()==""){
            $("#tisId").html("× 请输入用户ID");
            $("#tisId").css("color","red");
        }else{
            $.post(url,{ UserID: $(userid).val()}, function(data, status) {
                var list = $.parseJSON(data);
                console.log("data = " + data);
                console.log("list = " + list);
                var listStr="";
                list.forEach(
                    function (user) {
                        if (user!=null&&user.userId!=$("#oldId").val()) {
                            console.log(user.userId);
                            listStr = "× 用户ID已经存在!!";
                            $("#tisId").css("color","red");
                        }else {
                            listStr = "√ 用户ID可以使用!!";
                            $("#tisId").css("color","green");
                        }
                    }
                );
                $("#tisId").html(listStr);
            });

        }
    }
    function queryByNumber(usernumber) {
        if($(usernumber).val()==""){
            $("#tisNumber").html("× 请输入用户名称");
            $("#tisNumber").css("color", "red");
        }
        else{
            var url = "/WebProject/AjaxServlet";
            $.post(url, {UserNumber: $(usernumber).val()}, function (data, status) {
                var list = $.parseJSON(data);
                console.log("data = " + data);
                console.log("list = " + list);
                var listStr = "";
                list.forEach(
                    function (user) {
                        if (user != null&&user.userId!=$("#oldId").val()) {
                            console.log(user.userId);
                            listStr = "× 用户名称已经存在!!";
                            $("#tisNumber").css("color", "red");
                        } else {
                            listStr = "√ 用户名称可以使用!!";
                            $("#tisNumber").css("color", "green");

                        }
                    }
                );
                $("#tisNumber").html(listStr);
            });
        }
    }
    function yanzheng() {
        if($("#userId").val()!=""&&$("#userNumber").val()!=""&&$("#tisId").html()=="√ 用户ID可以使用!!"&&$("#tisNumber").html()=="√ 用户名称可以使用!!"){
            alert("修改成功");

            return true;
        }else {
            if($("#userId").val()==""||$("#tisId").html()=="× 用户ID已经存在!"){
                alert("用户ID有误");
            }
            if($("#userNumber").val()==""||$("#tisNumber").html()=="× 用户名称已经存在!!"){
                alert("用户名称有误")
            }
            alert("修改失败");
            return false;
        }
    }
</script>
</html>
