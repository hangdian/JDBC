package com.hg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteJdbc {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployees?serverTimezone=UTC","root","1234");
        Statement statement=connection.createStatement();
        String sql="delete from departments where department_id=3001;";
        int res=statement.executeUpdate(sql);
        if(res==1){
            System.out.println("success");
        }else {
            System.out.println("false");
        }
        statement.close();
        connection.close();
    }
}
