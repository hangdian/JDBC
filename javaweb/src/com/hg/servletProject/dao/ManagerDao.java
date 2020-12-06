package com.hg.servletProject.dao;

import com.hg.servletProject.entity.Manager;

public interface ManagerDao {
    public Manager select(String username);
}
