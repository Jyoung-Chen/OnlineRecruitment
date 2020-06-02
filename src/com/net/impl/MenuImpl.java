package com.net.impl;

import com.net.dao.MenuDao;
import com.net.javabean.Menu;
import com.net.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuImpl implements MenuDao {
    private ConnectionUtil connectionUtil;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    public MenuImpl(){
        connection = null;
        preparedStatement = null;
        resultSet = null;
        connectionUtil = ConnectionUtil.getInstance();
    }
    @Override
    public List<Menu> findAllMenu(){
        List<Menu> list = new ArrayList<>();
        Menu menu;
        connection = null;
        preparedStatement = null;
        resultSet = null;
        connection=connectionUtil.getConnection();
        try {
            preparedStatement= connection.prepareStatement("select menu1.MenuName as FirstTitle,menu2.MenuName as secondTitle,menu2.MenuPath as Menupath from menu menu1,menu menu2 where menu1.MenuID=menu2.ParentID");
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println("一级菜单名为"+resultSet.getString(1)+"\t 二级菜单名为"+resultSet.getString("secondTitle")+"路径为："+resultSet.getString("Menupath"));
                 menu=new Menu();
                 menu.setParentTitle(resultSet.getString("FirstTitle"));
                 menu.setThisTitle(resultSet.getString(2));
                 menu.setMenuPath(resultSet.getString("Menupath"));
                 list.add(menu);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.getInstance().closeConnection(resultSet,preparedStatement,connection);
        }
        return list;
    }
}
