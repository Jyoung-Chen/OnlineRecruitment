
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String cssPath= application.getContextPath()+"/css/"; %>
<% String jsPath= application.getContextPath()+"/js/"; %>
<% String htmlPath= application.getContextPath()+"/html/"; %>
<% String jspPath= application.getContextPath()+"/jsp/"; %>
<% String imagePath= application.getContextPath()+"/image/"; %>
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
<center><h2>添加用户</h2></center>
        <form action="" method="post">
            <label for="userId" >用户 I D&nbsp;：</label><input type="number" onfocusout="queryById(this)" id="userId" name="userId"><label id="tisId" ></label>
            <br>
            <label for="userNumber">用户名称：</label><input type="text" onfocusout="queryByNumber(this)" id="userNumber" name="userNumber"><label id="tisNumber"></label>
            <br>
            <label for="userPassword">用户密码：</label><input type="password" id="userPassword" name="userPassword">
            <br>
            <label>用户状态：</label>
            &nbsp;&nbsp;&nbsp;<input type='radio' name='userStatus' value='1' checked><label>可用</label>
            &nbsp;&nbsp;&nbsp;<input type='radio' name='userStatus' value='0' ><label>禁用</label>
            <br>
            <input type="submit" value="添加用户" onclick="return yanzheng();"><% for (int i=0;i<15;i++){ out.write("&nbsp;");}%><input type="reset" value="重置数据">
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
                    if (user!=null) {
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
                        if (user != null) {
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
            alert("添加成功");

            return true;
        }else {
            if($("#userId").val()==""||$("#tisId").html()=="× 用户ID已经存在!"){
                alert("用户ID有误");
            }
            if($("#userNumber").val()==""||$("#tisNumber").html()=="× 用户名称已经存在!!"){
                alert("用户名称有误")
            }
            alert("添加失败");
            return false;
        }
    }
</script>
</html>
