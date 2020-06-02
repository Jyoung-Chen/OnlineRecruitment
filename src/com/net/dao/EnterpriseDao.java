package com.net.dao;

import com.net.javabean.Enterprises;
import com.net.javabean.Users;

import java.util.List;

public interface EnterpriseDao {
    Enterprises queryDataById(int enterId);
    Enterprises queryDataByPhone(String enterPhone);
    Enterprises queryDataByName(String enterName);
    List<Enterprises> findEnterprise(int head, int num);
    int findCount();
    boolean updateEnterprise(int oldenterID ,  Enterprises enterprises);
    boolean insertEnterprise(Enterprises enterprises);
    boolean deleteEnterprise(int enterID);
}
