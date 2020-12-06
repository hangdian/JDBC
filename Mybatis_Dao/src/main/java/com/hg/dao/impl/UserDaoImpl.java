package com.hg.dao.impl;

import com.hg.dao.IUserDao;
import com.hg.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao {
    private SqlSessionFactory factory;
    public UserDaoImpl(SqlSessionFactory factory){
        this.factory=factory;
    }

    public List<User> findAll() {
        //1,根据factory获取Sqlsession对象
        SqlSession session=factory.openSession();
        //2.调用Sqlsession中的方法，实现查询列表
        List<User> users=session.selectList("com.hg.dao.IUserDao.findAll");//参数就是能获取的配置信息的key
        //3，释放资源
        session.close();
        return users;
    }

    public void saveUser(User user) {

    }

    public void updateUser(User user) {

    }

    public void deleteUser(Integer userId) {

    }

    public User findById(Integer userId) {
        return null;
    }

    public List<User> findByName(String username) {
        return null;
    }

    public int findTotal() {
        return 0;
    }
}
