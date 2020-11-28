package com.hg.account;

import sun.security.pkcs11.Secmod;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountServiceImpl implements AccountService {
    public void transfer(String fromNo,String pwd,String toNo,double money){
        //1,收参
        AccountDao accountDAO=new AccountDAOImpl();
        //2，组织完善业务功能

        try {
            //获得连接对象，有回滚段。
            //设置当前事务的自动提交为手动提交，开启事务。
            //优化后的方法，调用DBUtils开启事务
            DBUtils.begin();
            //2.1验证fromNo是否存在
            Account account=accountDAO.select(fromNo);
            if (account==null){
                throw new RuntimeException("don't exist！");
            }
            //2.2验证fromNo的密码是否正确
            if (!account.getPassword().equals(pwd)){
                throw new RuntimeException("password error");
            }
            //2.3验证余额是否充足
            if (account.getBalance()<money){
                throw new RuntimeException("balance not enough");
            }
            //2.4验证toNo是否存在
            Account account1=accountDAO.select(toNo);
            if (account1==null){
                throw new RuntimeException("toNO don't exist");
            }
            //2.5减少formNo的余额
            account.setBalance(account.getBalance()-money);
            accountDAO.update(account);
            //2.6增加toNo的余额
            account.setBalance(account1.getBalance()+money);
            accountDAO.update(account1);
            System.out.println("transfer success");
            //转账成功则，整个事物提交哦。
            //优化后直接用DBU里面的方法提交。
            DBUtils.commit();
        } catch (RuntimeException e) {
            System.out.println("transfer false");
            //如果程序出现异常，则整个事务回滚。
                //
            DBUtils.rollback();

            e.printStackTrace();

        }
    }
}
//没有出现connection，也没有出现closeAll这是最合理的方式，在事务层中。