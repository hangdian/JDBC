package com.hg.dao;

import com.hg.dao.UserMapper;
import com.hg.pojo.User;
import com.hg.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void test2(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        User user=mapper.getUserById(2);
        System.out.println(user );
        sqlSession.close();
    }

}
