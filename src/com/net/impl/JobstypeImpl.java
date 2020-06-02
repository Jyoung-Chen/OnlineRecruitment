package com.net.impl;

import com.net.dao.JobstypeDao;
import com.net.javabean.Jobstype;
import com.net.javabean.Users;
import com.net.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobstypeImpl implements JobstypeDao {
    private ConnectionUtil connectionUtil;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public JobstypeImpl()
    {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        connectionUtil = ConnectionUtil.getInstance();
    }

    @Override
    public Jobstype queryDataById(int typeID) {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        Jobstype jobstype = null;
        connection = connectionUtil.getConnection();
        try {
            //preparedStatement会预处理sql语句
            preparedStatement = connection.prepareStatement("select * from jobstype where JobTypeId = ? ");
            //在第一个？处放置变量
            preparedStatement.setInt(1,typeID);
            //executeQuery用于查询返回一个结果集，executeUpdate用于更改表的数据包括插入、修改、删除返回受影响的行数
            //resultSet存放执行sql语句后的结果集，基本用在查询语句
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                jobstype = new Jobstype();
                jobstype.setJobTypeId(resultSet.getInt("JobTypeId"));
                jobstype.setJobTypeName(resultSet.getString("JobTypeName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.getInstance().closeConnection(resultSet,preparedStatement,connection);
        }
        return jobstype;
    }

    @Override
    public Jobstype queryDataByName(String typeName) {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        Jobstype jobstype = null;
        connection = connectionUtil.getConnection();
        try {
            //preparedStatement会预处理sql语句
            preparedStatement = connection.prepareStatement("select * from jobstype where JobTypeName = ? ");
            //在第一个？处放置变量
            preparedStatement.setString(1,typeName);
            //executeQuery用于查询返回一个结果集，executeUpdate用于更改表的数据包括插入、修改、删除返回受影响的行数
            //resultSet存放执行sql语句后的结果集，基本用在查询语句
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                jobstype = new Jobstype();
                jobstype.setJobTypeId(resultSet.getInt("JobTypeId"));
                jobstype.setJobTypeName(resultSet.getString("JobTypeName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.getInstance().closeConnection(resultSet,preparedStatement,connection);
        }
        return jobstype;
    }

    @Override
    public List<Jobstype> findJobsType(int head, int num) {
        List<Jobstype> list=new ArrayList<>();
        connection = null;
        preparedStatement = null;
        resultSet = null;
        connection = connectionUtil.getConnection();
        try {
            //preparedStatement会预处理sql语句
            preparedStatement = connection.prepareStatement("select * from Jobstype limit ?,?; ");
            //在第一个？处放置变量
            preparedStatement.setInt(1,(head-1)*num);
            preparedStatement.setInt(2,num);
            //executeQuery用于查询返回一个结果集，executeUpdate用于更改表的数据包括插入、修改、删除返回受影响的行数
            //resultSet存放执行sql语句后的结果集，基本用在查询语句
            resultSet = preparedStatement.executeQuery();
            if (resultSet!=null) {
                Jobstype jobstype ;
                while (resultSet.next()) {
                    jobstype = new Jobstype();
                    jobstype.setJobTypeId(resultSet.getInt("JobTypeId"));
                    jobstype.setJobTypeName(resultSet.getString("JobTypeName"));
                    list.add(jobstype);
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
            preparedStatement = connection.prepareStatement("select count(*) as 'rows' from jobstype ");
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
    public boolean updateType(int oldtypeID, Jobstype type) {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        connection = connectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("update jobstype set JobTypeId=?,JobTypeName=? where JobTypeId=?");
            preparedStatement.setInt(1,type.getJobTypeId());
            preparedStatement.setString(2,type.getJobTypeName());
            preparedStatement.setInt(3,oldtypeID);
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
    public boolean insertType(Jobstype type) {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        connection = connectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("insert into jobstype value (?,?);");
            preparedStatement.setInt(1,type.getJobTypeId());
            preparedStatement.setString(2,type.getJobTypeName());
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
    public boolean deleteType(int typeID) {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        connection = connectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("delete from jobstype where JobTypeId=?;");
            preparedStatement.setInt(1,typeID);
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
