package com.hg.servletProject.dao.impl;

import com.hg.servletProject.dao.ManagerDao;
import com.hg.servletProject.entity.Manager;
import com.hg.servletProject.utils.Dbutils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class ManagerDaoImpl implements ManagerDao {
    private QueryRunner queryRunner=new QueryRunner();
    @Override
    public Manager select(String username) {
        try {
            Manager manager=queryRunner.query(Dbutils.getConnection(),"select * from manager where username=?",new BeanHandler<Manager>(Manager.class),username);
            return manager;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
