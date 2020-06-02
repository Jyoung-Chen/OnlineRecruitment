package com.net.servlet;

import com.net.impl.DaoFactory;
import com.net.javabean.Admins;
import com.net.javabean.Menu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置 接受请求  发送放回结果 的 字符编码 为UTF-8
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String adminNumber = request.getParameter("AdminNumber");
        String adminPassword = request.getParameter("AdminPassword");

        //查询数据库得到的结果对象
        Admins administrators  = DaoFactory.getAdminsImpl().queryData(adminNumber);
        if(administrators!=null) {
            //查询密码和输入密码成功后
            if (administrators.getAdminPassword().equals(adminPassword) && administrators.getAdminStatus() == 1) {
                //转发至主页页面

                request.setAttribute("name", administrators.getAdminNumber());
                List<Menu> list = DaoFactory.getMenuImpl().findAllMenu();
                Map<String, List<Menu>> map = new HashMap<>();
                for (Menu menu : list) {
                    if (map.containsKey(menu.getParentTitle())) {
                        List<Menu> list2 = map.get(menu.getParentTitle());
                        list2.add(menu);
                    } else {
                        List<Menu> list1 = new ArrayList<>();
                        list1.add(menu);
                        map.put(menu.getParentTitle(), list1);
                    }
                }
                request.setAttribute("menu", map);

                request.getRequestDispatcher("jsp/home.jsp").forward(request, response);
            } else {
                response.sendRedirect("jsp/error.jsp");
            }
        } else {
            response.sendRedirect("jsp/error.jsp");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return ;
    }
}
