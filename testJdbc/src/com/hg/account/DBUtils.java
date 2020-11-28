package com.hg.account;


import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtils {
    private  static ThreadLocal<Connection> threadLocal=new ThreadLocal<>();
    public static final Properties PROPERTIES=new Properties();
    static{
        InputStream is= com.hg.person.DBUtils.class.getResourceAsStream("/db.properties");
        try {
            PROPERTIES.load(is);
            Class.forName(PROPERTIES.getProperty("driver"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        Connection connection=threadLocal.get();
        try {
            if (connection==null){
                connection= DriverManager.getConnection(PROPERTIES.getProperty("url"),PROPERTIES.getProperty("username"),PROPERTIES.getProperty("password"));
                threadLocal.set(connection);
            }
            //,,,
            // connection= DriverManager.getConnection(PROPERTIES.getProperty("url"),PROPERTIES.getProperty("username"),PROPERTIES.getProperty("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    //开启事务
    public static  void begin(){
        try {
            Connection connection=getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //提交事务
    public static void commit(){
        Connection connection=null;
        try {
            connection=getConnection();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(connection,null,null);
        }
    }
    //回滚事务
    public static void rollback(){
        Connection connection=null;
        try {
            connection=getConnection();
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(connection,null,null);
        }
    }

    public  static void closeAll(Connection connection, Statement statement, ResultSet resultSet){
        try{
            if (resultSet!=null){
                resultSet.close();
            }
            if(statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
                threadLocal.remove();//关闭连接后，移除已经关闭的connection对象。
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
