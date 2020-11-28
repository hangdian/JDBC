package com.hg.servletProject.service.impl;

import com.hg.servletProject.dao.AdminDao;
import com.hg.servletProject.dao.impl.AdminDaoImpl;
import com.hg.servletProject.entity.Admin;
import com.hg.servletProject.service.AdminService;
import com.hg.servletProject.utils.Dbutils;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao=new AdminDaoImpl();
    @Override
    public Admin login(String username, String password) {
        Admin result=null;
        try {
            Dbutils.begin();
            Admin admin=adminDao.select(username);
            if (admin!=null){
                if(admin.getPassword().equals(password)){
                    result=admin;
                }
            }
            Dbutils.commit();
        } catch (Exception e) {
            Dbutils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Admin> showAllAdmin() {
        List<Admin> admins=null;
        try {
            Dbutils.begin();
            admins=adminDao.selectAll();
            Dbutils.commit();
        } catch (Exception e) {
            Dbutils.rollback();
            e.printStackTrace();
        }

        return admins;
    }
}
