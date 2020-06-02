package com.net.impl;

import com.net.dao.ResumesDao;
import com.net.javabean.Resumes;
import com.net.javabean.Users;
import com.net.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResumesImpl implements ResumesDao {

    private ConnectionUtil connectionUtil;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    public ResumesImpl()
    {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        connectionUtil = ConnectionUtil.getInstance();
    }

    @Override
    public Resumes queryDataById(int typeID) {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        Resumes resumes=null;
        connection = connectionUtil.getConnection();
        try {
            //preparedStatement会预处理sql语句
            preparedStatement = connection.prepareStatement("select * from resumes where ResumeID = ? ");
            //在第一个？处放置变量
            preparedStatement.setInt(1,typeID);
            //executeQuery用于查询返回一个结果集，executeUpdate用于更改表的数据包括插入、修改、删除返回受影响的行数
            //resultSet存放执行sql语句后的结果集，基本用在查询语句
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                resumes = new Resumes();
                resumes.setResumeId(resultSet.getInt("ResumeID"));
                resumes.setUserId(resultSet.getInt("UserID"));
                resumes.setResumeName(resultSet.getString("ResumeName"));
                resumes.setResumeSex(resultSet.getInt("ResumeSex"));
                resumes.setResumeAddress(resultSet.getString("ResumeAddress"));
                resumes.setResumePhone(resultSet.getString("ResumePhone"));
                resumes.setGraduateInstitutions(resultSet.getString("GraduateInstitutions"));
                resumes.setProfession(resultSet.getString("Profession"));
                resumes.setWorkExperience(resultSet.getString("WorkExperience"));
                resumes.setCareerObjective(resultSet.getString("CareerObjective"));
                resumes.setResumeExplain1(resultSet.getString("ResumeExplain1"));
                resumes.setResumeExplain2(resultSet.getString("ResumeExplain2"));
                resumes.setResumeStatus(resultSet.getInt("ResumeStatus"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.getInstance().closeConnection(resultSet,preparedStatement,connection);
        }
        return resumes;
    }

    @Override
    public List<Resumes> findResumes(int userID) {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        Resumes resumes=null;
        connection = connectionUtil.getConnection();
        List<Resumes> list=new ArrayList<>();
        try {
            //preparedStatement会预处理sql语句
            preparedStatement = connection.prepareStatement("select * from resumes where UserID = ? ");
            //在第一个？处放置变量
            preparedStatement.setInt(1,userID);
            //executeQuery用于查询返回一个结果集，executeUpdate用于更改表的数据包括插入、修改、删除返回受影响的行数
            //resultSet存放执行sql语句后的结果集，基本用在查询语句
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                resumes = new Resumes();
                resumes.setResumeId(resultSet.getInt("ResumeID"));
                resumes.setUserId(resultSet.getInt("UserID"));
                resumes.setResumeName(resultSet.getString("ResumeName"));
                resumes.setResumeSex(resultSet.getInt("ResumeSex"));
                resumes.setResumeAddress(resultSet.getString("ResumeAddress"));
                resumes.setResumePhone(resultSet.getString("ResumePhone"));
                resumes.setGraduateInstitutions(resultSet.getString("GraduateInstitutions"));
                resumes.setProfession(resultSet.getString("Profession"));
                resumes.setWorkExperience(resultSet.getString("WorkExperience"));
                resumes.setCareerObjective(resultSet.getString("CareerObjective"));
                resumes.setResumeExplain1(resultSet.getString("ResumeExplain1"));
                resumes.setResumeExplain2(resultSet.getString("ResumeExplain2"));
                resumes.setResumeStatus(resultSet.getInt("ResumeStatus"));
                list.add(resumes);
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
            preparedStatement = connection.prepareStatement("select count(*) as 'rows' from resumes ");
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
    public boolean updateResumes(int oldResumesID, Resumes resumes) {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        connection = connectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("update resumes SET ResumeID=?,UserID=?,ResumeName=?,ResumeSex=?,ResumeAddress=?,ResumePhone=?,GraduateInstitutions=?,Profession=?,WorkExperience=?,CareerObjective=?,ResumeExplain1=?,ResumeExplain2=?,ResumeStatus=? where ResumeID=?;");
            preparedStatement.setInt(1,resumes.getResumeId());
            preparedStatement.setInt(2,resumes.getUserId());
            preparedStatement.setString(3,resumes.getResumeName());
            preparedStatement.setInt(4,resumes.getResumeSex());
            preparedStatement.setString(5,resumes.getResumeAddress());
            preparedStatement.setString(6,resumes.getResumePhone());
            preparedStatement.setString(7,resumes.getGraduateInstitutions());
            preparedStatement.setString(8,resumes.getProfession());
            preparedStatement.setString(9,resumes.getWorkExperience());
            preparedStatement.setString(10,resumes.getCareerObjective());
            preparedStatement.setString(11,resumes.getResumeExplain1());
            preparedStatement.setString(12,resumes.getResumeExplain2());
            preparedStatement.setInt(13,resumes.getResumeStatus());
            preparedStatement.setInt(14,oldResumesID);
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
    public boolean insertResumes(Resumes resumes) {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        connection = connectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("insert into resumes value (?,?,?,?,?,?,?,?,?,?,?,?,?);");
            preparedStatement.setInt(1,resumes.getResumeId());
            preparedStatement.setInt(2,resumes.getUserId());
            preparedStatement.setString(3,resumes.getResumeName());
            preparedStatement.setInt(4,resumes.getResumeSex());
            preparedStatement.setString(5,resumes.getResumeAddress());
            preparedStatement.setString(6,resumes.getResumePhone());
            preparedStatement.setString(7,resumes.getGraduateInstitutions());
            preparedStatement.setString(8,resumes.getProfession());
            preparedStatement.setString(9,resumes.getWorkExperience());
            preparedStatement.setString(10,resumes.getCareerObjective());
            preparedStatement.setString(11,resumes.getResumeExplain1());
            preparedStatement.setString(12,resumes.getResumeExplain2());
            preparedStatement.setInt(13,resumes.getResumeStatus());
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
    public boolean deleteResumes(int resumesID) {
        connection = null;
        preparedStatement = null;
        resultSet = null;
        connection = connectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("delete from resumes where ResumeID=?;");
            preparedStatement.setInt(1,resumesID);
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
