package com.hg.jdbc;

import sun.security.pkcs11.Secmod;

import java.sql.*;
import java.util.Scanner;

public class LoginJdbc {
    public static void main(String[] args) throws Exception {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入用户名 ：");
        String username=scanner.next();
        System.out.println("请输入密码");
        String password=scanner.next();
        Connection connection=DBUtils.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("select * from users where username=? and password=?");
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);
        ResultSet resultSet=preparedStatement.executeQuery();
        if (resultSet.next()){
                System.out.println("success");
        }else{
            System.out.println("false");
        }
        DBUtils.closeAll(connection,preparedStatement,resultSet );
    }
}
