package com.hg.servletProject.service.impl;

import com.hg.servletProject.dao.ManagerDao;
import com.hg.servletProject.dao.impl.ManagerDaoImpl;
import com.hg.servletProject.entity.Manager;
import com.hg.servletProject.service.ManagerService;
import com.hg.servletProject.utils.Dbutils;
import org.apache.commons.dbutils.DbUtils;

public class ManagerServiceImpl implements ManagerService {
    private ManagerDao managerDao=new ManagerDaoImpl();
    @Override
    public Manager login(String username, String password) {
        Manager manager= null;
        try {
            manager = null;
            Dbutils.begin();
            Manager temp=managerDao.select(username);
            if (temp!=null){
                if (temp.getPassword().equals(password)){
                    manager=temp;
                }
            }
            Dbutils.commit();
        } catch (Exception e) {
            Dbutils.rollback();
            e.printStackTrace();
        }

        return manager;
    }
}
