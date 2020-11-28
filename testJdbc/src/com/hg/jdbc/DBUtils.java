package com.hg.jdbc;

import java.sql.*;

public class DBUtils {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
           // connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployees?serverTimezone=UTC", "root", "1234");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    //1,获取连接
    public static Connection getConnection(){
        Connection connection=null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployees?serverTimezone=UTC", "root", "1234");
        }catch(SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
    //2,释放资源
    public static  void closeAll(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
