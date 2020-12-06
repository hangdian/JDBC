package com.hg.test;

import com.hg.dao.IAccountDao;
import com.hg.dao.IUserDao;
import com.hg.domain.Account;
import com.hg.domain.AccounterUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class AccountTest {
    private InputStream is;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IAccountDao accountDao;
    @Test
    public void testFindAll(){
        List<Account> accounts=accountDao.findAll();
        for(Account au:accounts){
            System.out.println(au);
            System.out.println(au.getUid());
        }
    }
    @Before
    public void init() throws Exception{
        is= Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        factory=builder.build(is);
        session=factory.openSession();
        accountDao=session.getMapper(IAccountDao.class);


    }
    @After
    public void destory() throws Exception{
        session.commit();
        session.close();
        is.close();
    }

}
