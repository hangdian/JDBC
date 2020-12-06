package com.hg.dao;

import com.hg.domain.Account;
import com.hg.domain.AccounterUser;
import com.hg.domain.User;

import java.util.List;

public interface IAccountDao {
    //List<AccounterUser> findAll();
   List<Account> findAll();
    List<User> findAllUser();

}
