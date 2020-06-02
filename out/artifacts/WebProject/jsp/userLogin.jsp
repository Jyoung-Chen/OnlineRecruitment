<%@ page import="com.net.impl.DaoFactory" %>
<%@ page import="java.util.List" %>
<%@ page import="com.net.javabean.Resumes" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<% String cssPath= application.getContextPath()+"/css/"; %>
<% String jsPath= application.getContextPath()+"/js/"; %>
<% String htmlPath= application.getContextPath()+"/html/"; %>
<% String jspPath= application.getContextPath()+"/jsp/"; %>
<% String imagePath= application.getContextPath()+"/image/userLogin/"; %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>用户登录</title>
    <link type="text/css" rel="stylesheet" href=<%=cssPath+"bootstrap.css"%>>
    <link type="text/css" rel="stylesheet" href=<%=cssPath+"bootstrap-theme.css"%>>
    <script type="text/javascript" src=<%=jsPath+"jquery-3.4.1.js"%>></script>
    <script type="text/javascript" src=<%=jsPath+"bootstrap.min.js"%>></script>
    <script type="text/javascript" src=<%=jsPath + "json2.js"%>></script>
    <script type="text/javascript" src=<%=jsPath + "userLogin.js"%>></script>
</head>
<body>
    <div class="container-fluid" style="margin-top: 20px">
        <div class="row clearfix">
            <div class="col-md-1 column"></div>
            <div class="col-md-10 column">
                <%--导航栏--%>
                <nav class="navbar navbar-default" role="navigation">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="">首 页</a>
                    </div>

                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link active" data-toggle="pill" href="#home">热门岗位</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="pill" href="#menu1">简历信息</a>
                            </li>
                        </ul>
                        <form class="navbar-form navbar-left" role="search">
                            <div class="form-group">
                                <label for="form-control">岗位搜索 :&nbsp;</label>
                                <input type="text" class="form-control" id="form-control" placeholder="请输入要查询的岗位" />
                            </div> <button type="submit" class="btn btn-default">查询</button>
                        </form>
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="#">最新消息</a>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><div style="width: 20px;height: 20px;border-radius: 10px"><img style="width: 20px;height: 20px;border-radius: 10px" <%="src='"+imagePath+"user.png'"%>></div></a>
                                <%
                                    if(request.getAttribute("name")!=null){
                                        out.write("<ul class='dropdown-menu'>");
                                        out.write("<li><a href='#'>修改密码</a></li>");
                                        out.write("<li><a href='#'>个人信息</a></li>");
                                        out.write("<li><a href='#'>我的收藏</a></li>");
                                        out.write("<li class='divider'></li>");
                                        out.write("<li><a style='color: red' href='"+jspPath+"userLogin.jsp'>注销</a></li></ul>");
                                    }
                                %>
                            </li>
                        </ul>
                    </div>
                 </nav>
                <%--图片轮播--%>
                <div class="carousel slide" id="carousel-140165">
                    <ol class="carousel-indicators">
                        <li class="active" data-slide-to="0" data-target="#carousel-140165">
                        </li>
                        <li data-slide-to="1" data-target="#carousel-140165">
                        </li>
                        <li data-slide-to="2" data-target="#carousel-140165">
                        </li>
                        <li data-slide-to="3" data-target="#carousel-140165">
                        </li>
                        <li data-slide-to="4" data-target="#carousel-140165">
                        </li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="item active">
                            <img alt="" <%="src='"+imagePath+"slide-1.png'"%>/>
                            <div class="carousel-caption">
                            </div>
                        </div>
                        <div class="item">
                            <img alt="" <%="src='"+imagePath+"slide-2.png'"%>/>
                            <div class="carousel-caption">
                            </div>
                        </div>
                        <div class="item">
                            <img alt="" <%="src='"+imagePath+"slide-3.png'"%>/>
                            <div class="carousel-caption">
                            </div>
                        </div>
                        <div class="item">
                            <img alt="" <%="src='"+imagePath+"slide-4.png'"%>/>
                            <div class="carousel-caption">
                            </div>
                        </div>
                        <div class="item">
                            <img alt="" <%="src='"+imagePath+"slide-5.png'"%>/>
                            <div class="carousel-caption">
                            </div>
                        </div>
                    </div> <a class="left carousel-control" href="#carousel-140165" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-140165" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
                </div>
            </div>
            <div class="col-md-1 column"></div>
        </div>
        <!-- Tab panes -->
        <div class="tab-content">
            <%--第一个--%>
            <div class="tab-pane active container" id="home">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <div class="row clearfix">
                            <%--列表--%>
                            <div class="col-md-7 column">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>岗位ID</th>
                                        <th>岗位名称</th>
                                        <th>岗位要求</th>
                                        <th>岗位薪资</th>
                                        <th>岗位热度</th>
                                    </tr>
                                    </thead>
                                    <tbody id="tb">
                                    </tbody>
                                </table>
                            </div>
                            <%--登录表单--%>
                            <div class="col-md-4 column" style="margin: 20px auto auto 5%;border: solid 2px gray; border-radius: 30px;padding-top: 20px">
                                <form class="form-horizontal" role="form" <%="action='"+application.getContextPath()+"/UserLoginServlet'"%> method="post" >
                                    <h2 align="center"style="margin-bottom: 50px">用户登录</h2>
                                    <div class="form-group">
                                        <label for="userNumber" class="col-sm-3 control-label">账号:</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="userNumber" name="userNumber" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="userPassword" class="col-sm-3 control-label">密码:</label>
                                        <div class="col-sm-9">
                                            <input type="password" class="form-control" id="userPassword" name="userPassword"  />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-offset-3 col-sm-10" style="margin-top: 25px">
                                            <button type="submit" class="btn btn-default" onclick="return register()">立即登录</button>
                                            <button type="button" class="btn btn-default" >忘记密码</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%--第二个--%>
            <div class="tab-pane container" id="menu1">
                <div class="row clearfix">
                    <div class="col-md-12 column">

                        <div class="row clearfix" style="margin-top: 30px">
                            <%
                                int userID=DaoFactory.getUsersImpl().queryDataByNumber(request.getAttribute("name").toString()).getUserId();
                                List<Resumes> list=DaoFactory.getResumesImpl().findResumes(userID);
                                int i=1;

                                for ( Resumes resumes:list){
                            %>
                            <%--简历i--%>
                            <div class="col-md-4 column">
                                <a id="modal-399276" style="background-color: wheat;border-radius: 20px;width: 80%;line-height: 200px;font-size: 35px;" href="#modal-container-399276" role="button" class="btn" data-toggle="modal">我的简历<%=i%></a>
                                <div class="modal fade" id="modal-container-399276" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                                <h4 class="modal-title" id="myResume1">
                                                    简历<%=i%>
                                                </h4>
                                            </div>
                                            <div class="modal-body">
                                                <div class="row clearfix">
                                                    <div class="col-md-12 column">
                                                        <form class="form-horizontal" role="form">
                                                            <div class="form-group">
                                                                <label for="inputName1" class="col-sm-2 control-label">姓名：</label>
                                                                <div class="col-sm-10">
                                                                    <input type="text" class="form-control" id="inputName1"<%="value='"+resumes.getResumeName()+"'"%> />
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-2 control-label">性别：</label>
                                                                <% if(resumes.getResumeSex()==1){%>
                                                                    <div class="col-sm-10">
                                                                        <input type="radio" class="col-sm-1" style="margin-top: 10px" name="inputSex"value="1" checked/><label class="col-sm-1 control-label">男</label>
                                                                        <input type="radio" class="col-sm-1" style="margin-top: 10px" name="inputSex"value="0"/><label class="col-sm-1 control-label">女</label>
                                                                    </div>
                                                                <%
                                                                    } else{
                                                                %>
                                                                    <div class="col-sm-10">
                                                                        <input type="radio" class="col-sm-1" style="margin-top: 10px" name="inputSex"value="1" /><label class="col-sm-1 control-label">男</label>
                                                                        <input type="radio" class="col-sm-1" style="margin-top: 10px" name="inputSex"value="0" checked/><label class="col-sm-1 control-label">女</label>
                                                                    </div>
                                                                <%
                                                                    }
                                                                %>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="inputAddress1" class="col-sm-2 control-label">地址</label>
                                                                <div class="col-sm-10">
                                                                    <input type="text" class="form-control" id="inputAddress1" <%="value='"+resumes.getResumeAddress()+"'"%>/>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="inputPhone1" class="col-sm-2 control-label">电话</label>
                                                                <div class="col-sm-10">
                                                                    <input type="text" class="form-control" id="inputPhone1" <%="value='"+resumes.getResumePhone()+"'"%>/>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="inputProfession1" class="col-sm-2 control-label">专业</label>
                                                                <div class="col-sm-10">
                                                                    <input type="text" class="form-control" id="inputProfession1" <%="value='"+resumes.getProfession()+"'"%> />
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="inputGraduate1" class="col-sm-2 control-label">毕业院校</label>
                                                                <div class="col-sm-10">
                                                                    <input type="text" class="form-control" id="inputGraduate1" <%="value='"+resumes.getGraduateInstitutions()+"'"%> />
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="inputObject1" class="col-sm-2 control-label">求职意向</label>
                                                                <div class="col-sm-10">
                                                                    <input type="text" class="form-control" id="inputObject1" <%="value='"+resumes.getCareerObjective()+"'"%> />
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="inputWork1" class="col-sm-2 control-label">工作经历</label>
                                                                <div class="col-sm-10">
                                                                    <textarea id="inputWork1" style="height: 100px" class="form-control" ><%=resumes.getWorkExperience()%></textarea>
                                                                </div>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                                <button type="button" class="btn btn-primary">保存</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%
                                    i++;
                                }
                            %>
                            <%--添加简历--%>
                            <div class="col-md-4 column">
                                <a id="modal-960249" style="background-color: #b3f5de;border-radius: 20px;width: 80%;line-height: 200px;font-size: 35px;" href="#modal-container-960249" role="button" class="btn" data-toggle="modal">添加简历</a>
                                <div class="modal fade" id="modal-container-960249" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                                <h4 class="modal-title" id="createnewResume">
                                                    创建新的简历
                                                </h4>
                                            </div>
                                            <div class="modal-body">
                                                <div class="row clearfix">
                                                    <div class="col-md-12 column">
                                                        <form class="form-horizontal" role="form" <%="action='"+application.getContextPath()+"/ResumeServlet'"%> method="post">
                                                            <input type="hidden" <%="value='"+userID+"'"%> name="UserID">
                                                            <div class="form-group">
                                                                <label for="inputName" class="col-sm-2 control-label">姓名：</label>
                                                                <div class="col-sm-10">
                                                                    <input type="text" class="form-control" id="inputName" name="RName" />
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-2 control-label">性别：</label>
                                                                <div class="col-sm-10">
                                                                    <input type="radio" class="col-sm-1" style="margin-top: 10px" name="RSex"value="1" checked/><label class="col-sm-1 control-label">男</label>
                                                                    <input type="radio" class="col-sm-1" style="margin-top: 10px" name="RSex"value="0"/><label class="col-sm-1 control-label">女</label>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="inputAddress" class="col-sm-2 control-label">地址</label>
                                                                <div class="col-sm-10">
                                                                    <input type="text" class="form-control" id="inputAddress" name="RAddress" />
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="inputPhone" class="col-sm-2 control-label">电话</label>
                                                                <div class="col-sm-10">
                                                                    <input type="text" class="form-control" id="inputPhone" name="RPhone" />
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="inputProfession" class="col-sm-2 control-label">专业</label>
                                                                <div class="col-sm-10">
                                                                    <input type="text" class="form-control" id="inputProfession" name="RProfession" />
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="inputGraduate" class="col-sm-2 control-label">毕业院校</label>
                                                                <div class="col-sm-10">
                                                                    <input type="text" class="form-control" id="inputGraduate" name="RSchool" />
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="inputObject" class="col-sm-2 control-label">求职意向</label>
                                                                <div class="col-sm-10">
                                                                    <input type="text" class="form-control" id="inputObject" name="RObject"  />
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="inputWork" class="col-sm-2 control-label">工作经历</label>
                                                                <div class="col-sm-10">
                                                                    <textarea id="inputWork" style="height: 100px" class="form-control" name="RWork">
                                                                    </textarea>
                                                                </div>
                                                            </div>
                                                            <div class="modal-footer">
                                                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> <input type="submit" class="btn btn-primary" value="保存">
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
