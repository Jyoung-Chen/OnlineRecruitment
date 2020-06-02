package com.net.servlet;

import com.net.impl.DaoFactory;
import com.net.javabean.Enterprises;
import com.net.javabean.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SetEStatusServlet",urlPatterns = "/SetEStatusServlet")
public class SetEStatusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        if (request.getParameter("EnterpriseID")!=null){
            Enterprises enterprises = DaoFactory.getEnterpriseImpl().queryDataById(Integer.parseInt(request.getParameter("EnterpriseID")));
            if (request.getParameter("Status")!=null){
                enterprises.setEnterpriseStatus(Integer.parseInt(request.getParameter("Status")));
                int row=DaoFactory.getEnterpriseImpl().updateEnterprise(enterprises.getEnterpriseId(),enterprises)? 1:0;
                response.getWriter().write(String.valueOf(row));
                response.getWriter().flush();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
