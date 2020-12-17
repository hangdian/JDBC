package com.hg.dao;

import com.hg.pojo.User;
import com.hg.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * 日志
 *
 */
public class UserDaoTest {

     @Test
    public  void test1(){
         SqlSession sqlSession = MybatisUtils.getSqlSession();
         UserMapper mapper = sqlSession.getMapper(UserMapper.class);
         List<User> userByList = mapper.getUser();
         for (User user : userByList) {
             System.out.println(user);

         }



         sqlSession.close();


     }


}
