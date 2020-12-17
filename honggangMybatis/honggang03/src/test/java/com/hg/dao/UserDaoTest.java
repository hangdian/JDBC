package com.hg.dao;

import com.hg.pojo.User;
import com.hg.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * 日志
 *
 */
public class UserDaoTest {
     static Logger logger=Logger.getLogger(UserDaoTest.class);
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
        logger.info("info:");
        logger.debug("debug");
        logger.error("error");
    }
    @Test
    public void test4(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex",0);
        map.put("pageSize",2);
        List<User> userByList = mapper.getUserByList(map);
        for (User user : userByList) {
            System.out.println(user);

        }

    }


}
