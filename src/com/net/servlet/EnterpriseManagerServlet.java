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

@WebServlet(name = "EnterpriseManagerServlet",urlPatterns = "/EnterpriseManagerServlet")
public class EnterpriseManagerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String nowPage = request.getParameter("nowPage");
        int oldId =Integer.parseInt(request.getParameter("oldId"));

        Enterprises enterprises=DaoFactory.getEnterpriseImpl().queryDataById(oldId);
        enterprises.setEnterpriseId(Integer.parseInt(request.getParameter("enterprisesId")));
        enterprises.setEnterpriseName(request.getParameter("enterprisesNumber"));
        enterprises.setEnterprisePassword(request.getParameter("enterprisesPassword"));
        enterprises.setEnterpriseStatus(Integer.parseInt(request.getParameter("enterprisesStatus")));

        Enterprises enterprises1= DaoFactory.getEnterpriseImpl().queryDataById(enterprises.getEnterpriseId());
        Enterprises enterprises2= DaoFactory.getEnterpriseImpl().queryDataByName(enterprises.getEnterpriseName());
        if((enterprises1==null||enterprises1.getEnterpriseId()==oldId)&&(enterprises2==null||enterprises2.getEnterpriseId()==oldId)){
            if (DaoFactory.getEnterpriseImpl().updateEnterprise(oldId,enterprises)==true) {
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }
        }else{
            if(enterprises1!=null) {
                System.out.println("用户ID已存在无法修改");
            }else if(enterprises2!=null){
                System.out.println("用户名称已存在无法修改");
            }else {
                System.out.println("发生未知错误");
            }
        }
        response.sendRedirect("jsp/enterpriseManager.jsp?page="+nowPage);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
