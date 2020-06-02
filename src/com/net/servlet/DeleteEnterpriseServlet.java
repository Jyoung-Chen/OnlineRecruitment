package com.net.servlet;

import com.net.impl.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteEnterpriseServlet",urlPatterns = "/DeleteEnterpriseServlet")
public class DeleteEnterpriseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        if (request.getParameter("EnterpriseID")!=null){
            int enterpriseId= Integer.parseInt(request.getParameter("EnterpriseID"));
            if (DaoFactory.getEnterpriseImpl().queryDataById(enterpriseId)!=null){
                int row=DaoFactory.getEnterpriseImpl().deleteEnterprise(enterpriseId)? 1:0;
                response.getWriter().write(String.valueOf(row));
                response.getWriter().flush();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
