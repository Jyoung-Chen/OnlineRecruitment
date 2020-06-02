package com.net.dao;

import com.net.javabean.Jobstype;
import com.net.javabean.Resumes;

import java.util.List;

public interface ResumesDao {
    Resumes queryDataById(int typeID);
    List<Resumes> findResumes(int userID);
    int findCount();
    boolean updateResumes(int oldResumesID ,  Resumes resumes );
    boolean insertResumes(Resumes resumes);
    boolean deleteResumes(int resumesID);
}
