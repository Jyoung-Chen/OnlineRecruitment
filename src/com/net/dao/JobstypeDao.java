package com.net.dao;
import com.net.javabean.Jobstype;

import java.util.List;

public interface JobstypeDao {
    Jobstype queryDataById(int typeID);
    Jobstype queryDataByName(String typeName);
    List<Jobstype> findJobsType(int head, int num);
    int findCount();
    boolean updateType(int oldtypeID ,  Jobstype type );
    boolean insertType(Jobstype type);
    boolean deleteType(int typeID);
}
