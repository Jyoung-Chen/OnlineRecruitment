package com.net.dao;

import com.net.javabean.Users;

import java.util.List;

public interface UsersDao {
     Users queryDataById(int userId);
     Users queryDataByNumber(String userNumber);
     List<Users> findUser(int head, int num);
     int findCount();
     boolean updateUser(int oldUserID ,  Users users );
     boolean insertUser(Users users);
     boolean deleteUser(int userID);
}
