package com.hg.server;

import com.hg.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    public List<User> queryUser() {
//        System.out.println("控制事务");
//        System.out.println("日志打印");
        System.out.println("queryUser");
        return new ArrayList<User>();
    }

    public Integer updateUser() {
//        System.out.println("控制事务");
//        System.out.println("日志打印");
        System.out.println("update User");
        return 1;
    }

    public Integer saverUser() {
//        System.out.println("控制事务");
//        System.out.println("日志打印");
        System.out.println("saveUser");
        return 1;
    }

    public Integer deleteUser() {
//        System.out.println("控制事务");
//        System.out.println("日志打印");
        System.out.println("deleteUser");
        return 1;
    }
}

