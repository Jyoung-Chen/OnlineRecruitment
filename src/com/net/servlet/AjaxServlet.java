package com.net.servlet;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.net.impl.DaoFactory;
import com.net.javabean.Users;
import jdk.nashorn.internal.runtime.JSONFunctions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "AjaxServlet",urlPatterns = "/AjaxServlet")
public class AjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        List<Users> list = new ArrayList<>();

        if(request.getParameter("UserID")!=null||request.getParameter("UserNumber")!=null) {
            Users users;
            if (request.getParameter("UserID") != null) {
                int userID = Integer.parseInt(request.getParameter("UserID"));
                users = DaoFactory.getUsersImpl().queryDataById(userID);
            } else if (request.getParameter("UserNumber") != null) {
                String userNumber = request.getParameter("UserNumber");
                users = DaoFactory.getUsersImpl().queryDataByNumber(userNumber);
            }else {
                users=null;
            }
            list.add(users);
            JSONArray array = (JSONArray) JSON.toJSON(list);
            response.getWriter().write(array.toJSONString());
            response.getWriter().flush();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        System.out.println("AjaxServlet doGet");
        response.getWriter().write("请求 AjaxServlet doGet 成功");
        response.getWriter().flush();
    }
}
