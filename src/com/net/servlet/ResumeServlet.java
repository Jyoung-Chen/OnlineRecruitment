package com.net.servlet;

import com.net.impl.DaoFactory;
import com.net.javabean.Resumes;
import com.net.javabean.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ResumeServlet",urlPatterns = "/ResumeServlet")
public class ResumeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        System.out.println("dopost");
        Resumes resumes=new Resumes();
        Users users=DaoFactory.getUsersImpl().queryDataById(Integer.parseInt(request.getParameter("UserID")));
        resumes.setUserId(Integer.parseInt(request.getParameter("UserID")));
        resumes.setResumeName(request.getParameter("RName"));
        resumes.setResumeSex(Integer.parseInt(request.getParameter("RSex")));
        resumes.setResumeAddress(request.getParameter("RAddress"));
        resumes.setResumePhone(request.getParameter("RPhone"));
        resumes.setGraduateInstitutions(request.getParameter("RSchool"));
        resumes.setProfession(request.getParameter("RProfession"));
        resumes.setWorkExperience(request.getParameter("RWork"));
        resumes.setCareerObjective(request.getParameter("RObject"));
        DaoFactory.getResumesImpl().insertResumes(resumes);
        request.setAttribute("name", users.getUserNumber());
        request.getRequestDispatcher("jsp/userLogin.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
