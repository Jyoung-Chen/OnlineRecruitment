package com.net.impl;

import com.net.dao.UsersDao;
import com.net.javabean.Users;
import com.net.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersImpl implements UsersDao {
    private ConnectionUtil connectionUtil;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    public UsersImpl()
    {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        connectionUtil = ConnectionUtil.getInstance();
    }
    @Override
    public Users queryDataById(int userId) {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        Users user = null;
        connection = connectionUtil.getConnection();
        try {
            //preparedStatement会预处理sql语句
            preparedStatement = connection.prepareStatement("select * from users where UserID = ? ");
            //在第一个？处放置变量
            preparedStatement.setInt(1,userId);
            //executeQuery用于查询返回一个结果集，executeUpdate用于更改表的数据包括插入、修改、删除返回受影响的行数
            //resultSet存放执行sql语句后的结果集，基本用在查询语句
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new Users();
                user.setUserId(resultSet.getInt("UserID"));
                user.setUserNumber(resultSet.getString("UserNumber"));
                user.setUserPassword(resultSet.getString("UserPassword"));
                user.setUserStatus(resultSet.getInt("UserStatus"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.getInstance().closeConnection(resultSet,preparedStatement,connection);
        }
        return user;
    }

    public Users queryDataByNumber(String userNumber) {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        Users user = null;
        connection = connectionUtil.getConnection();
        try {
            //preparedStatement会预处理sql语句
            preparedStatement = connection.prepareStatement("select * from users where UserNumber = ? ");
            //在第一个？处放置变量
            preparedStatement.setString(1,userNumber);
            //executeQuery用于查询返回一个结果集，executeUpdate用于更改表的数据包括插入、修改、删除返回受影响的行数
            //resultSet存放执行sql语句后的结果集，基本用在查询语句
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new Users();
                user.setUserId(resultSet.getInt("UserID"));
                user.setUserNumber(resultSet.getString("UserNumber"));
                user.setUserPassword(resultSet.getString("UserPassword"));
                user.setUserStatus(resultSet.getInt("UserStatus"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.getInstance().closeConnection(resultSet,preparedStatement,connection);
        }
        return user;
    }
    @Override
    public List<Users> findUser(int head, int num) {
        List<Users> list=new ArrayList<>();
        connection = null;
        preparedStatement = null;
        resultSet = null;
        connection = connectionUtil.getConnection();
        try {
            //preparedStatement会预处理sql语句
            preparedStatement = connection.prepareStatement("select * from users limit ?,?; ");
            //在第一个？处放置变量
            preparedStatement.setInt(1,(head-1)*num);
            preparedStatement.setInt(2,num);
            //executeQuery用于查询返回一个结果集，executeUpdate用于更改表的数据包括插入、修改、删除返回受影响的行数
            //resultSet存放执行sql语句后的结果集，基本用在查询语句
            resultSet = preparedStatement.executeQuery();
            if (resultSet!=null) {
                Users user ;
                while (resultSet.next()) {
                    user = new Users();
                    user.setUserId(resultSet.getInt("UserID"));
                    user.setUserNumber(resultSet.getString("UserNumber"));
                    user.setUserPassword(resultSet.getString("UserPassword"));
                    user.setUserStatus(resultSet.getInt("UserStatus"));
                    list.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.getInstance().closeConnection(resultSet,preparedStatement,connection);
        }
        return list;
    }

    @Override
    public int findCount() {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        int row=0;
        connection = connectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("select count(*) as 'rows' from users ");
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                row=resultSet.getInt("rows");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.getInstance().closeConnection(resultSet,preparedStatement,connection);
        }
        return row;
    }

    @Override
    public boolean updateUser(int oldUserID, Users users) {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        Users user = null;
        connection = connectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("update users set UserID=?,UserNumber=?,UserPassword=?,UserStatus=? where UserID=?");
            preparedStatement.setInt(1,users.getUserId());
            preparedStatement.setString(2,users.getUserNumber());
            preparedStatement.setString(3,users.getUserPassword());
            preparedStatement.setInt(4,users.getUserStatus());
            preparedStatement.setInt(5,oldUserID);
            if (preparedStatement.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.getInstance().closeConnection(resultSet,preparedStatement,connection);
        }
        return false;
    }

    @Override
    public boolean insertUser(Users users) {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        connection = connectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("insert into users value (?,?,?,?);");
            preparedStatement.setInt(1,users.getUserId());
            preparedStatement.setString(2,users.getUserNumber());
            preparedStatement.setString(3,users.getUserPassword());
            preparedStatement.setInt(4,users.getUserStatus());
            if (preparedStatement.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.getInstance().closeConnection(resultSet,preparedStatement,connection);
        }
        return false;
    }

    @Override
    public boolean deleteUser(int userID) {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        connection = connectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("delete from users where UserID=?;");
            preparedStatement.setInt(1,userID);
            if (preparedStatement.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.getInstance().closeConnection(resultSet,preparedStatement,connection);
        }
        return false;
    }
}
