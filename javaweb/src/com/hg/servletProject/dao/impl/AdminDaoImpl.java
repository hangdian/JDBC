package com.hg.servletProject.dao.impl;

import com.hg.servletProject.dao.AdminDao;
import com.hg.servletProject.entity.Admin;
import com.hg.servletProject.utils.Dbutils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AdminDaoImpl implements AdminDao {
    private QueryRunner queryRunner=new QueryRunner();
    @Override
    public int insert(Admin admin) {
        return 0;
    }

    @Override
    public int delete(Admin admin) {
        return 0;
    }

    @Override
    public int update(Admin admin) {
        return 0;
    }

    @Override
    public Admin select(String username) {
        try {
            Admin admin= queryRunner.query(Dbutils.getConnection(),"select * from admin where username=?;",new BeanHandler<Admin>(Admin.class),username);
            return admin;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Admin> selectAll() {
        List<Admin> admins= null;
        try {
            admins = queryRunner.query(Dbutils.getConnection(),"select * from admin;",new BeanListHandler<Admin>(Admin.class));
            return  admins;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
