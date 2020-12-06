package com.hg.test;

import com.hg.dao.IUserDao;
import com.hg.domain.QueryVo;
import com.hg.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    private InputStream is;
    private SqlSessionFactory factory;
    private  SqlSession session;
    private  IUserDao userDao;
    @Before
    public void init() throws Exception{
        is= Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        factory=builder.build(is);
        session=factory.openSession();
        userDao=session.getMapper(IUserDao.class);


    }
    @After
    public void destory() throws Exception{
        session.commit();
        session.close();
        is.close();
    }
    @Test
    public void testFindOne(){
        User user=userDao.findById(48);
        System.out.println(user);
    }
    @Test
    public void testFindALl(){
        List<User>  users=userDao.findAll();
        for (User user:users){
            System.out.println(user);
        }
    }
    @Test
    public void testSaveUser(){
        User user=new User();
        user.setUsername("cunzhu");
        user.setBirthday(new Date());
        user.setAddress("hangzhou");
        user.setSex("男");
        System.out.println("before"+user);
        userDao.saveUser(user);
        System.out.println("after"+user );
    }
    @Test
    public void testUpdateUser(){
        User user=userDao.findById(54);
        user.setAddress("hangdian");
        int res=userDao.updateUser(user);
        System.out.println(res);
    }
    @Test
    public void testDeleteUser() {
        int res=userDao.deleteUser(54);
        System.out.println(res);
    }
    @Test
    public void testFindByName(){
        List<User> users=userDao.findByName("%王%");
        for (User user:users){
            System.out.println(user);
        }
    }
    @Test
    public void testFindTotal(){
        int res=userDao.findTotal();
        System.out.println(res);
    }
    @Test
    public void testFindByQueryVo(){
        QueryVo vo=new QueryVo();
        User user=new User();
        user.setUsername("%王%");
        vo.setUser(user);
        List<User> users=userDao.findByVo(vo);
        for(User u:users){
            System.out.println(u);
        }
    }
    @Test
    public void testFindByUser(){
        User u=new User();
        u.setUsername("%王%");
        u.setAddress("%顺义%");
        List<User> users=userDao.findByUser(u);
        for (User user:users){
            System.out.println(user);
        }

    }

}
