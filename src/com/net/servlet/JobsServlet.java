package com.net.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.net.dao.JobsDao;
import com.net.impl.DaoFactory;
import com.net.javabean.Jobs;
import com.net.javabean.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "JobsServlet",urlPatterns = "/JobsServlet")
public class JobsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");

        List< Jobs > list = DaoFactory.getJobsImpl().findJob(1,10);
        JSONArray array = (JSONArray) JSON.toJSON(list);
        response.getWriter().write(array.toJSONString());
        response.getWriter().flush();
        //json字符串 转 Java对象
//		g.fromJson(json, classOfT)

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
