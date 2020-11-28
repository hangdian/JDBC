package com.hg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestJdbc {
    public static void main(String[] args) throws Exception {
        //1,注册驱动，加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2,获得连接
        String url="jdbc:mysql://localhost:3306/myemployees?serverTimezone=UTC ";
        String user="root";
        String password="1234";
        Connection connection=DriverManager.getConnection(url,user,password);
        //3,获取发送sql对象
        Statement statement=connection.createStatement();
        //4，执行sql语句
        String sql="INSERT INTO departments(`department_id`,`department_name`,`manager_id`,`location_id`) VALUES (3001,'liu',NULL,2000) ";
        int res=statement.executeUpdate(sql);
        //5，处理结果
        if (res==1){
            System.out.println("successful!");
        }else {
            System.out.println("false!");
        }
        //6，释放资源
        statement.close();
        connection.close();




    }

}
