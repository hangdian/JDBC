package com.hg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryJdbc {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployees?serverTimezone=UTC","root","1234");
        Statement statement=connection.createStatement();
        ResultSet rs=statement.executeQuery("select * from departments;");
        while(rs.next()){
            int department_id=rs.getInt( 1);
            String department_name=rs.getString(2);
            int manager_id=rs.getInt(3);
            int location_id=rs.getInt(4);
            /*
            int department_id=rs.getInt("department_id");
            String department_name=rs.getString("department_name");
            int manager_id=rs.getInt("manager_id");
            int location_id=rs.getInt("location_id");
             */
            System.out.println(department_id+"\t"+department_name+"\t"+manager_id+"\t"+location_id);
        }
        rs.close();
        statement.close();
        connection.close();

    }
}
