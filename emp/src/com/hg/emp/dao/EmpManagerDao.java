package com.hg.emp.dao;

import com.hg.emp.entity.EmpManager;

public interface EmpManagerDao {
    public EmpManager select(String username);
}
