package com.hg.dao;

import com.hg.pojo.User;
import com.hg.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for(User user:userList){
            System.out.println(user);
        }
        sqlSession.close();


    }
    @Test
    public void test2(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        User user=mapper.getUserById(2);
        System.out.println(user );
        sqlSession.close();
    }
    @Test
    public void test3(){
        SqlSession sqlSession=MybatisUtils.getSqlSession() ;
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        User user=new User(4,"cuncun","1234");
        int res=mapper.addUser(user);
        System.out.println(res);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test4(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        int res=mapper.updateUser(new User(4,"cun","12345"));
        System.out.println(res);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test5(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        int res=mapper.deleteUser(4);
        System.out.println(res );
        sqlSession.commit();
        sqlSession.close();
    }
}
