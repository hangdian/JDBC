package com.hg.jdbc2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestORM {
    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<Departments> departmentsList=new ArrayList<>();
       try{
           connection=DBUtils.getConnection();
           preparedStatement=connection.prepareStatement("select * from departments;");
           resultSet=preparedStatement.executeQuery();
           while(resultSet.next()) {
               int department_id = resultSet.getInt("department_id");
               String department_name = resultSet.getString("department_name");
               int manager_id = resultSet.getInt("manager_id");
               int location_id = resultSet.getInt("location_id");
               //创建对象，封装查询到的零散的数据
               Departments departments = new Departments();
               departments.setDepartment_id(department_id);
               departments.setDepartment_name(department_name);
               departments.setLocation_id(location_id);
               departments.setManager_id(manager_id);
               //没遍历一次得到的对象，存在集合里
               departmentsList.add(departments);
           }
           //集合遍历
           for (Departments d:departmentsList){
               System.out.println(d);
           }



       }catch (SQLException e){
           e.printStackTrace();
       }finally {
           DBUtils.closeAll(connection,preparedStatement,resultSet);
       }
    }
}
