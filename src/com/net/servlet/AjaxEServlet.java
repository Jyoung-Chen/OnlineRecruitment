package com.net.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.net.impl.DaoFactory;
import com.net.javabean.Enterprises;
import com.net.javabean.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AjaxEServlet",urlPatterns ="/AjaxEServlet" )
public class AjaxEServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        List<Enterprises> list = new ArrayList<>();

        if(request.getParameter("EnterpriseID")!=null||request.getParameter("EnterpriseNumber")!=null) {
            Enterprises enterprises;
            if (request.getParameter("EnterpriseID") != null) {
                int enterpriseID = Integer.parseInt(request.getParameter("EnterpriseID"));
                enterprises = DaoFactory.getEnterpriseImpl().queryDataById(enterpriseID);
            } else if (request.getParameter("EnterpriseNumber") != null) {
                String enterpriseNumber = request.getParameter("EnterpriseNumber");
                enterprises = DaoFactory.getEnterpriseImpl().queryDataByName(enterpriseNumber);
            }else {
                enterprises=null;
            }
            list.add(enterprises);
            JSONArray array = (JSONArray) JSON.toJSON(list);
            response.getWriter().write(array.toJSONString());
            response.getWriter().flush();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
