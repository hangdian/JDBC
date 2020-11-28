package com.hg.pool.test;

import com.hg.pool.dao.AccountDao;
import com.hg.pool.dao.impl.AccountDaoImpl;
import com.hg.pool.entity.Account;

public class TestDbutils {
    public static void main(String[] args) {
        AccountDao accountDao=new AccountDaoImpl();
        Account account=new Account(3,"123","1234","gang",3333);
        int result=accountDao.insert(account);
        System.out.println(result);
    }
}
