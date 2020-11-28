package com.hg.person.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 主要封装用跨平台的方式获得驱动，
 * 用ThreadLocal的方式连接对象，
 * 有开启事务，完成时提交事务
 * 异常时回滚事务，最后关闭资源，
 * 并且移除thread local中的共享接口对象。
 *
 */

public class DBUtils {
    private static final Properties PROPERTIES=new Properties();
    private  static final ThreadLocal<Connection> THREAD_LOCAL=new ThreadLocal<>();
    static {
        InputStream is =DBUtils.class.getResourceAsStream("/db.properties");
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
        Connection connection=THREAD_LOCAL.get();

            try {
                if(connection==null){
                connection= DriverManager.getConnection(PROPERTIES.getProperty("url"),PROPERTIES.getProperty("username"),PROPERTIES.getProperty("password"));
                THREAD_LOCAL.set(connection);
            }
        }catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
    }
    //获得连接之后，和之前不同的是还要设置开启和关闭事务的方法，最后在设置关闭。
    public static void begin(){
        Connection connection=null;
        try {
            connection=THREAD_LOCAL.get();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //提交事务，然后回滚事务
    public static void commit(){
        Connection connection=null;
        try {
            connection=THREAD_LOCAL.get();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static  void rollback(){
        Connection connection=null;
        try {
            connection=THREAD_LOCAL.get();
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if (resultSet!=null){
                resultSet.close();
            }
            if (statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
            }
            THREAD_LOCAL.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
