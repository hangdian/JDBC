package com.hg.account;

import java.util.List;

/**
 * Dao数据访问接口
 */

public interface AccountDao {
    public int insert(Account account);
    public int delete(String cardNo);
    public int update(Account account);
    public Account select(String cardNo);
    public List<Account> selectAll();
}
