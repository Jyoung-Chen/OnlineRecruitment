package com.net.impl;

import com.net.dao.JobsDao;
import com.net.javabean.Jobs;
import com.net.javabean.Users;
import com.net.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobsImpl implements JobsDao {
    private ConnectionUtil connectionUtil;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public JobsImpl()
    {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        connectionUtil = ConnectionUtil.getInstance();
    }
    @Override
    public Jobs queryDataById(int jobID) {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        Jobs jobs = null;
        connection = connectionUtil.getConnection();
        try {
            //preparedStatement会预处理sql语句
            preparedStatement = connection.prepareStatement("select * from jobs where JobID = ? ");
            //在第一个？处放置变量
            preparedStatement.setInt(1,jobID);
            //executeQuery用于查询返回一个结果集，executeUpdate用于更改表的数据包括插入、修改、删除返回受影响的行数
            //resultSet存放执行sql语句后的结果集，基本用在查询语句
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                jobs=new Jobs();
                jobs.setJobId(resultSet.getInt("JobID"));
                jobs.setEnterpriseId(resultSet.getInt("EnterpriseID"));
                jobs.setJobTypeId(resultSet.getInt("JobTypeId"));
                jobs.setJobName(resultSet.getString("JobName"));
                jobs.setJobDescription(resultSet.getString("JobDescription"));
                jobs.setJobDemand(resultSet.getString("JobDemand"));
                jobs.setJobSalary(resultSet.getString("JobSalary"));
                jobs.setJobExplain1(resultSet.getString("JobExplain1"));
                jobs.setJobExplain2(resultSet.getString("JobExplain2"));
                jobs.setJobHot(resultSet.getInt("JobHot"));
                jobs.setJobStatus(resultSet.getInt("JobStatus"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.getInstance().closeConnection(resultSet,preparedStatement,connection);
        }
        return jobs;
    }

    @Override
    public Jobs queryDataByNumber(String jobNumber) {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        Jobs jobs = null;
        connection = connectionUtil.getConnection();
        try {
            //preparedStatement会预处理sql语句
            preparedStatement = connection.prepareStatement("select * from jobs where JobName = ? ");
            //在第一个？处放置变量
            preparedStatement.setString(1,jobNumber);
            //executeQuery用于查询返回一个结果集，executeUpdate用于更改表的数据包括插入、修改、删除返回受影响的行数
            //resultSet存放执行sql语句后的结果集，基本用在查询语句
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                jobs=new Jobs();
                jobs.setJobId(resultSet.getInt("JobID"));
                jobs.setEnterpriseId(resultSet.getInt("EnterpriseID"));
                jobs.setJobTypeId(resultSet.getInt("JobTypeId"));
                jobs.setJobName(resultSet.getString("JobName"));
                jobs.setJobDescription(resultSet.getString("JobDescription"));
                jobs.setJobDemand(resultSet.getString("JobDemand"));
                jobs.setJobSalary(resultSet.getString("JobSalary"));
                jobs.setJobExplain1(resultSet.getString("JobExplain1"));
                jobs.setJobExplain2(resultSet.getString("JobExplain2"));
                jobs.setJobHot(resultSet.getInt("JobHot"));
                jobs.setJobStatus(resultSet.getInt("JobStatus"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.getInstance().closeConnection(resultSet,preparedStatement,connection);
        }
        return jobs;
    }

    @Override
    public List<Jobs> findJob(int head, int num) {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        Jobs jobs = null;
        List<Jobs> list=new ArrayList<>();
        connection = connectionUtil.getConnection();
        try {
            //preparedStatement会预处理sql语句
            preparedStatement = connection.prepareStatement("select * from jobs order by JobHot desc limit ?,?; ");
            //在第一个？处放置变量
            preparedStatement.setInt(1,(head-1)*num);
            preparedStatement.setInt(2,num);
            //executeQuery用于查询返回一个结果集，executeUpdate用于更改表的数据包括插入、修改、删除返回受影响的行数
            //resultSet存放执行sql语句后的结果集，基本用在查询语句
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                jobs=new Jobs();
                jobs.setJobId(resultSet.getInt("JobID"));
                jobs.setEnterpriseId(resultSet.getInt("EnterpriseID"));
                jobs.setJobTypeId(resultSet.getInt("JobTypeId"));
                jobs.setJobName(resultSet.getString("JobName"));
                jobs.setJobDescription(resultSet.getString("JobDescription"));
                jobs.setJobDemand(resultSet.getString("JobDemand"));
                jobs.setJobSalary(resultSet.getString("JobSalary"));
                jobs.setJobExplain1(resultSet.getString("JobExplain1"));
                jobs.setJobExplain2(resultSet.getString("JobExplain2"));
                jobs.setJobHot(resultSet.getInt("JobHot"));
                jobs.setJobStatus(resultSet.getInt("JobStatus"));
                list.add(jobs);
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
            preparedStatement = connection.prepareStatement("select count(*) as 'rows' from jobs ");
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
    public boolean updateJob(int oldjobID, Jobs job) {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        Users user = null;
        connection = connectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("update jobs set JobID=?,EnterpriseID=?,JobTypeId=?,JobName=?,JobDescription=?,JobDemand=?,JobSalary=?,JobExplain1=?,JobExplain2=?,JobHot=?,JobStatus=? where JobID=?");
            preparedStatement.setInt(1,job.getJobId());
            preparedStatement.setInt(2,job.getEnterpriseId());
            preparedStatement.setInt(3,job.getJobTypeId());
            preparedStatement.setString(4,job.getJobName());
            preparedStatement.setString(5,job.getJobDescription());
            preparedStatement.setString(6,job.getJobDemand());
            preparedStatement.setString(7,job.getJobSalary());
            preparedStatement.setString(8,job.getJobExplain1());
            preparedStatement.setString(9,job.getJobExplain2());
            preparedStatement.setInt(10,job.getJobHot());
            preparedStatement.setInt(11,job.getJobStatus());
            preparedStatement.setInt(12,oldjobID);
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
    public boolean insertJob(Jobs job) {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        Users user = null;
        connection = connectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("insert into jobs value (?,?,?,?,?,?,?,?,?,?,?);");
            preparedStatement.setInt(1,DaoFactory.getJobsImpl().findCount()+1);
            preparedStatement.setInt(2,job.getEnterpriseId());
            preparedStatement.setInt(3,job.getJobTypeId());
            preparedStatement.setString(4,job.getJobName());
            preparedStatement.setString(5,job.getJobDescription());
            preparedStatement.setString(6,job.getJobDemand());
            preparedStatement.setString(7,job.getJobSalary());
            preparedStatement.setString(8,job.getJobExplain1());
            preparedStatement.setString(9,job.getJobExplain2());
            preparedStatement.setInt(10,job.getJobHot());
            preparedStatement.setInt(11,job.getJobStatus());
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
    public boolean deleteJob(int jobID) {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        connection = connectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("delete from jobs where JobID=?;");
            preparedStatement.setInt(1,jobID);
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
