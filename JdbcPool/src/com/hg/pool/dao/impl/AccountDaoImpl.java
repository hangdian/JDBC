package com.hg.pool.dao.impl;

import com.hg.pool.dao.AccountDao;
import com.hg.pool.entity.Account;
import com.hg.pool.utils.DBUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    private QueryRunner queryRunner=new QueryRunner(DBUtils.getDataSource());
    @Override
    public int insert(Account account) {
        Object[] params={account.getId(),account.getCardNo(),account.getPassword(),account.getName(),account.getBalance()};
        try {
            int result=queryRunner.update("insert into account(id,cardNo,password,name,balance)values(?,?,?,?,?);",params);
            return  result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Account account) {

        Object[] params={account.getCardNo(),account.getPassword(),account.getName(),account.getBalance(),account.getId()};
        try {
            int result=queryRunner.update("update account set cardNo=?,password=?,name=?,balance=? where id=?;",params);
            return  result;
        } catch (SQLException e) {
            e.printStackTrace();
        }return 0;
    }

    @Override
    public int delete(int id) {
        try {
            int result=queryRunner.update("delete from account where id=?",id);
            return  result;
        } catch (SQLException e) {
            e.printStackTrace();
        }return 0;
    }

    @Override
    public Account select(int id) {
            try {
                Account account=queryRunner.query("select * from account where id=?;",new BeanHandler<Account>(Account.class),id);
                return account;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
    }

    @Override
    public List<Account> selectAll() {
        try {
            List<Account> accountList=queryRunner.query("select* from account",new BeanListHandler<Account>(Account.class));
            return accountList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
