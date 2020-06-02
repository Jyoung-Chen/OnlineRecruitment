package com.net.util;
import java.sql.*;

public class ConnectionUtil {
    private static ConnectionUtil connectionUtil;
    private ConnectionUtil(){}
    public synchronized static ConnectionUtil getInstance() {

        if (connectionUtil == null) {
            connectionUtil = new ConnectionUtil();
        }
        return connectionUtil;
    }

    public Connection getConnection(){
        Connection connection=null;
        if(connection==null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://127.0.0.1:3306/webpac? characterEncoding=UTF-8&serverTimezone=UTC";
                String userName="root";
                String password="123456";
                connection= DriverManager.getConnection(url,userName,password);
                if(connection==null){
                    System.out.println("连接数据库失败！");
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    public void closeConnection(ResultSet rs, PreparedStatement pps, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
            if (pps != null) {
                pps.close();
                pps = null;
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
