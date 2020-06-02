package com.net.servlet;

import com.net.impl.DaoFactory;
import com.net.javabean.Admins;
import com.net.javabean.Menu;
import com.net.javabean.Users;

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

@WebServlet(name = "UserLoginServlet",urlPatterns = "/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        System.out.println("post");
        String userNumber = request.getParameter("userNumber");
        String userPassword = request.getParameter("userPassword");

        //查询数据库得到的结果对象
        Users users=DaoFactory.getUsersImpl().queryDataByNumber(userNumber);
        if(users!=null){
            //查询密码和输入密码成功后
            if (users.getUserPassword().equals(userPassword)&&users.getUserStatus()==1) {
                //转发至主页页面
                request.setAttribute("name", users.getUserNumber());
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
                request.getRequestDispatcher("jsp/userLogin.jsp").forward(request, response);
            }else {
                response.sendRedirect("jsp/error1.jsp");
            }
        }else {
            response.sendRedirect("jsp/error1.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
