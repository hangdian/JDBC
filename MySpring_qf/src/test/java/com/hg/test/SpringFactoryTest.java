package com.hg.test;

import com.hg.dao.UserDao;
import com.hg.entity.User;
import com.hg.server.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.lang.annotation.Target;

public class SpringFactoryTest {
    @Test
    public  void testSpringFactory(){
        //启动工厂
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-context.xml");
        UserDao userDao=(UserDao)context.getBean("userDao");
        UserService userService=(UserService)context.getBean("userService");
        userDao.deleteUser(1);

    }
    @Test
    public void testSet(){
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-context.xml");
        User user=(User)context.getBean("user");
    }
    @Test
    public   void testLife(){
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-context2.xml");
        //关闭时销毁
    }
    @Test
    public  void testSpringAOP(){
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-context3.xml");
        UserService proxy=(UserService)context.getBean("userService");
        System.out.println(proxy.getClass());
        proxy.queryUser();
    }

}
