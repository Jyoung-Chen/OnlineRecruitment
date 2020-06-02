package com.net.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.net.impl.DaoFactory;
import com.net.javabean.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DeleteUserServlet",urlPatterns = "/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        if (request.getParameter("UserID")!=null){
            int userId= Integer.parseInt(request.getParameter("UserID"));
            if (DaoFactory.getUsersImpl().queryDataById(userId)!=null){
                int row=DaoFactory.getUsersImpl().deleteUser(userId)? 1:0;
                response.getWriter().write(String.valueOf(row));
                response.getWriter().flush();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
