package com.net.impl;

import com.net.dao.EnterpriseDao;
import com.net.javabean.Enterprises;
import com.net.javabean.Users;
import com.net.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnterpriseImpl implements EnterpriseDao {
    private ConnectionUtil connectionUtil;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    public EnterpriseImpl()
    {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        connectionUtil = ConnectionUtil.getInstance();
    }
    @Override
    public Enterprises queryDataById(int enterId) {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        Enterprises enterprises=null;
        connection = connectionUtil.getConnection();
        try {
            //preparedStatement会预处理sql语句
            preparedStatement = connection.prepareStatement("select * from enterprises where EnterpriseID = ? ");
            //在第一个？处放置变量
            preparedStatement.setInt(1,enterId);
            //executeQuery用于查询返回一个结果集，executeUpdate用于更改表的数据包括插入、修改、删除返回受影响的行数
            //resultSet存放执行sql语句后的结果集，基本用在查询语句
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                enterprises=new Enterprises();
                enterprises.setEnterpriseId(resultSet.getInt("EnterpriseID"));
                enterprises.setEnterpriseName(resultSet.getString("EnterpriseName"));
                enterprises.setEnterpriseMessage(resultSet.getString("EnterpriseMessage"));
                enterprises.setEnterpriseAddress(resultSet.getString("EnterpriseAddress"));
                enterprises.setEnterprisePhone(resultSet.getString("EnterprisePhone"));
                enterprises.setEnterprisePassword(resultSet.getString("EnterprisePassword"));
                enterprises.setEnterpriseStatus(resultSet.getInt("EnterpriseStatus"));
                enterprises.setEnterpriseExplain1(resultSet.getString("EnterpriseExplain1"));
                enterprises.setEnterpriseExplain2(resultSet.getString("EnterpriseExplain2"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.getInstance().closeConnection(resultSet,preparedStatement,connection);
        }
        return enterprises;
    }

    @Override
    public Enterprises queryDataByPhone(String enterPhone) {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        Enterprises enterprises=null;
        connection = connectionUtil.getConnection();
        try {
            //preparedStatement会预处理sql语句
            preparedStatement = connection.prepareStatement("select * from enterprises where EnterprisePhone = ? ");
            //在第一个？处放置变量
            preparedStatement.setString(1,enterPhone);
            //executeQuery用于查询返回一个结果集，executeUpdate用于更改表的数据包括插入、修改、删除返回受影响的行数
            //resultSet存放执行sql语句后的结果集，基本用在查询语句
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                enterprises=new Enterprises();
                enterprises.setEnterpriseId(resultSet.getInt("EnterpriseID"));
                enterprises.setEnterpriseName(resultSet.getString("EnterpriseName"));
                enterprises.setEnterpriseMessage(resultSet.getString("EnterpriseMessage"));
                enterprises.setEnterpriseAddress(resultSet.getString("EnterpriseAddress"));
                enterprises.setEnterprisePhone(resultSet.getString("EnterprisePhone"));
                enterprises.setEnterprisePassword(resultSet.getString("EnterprisePassword"));
                enterprises.setEnterpriseStatus(resultSet.getInt("EnterpriseStatus"));
                enterprises.setEnterpriseExplain1(resultSet.getString("EnterpriseExplain1"));
                enterprises.setEnterpriseExplain2(resultSet.getString("EnterpriseExplain2"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.getInstance().closeConnection(resultSet,preparedStatement,connection);
        }
        return enterprises;
    }

    @Override
    public Enterprises queryDataByName(String enterName) {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        Enterprises enterprises=null;
        connection = connectionUtil.getConnection();
        try {
            //preparedStatement会预处理sql语句
            preparedStatement = connection.prepareStatement("select * from enterprises where EnterpriseName = ? ");
            //在第一个？处放置变量
            preparedStatement.setString(1,enterName);
            //executeQuery用于查询返回一个结果集，executeUpdate用于更改表的数据包括插入、修改、删除返回受影响的行数
            //resultSet存放执行sql语句后的结果集，基本用在查询语句
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                enterprises=new Enterprises();
                enterprises.setEnterpriseId(resultSet.getInt("EnterpriseID"));
                enterprises.setEnterpriseName(resultSet.getString("EnterpriseName"));
                enterprises.setEnterpriseMessage(resultSet.getString("EnterpriseMessage"));
                enterprises.setEnterpriseAddress(resultSet.getString("EnterpriseAddress"));
                enterprises.setEnterprisePhone(resultSet.getString("EnterprisePhone"));
                enterprises.setEnterprisePassword(resultSet.getString("EnterprisePassword"));
                enterprises.setEnterpriseStatus(resultSet.getInt("EnterpriseStatus"));
                enterprises.setEnterpriseExplain1(resultSet.getString("EnterpriseExplain1"));
                enterprises.setEnterpriseExplain2(resultSet.getString("EnterpriseExplain2"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.getInstance().closeConnection(resultSet,preparedStatement,connection);
        }
        return enterprises;
    }

    @Override
    public List<Enterprises> findEnterprise(int head, int num) {
        List<Enterprises> list=new ArrayList<>();
        connection = null;
        preparedStatement = null;
        resultSet = null;
        connection = connectionUtil.getConnection();
        try {
            //preparedStatement会预处理sql语句
            preparedStatement = connection.prepareStatement("select * from enterprises limit ?,?; ");
            //在第一个？处放置变量
            preparedStatement.setInt(1,(head-1)*num);
            preparedStatement.setInt(2,num);
            //executeQuery用于查询返回一个结果集，executeUpdate用于更改表的数据包括插入、修改、删除返回受影响的行数
            //resultSet存放执行sql语句后的结果集，基本用在查询语句
            resultSet = preparedStatement.executeQuery();
            if (resultSet!=null) {
                Enterprises enterprises ;
                while (resultSet.next()) {
                    enterprises=new Enterprises();
                    enterprises.setEnterpriseId(resultSet.getInt("EnterpriseID"));
                    enterprises.setEnterpriseName(resultSet.getString("EnterpriseName"));
                    enterprises.setEnterpriseMessage(resultSet.getString("EnterpriseMessage"));
                    enterprises.setEnterpriseAddress(resultSet.getString("EnterpriseAddress"));
                    enterprises.setEnterprisePhone(resultSet.getString("EnterprisePhone"));
                    enterprises.setEnterprisePassword(resultSet.getString("EnterprisePassword"));
                    enterprises.setEnterpriseStatus(resultSet.getInt("EnterpriseStatus"));
                    enterprises.setEnterpriseExplain1(resultSet.getString("EnterpriseExplain1"));
                    enterprises.setEnterpriseExplain2(resultSet.getString("EnterpriseExplain2"));
                    list.add(enterprises);
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
            preparedStatement = connection.prepareStatement("select count(*) as 'rows' from enterprises ");
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
    public boolean updateEnterprise(int oldenterID, Enterprises enterprises) {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        Users user = null;
        connection = connectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("update enterprises set EnterpriseID=?,EnterpriseName=?,EnterprisePhone=?,EnterprisePassword=?,EnterpriseStatus=? where EnterpriseID=?");
            preparedStatement.setInt(1,enterprises.getEnterpriseId());
            preparedStatement.setString(2,enterprises.getEnterpriseName());
            preparedStatement.setString(3,enterprises.getEnterprisePhone());
            preparedStatement.setString(4,enterprises.getEnterprisePassword());
            preparedStatement.setInt(5,enterprises.getEnterpriseStatus());
            preparedStatement.setInt(6,oldenterID);
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
    public boolean insertEnterprise(Enterprises enterprises) {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        connection = connectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("insert into enterprises value (?,?,?,?,?,?,?,?,?);");
            preparedStatement.setInt(1,enterprises.getEnterpriseId());
            preparedStatement.setString(2,enterprises.getEnterpriseName());
            preparedStatement.setString(3,enterprises.getEnterpriseMessage());
            preparedStatement.setString(4,enterprises.getEnterpriseAddress());
            preparedStatement.setString(5,enterprises.getEnterprisePhone());
            preparedStatement.setString(6,enterprises.getEnterprisePassword());
            preparedStatement.setString(7,enterprises.getEnterpriseExplain1());
            preparedStatement.setString(8,enterprises.getEnterpriseExplain2());
            preparedStatement.setInt(9,enterprises.getEnterpriseStatus());
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
    public boolean deleteEnterprise(int enterID) {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        connection = connectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("delete from enterprises where EnterpriseID=?;");
            preparedStatement.setInt(1,enterID);
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
