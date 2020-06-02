package com.net.servlet;

import com.net.impl.DaoFactory;
import com.net.javabean.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserManagerServlet",urlPatterns = "/UserManagerServlet" )
public class UserManagerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String nowPage = request.getParameter("nowPage");
        int oldId =Integer.parseInt(request.getParameter("oldId"));

        Users users=new Users();
        users.setUserId(Integer.parseInt(request.getParameter("userId")));
        users.setUserNumber(request.getParameter("userNumber"));
        users.setUserPassword(request.getParameter("userPassword"));
        users.setUserStatus(Integer.parseInt(request.getParameter("userStatus")));
        System.out.println(users.toString());

        Users users1= DaoFactory.getUsersImpl().queryDataById(users.getUserId());
        Users users2= DaoFactory.getUsersImpl().queryDataByNumber(users.getUserNumber());
        if((users1==null||users1.getUserId()==oldId)&&(users2==null||users2.getUserId()==oldId)){
            if (DaoFactory.getUsersImpl().updateUser(oldId,users)==true) {
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }
        }else{
            if(users1!=null) {
                System.out.println("用户ID已存在无法修改");
            }else if(users2!=null){
                System.out.println("用户名称已存在无法修改");
            }else {
                System.out.println("发生未知错误");
            }
        }
        response.sendRedirect("jsp/userManager.jsp?page="+nowPage);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
