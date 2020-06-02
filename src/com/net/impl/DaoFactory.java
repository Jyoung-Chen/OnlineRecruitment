package com.net.impl;

import com.net.dao.*;
import com.net.javabean.Enterprises;

public class DaoFactory {
     public static UsersDao getUsersImpl() {
        return new UsersImpl();
    }
     public static AdminsDao getAdminsImpl(){ return new AdminsImpl(); }
     public static MenuDao getMenuImpl(){ return new MenuImpl(); }
     public static EnterpriseDao getEnterpriseImpl(){ return new EnterpriseImpl(); }
     public static JobsDao getJobsImpl(){ return new JobsImpl(); }
    public static JobstypeDao getJobstypeImpl(){ return new JobstypeImpl(); }
    public static ResumesDao getResumesImpl(){ return new ResumesImpl(); }
}
