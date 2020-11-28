package com.hg.person;
import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 增，删，改，查（单个or所有）
 * 只做数据库操作，不参与逻辑判断！
 * 复用，一张数据库表的操作复用
 */
public class PersonDaolmpl {
    public int insert(Person person){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        String sql="insert into person(name,age,borndate,email,address)values(?,?,?,?,?);";
        try {
            connection=DBUtils.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,person.getName());
            preparedStatement.setInt(2,person.getAge());
            preparedStatement.setDate(3,UtilDate.utilToSql(person.getBornDate()));
            preparedStatement.setString(4,person.getEmail());
            preparedStatement.setString(5,person.getAddress());
            int result=preparedStatement.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(connection,preparedStatement,null);
        }

        return 0;
    }//增
    public int update(Person person ){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        String sql="update person set name=?,age=?,borndate=?,email=?,address=?where id=?;";
        try {
            connection=DBUtils.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,person.getName());
            preparedStatement.setInt(2,person.getAge());
            preparedStatement.setDate(3,null);
            preparedStatement.setString(4,person.getEmail());
            preparedStatement.setString(5,person.getAddress());
            preparedStatement.setInt(6,person.getId());
            int result=preparedStatement.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(connection,preparedStatement,null);
        }


        return 0;
    }//修改
    public int delete(int id ){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        String sql="delete from person where id=?;";
        connection=DBUtils.getConnection();
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            int result=preparedStatement.executeUpdate();
            return  result;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(connection,preparedStatement,null);
        }

        return 0;
    }//删除
     public  Person select(int id){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select * from person where id=?;";
        Person person=null;
        try {
            connection=DBUtils.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                person=new Person();
                int pid=resultSet.getInt("id");
                String  name=resultSet.getString("name");
                int age =resultSet.getInt("age");
                Date bornDate=resultSet.getDate("bornDate");
                String email=resultSet.getString("email");
                String address=resultSet.getString("address");
                person.setId(pid);
                person.setName(name);
                person.setAge(age);
                person.setBornDate(bornDate);
                person.setAddress(address);
                person.setEmail(email);
            }
            return  person;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(connection,preparedStatement,resultSet);
        }
        return  null;
    }//查单个
    public List<Person> selectAll(){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        Person person =null;
        List<Person> personList=new ArrayList<>();
        try {
            connection=DBUtils.getConnection();
            preparedStatement=connection.prepareStatement("select * from person;");
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){

                int pid=resultSet.getInt("id");
                String  name=resultSet.getString("name");
                int age =resultSet.getInt("age");
                Date bornDate=resultSet.getDate("bornDate");
                String email=resultSet.getString("email");
                String address=resultSet.getString("address");
                person=new Person(pid,name,age,bornDate, email,address );
                personList.add(person);

            }
            return personList;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(connection,preparedStatement,resultSet);
        }



        return null;
    }//查所有
    public  Person select(String name){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select * from person where name=?;";
        Person person=null;
        try {
            connection=DBUtils.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                person=new Person();
                int pid=resultSet.getInt("id");
                String  pname=resultSet.getString("name");
                int age =resultSet.getInt("age");
                Date bornDate=resultSet.getDate("bornDate");
                String email=resultSet.getString("email");
                String address=resultSet.getString("address");
                person.setId(pid);
                person.setName(pname);
                person.setAge(age);
                person.setBornDate(bornDate);
                person.setAddress(address);
                person.setEmail(email);
            }
            return  person;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(connection,preparedStatement,resultSet);
        }
        return  null;
    }//查单个

}
