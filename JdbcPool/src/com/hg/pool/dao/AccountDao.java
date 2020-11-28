package com.hg.pool.dao;

import com.hg.pool.entity.Account;

import java.util.List;

public interface AccountDao {
    public  int insert(Account account);
    public int update(Account account);
    public int delete(int id );
    public Account select(int id);
    public List<Account> selectAll();


}
