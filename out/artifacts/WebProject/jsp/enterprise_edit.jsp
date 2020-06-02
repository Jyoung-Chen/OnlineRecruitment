<%@ page import="com.net.dao.UsersDao" %>
<%@ page import="com.net.impl.DaoFactory" %>
<%@ page import="com.net.javabean.Users" %>
<%@ page import="com.net.dao.EnterpriseDao" %>
<%@ page import="com.net.javabean.Enterprises" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../js/jquery-3.4.1.js"></script>
    <style>
        *{
            user-select: none;
        }
        #enterprisesId::-webkit-outer-spin-button,#userId::-webkit-inner-spin-button{
            -webkit-appearance: none !important;
            margin: 0;

        }
        #enterprisesId{
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
<h2 align="center">企业编辑页面</h2>
<%
    EnterpriseDao enterprise=DaoFactory.getEnterpriseImpl();
    Enterprises enterprises;
    int nowPage=1;
    if(request.getParameter("nowPage")!=null){
        nowPage=Integer.parseInt(request.getParameter("nowPage"));
    }
    pageContext.setAttribute("nowsPage",nowPage);
    int enterpriseID=1;
    if (request.getParameter("enterpriseID")!=null){
        enterpriseID=Integer.parseInt(request.getParameter("enterpriseID"));
    }
    enterprises=enterprise.queryDataById(enterpriseID);
    pageContext.setAttribute("Enterprise",enterprises);
%>
<br>
<form <%= "action="+application.getContextPath()+"/EnterpriseManagerServlet"%> method="post">
    <input type="hidden" name="nowPage" id="nowPage" value=<%=nowPage%>>
    <input type="hidden" name="oldId" id="oldId" value=<%=enterprises.getEnterpriseId()%>>
    <label for="enterprisesId" >用户 I D&nbsp;：</label><input type="number" onfocusout="queryById(this)" id="enterprisesId" name="enterprisesId" value=<%=enterprises.getEnterpriseId()%>><label id="tisId" ></label>
    <br>
    <label for="enterprisesNumber">用户名称：</label><input type="text" onfocusout="queryByNumber(this)" id="enterprisesNumber" name="enterprisesNumber" value=<%=enterprises.getEnterpriseName()%>><label id="tisNumber"></label>
    <br>
    <label for="enterprisesPassword">用户密码：</label><input type="password" id="enterprisesPassword" name="enterprisesPassword" value=<%=enterprises.getEnterprisePassword()%>>
    <br>

    <br> 用戶状态：
    <%
        if (enterprises.getEnterpriseStatus()==0){
            out.write("&nbsp;&nbsp;&nbsp;<input type='radio' name='enterprisesStatus' value='1' ><label>可用</label>");
            out.write("&nbsp;&nbsp;&nbsp;<input type='radio' name='enterprisesStatus' value='0' checked><label>禁用</label>");
        }else{
            out.write("&nbsp;&nbsp;&nbsp;<input type='radio' name='enterprisesStatus' value='1' checked><label>可用</label>");
            out.write("&nbsp;&nbsp;&nbsp;<input type='radio' name='enterprisesStatus' value='0' ><label>禁用</label>");
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
    function queryById(enterpriseid) {
        var url="/WebProject/AjaxEServlet";
        if ($(enterpriseid).val()==""){
            $("#tisId").html("× 请输入企业ID");
            $("#tisId").css("color","red");
        }else{
            $.post(url,{ EnterpriseID: $(enterpriseid).val()}, function(data, status) {
                var list = $.parseJSON(data);
                console.log("data = " + data);
                console.log("list = " + list);
                var listStr="";
                list.forEach(
                    function (enterprise) {
                        if (enterprise!=null&&enterprise.enterpriseId!=$("#oldId").val()) {
                            console.log(enterprise.enterpriseId);
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
    function queryByNumber(enterprisenumber) {
        if($(enterprisenumber).val()==""){
            $("#tisNumber").html("× 请输入用户名称");
            $("#tisNumber").css("color", "red");
        }
        else{
            var url = "/WebProject/AjaxEServlet";
            $.post(url, {EnterpriseNumber: $(enterprisenumber).val()}, function (data, status) {
                var list = $.parseJSON(data);
                console.log("data = " + data);
                console.log("list = " + list);
                var listStr = "";
                list.forEach(
                    function (enterprise) {
                        if (enterprise != null&&enterprise.enterpriseId!=$("#oldId").val()) {
                            console.log(enterprise.enterpriseId);
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
        if($("#enterprisesId").val()!=""&&$("#enterprisesNumber").val()!=""&&$("#tisId").html()=="√ 用户ID可以使用!!"&&$("#tisNumber").html()=="√ 用户名称可以使用!!"){
            alert("修改成功");
            return true;
        }else {
            if($("#enterprisesId").val()==""||$("#tisId").html()=="× 用户ID已经存在!"){
                alert("用户ID有误");
            }
            if($("#enterprisesNumber").val()==""||$("#tisNumber").html()=="× 用户名称已经存在!!"){
                alert("用户名称有误")
            }
            alert("修改失败");
            return false;
        }
    }
</script>
</html>