package com.hg.emp.service;

import com.hg.emp.dao.EmpManagerDao;
import com.hg.emp.dao.EmpManagerDaoImpl;
import com.hg.emp.entity.EmpManager;
import com.hg.emp.utils.DbUtils;

public class EmpManagerServiceImpl implements EmpManagerService {
    private EmpManagerDao empManagerDao=new EmpManagerDaoImpl();
    @Override
    public EmpManager login(String username, String password) {
        EmpManager empManager=null;
        try {
            DbUtils.begin();
            EmpManager temp=empManagerDao.select(username);
            if(temp!=null){
                if (temp.getPassword().equals(password)){
                    empManager=temp;
                }
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();

        }

        return empManager;
    }
}
