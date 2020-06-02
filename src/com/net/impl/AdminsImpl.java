package com.net.impl;

import com.net.dao.AdminsDao;
import com.net.javabean.Admins;
import com.net.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminsImpl implements AdminsDao {
    private ConnectionUtil connectionUtil;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    public AdminsImpl(){
        connection = null;
        preparedStatement = null;
        resultSet = null;
        connectionUtil = ConnectionUtil.getInstance();
    }
    @Override
    public Admins queryData(String adminNumber) {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        Admins administrators = null;
        try {
            connection = connectionUtil.getConnection();
            //preparedStatement会预处理sql语句
            preparedStatement = connection.prepareStatement("select * from administrators where AdminNumber = ? ");
            //在第一个？处放置变量
            preparedStatement.setString(1, adminNumber);
            //executeQuery用于查询返回一个结果集，executeUpdate用于更改表的数据包括插入、修改、删除返回受影响的行数
            //resultSet存放执行sql语句后的结果集，基本用在查询语句
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                administrators = new Admins();
                administrators.setAdminId(resultSet.getInt("AdminID"));
                administrators.setAdminNumber(resultSet.getString("AdminNumber"));
                administrators.setAdminPassword(resultSet.getString("AdminPassword"));
                administrators.setAdminStatus(resultSet.getInt("AdminStatus"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.getInstance().closeConnection(resultSet,preparedStatement,connection);
        }
        return administrators;
    }
}
