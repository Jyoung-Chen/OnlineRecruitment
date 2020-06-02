package com.net.dao;

import com.net.javabean.Jobs;
import java.util.List;

public interface JobsDao {
    Jobs queryDataById(int jobID);
    Jobs queryDataByNumber(String jobNumber);
    List<Jobs> findJob(int head, int num);
    int findCount();
    boolean updateJob(int oldjobID ,  Jobs job );
    boolean insertJob(Jobs job);
    boolean deleteJob(int jobID);
}
