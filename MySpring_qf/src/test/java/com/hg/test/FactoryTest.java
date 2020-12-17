package com.hg.test;

import com.hg.dao.UserDao;
import com.hg.factory.MyFactory;
import com.hg.server.UserService;

import java.io.IOException;

public class FactoryTest {
    public static void main(String[] args) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        //创建工厂对象
        MyFactory myFactory=new MyFactory();
        UserDao userDao=(UserDao) myFactory.getBean("userDao");
        UserService userService=(UserService)myFactory.getBean("userService");
        userDao.deleteUser(1);

    }
}
