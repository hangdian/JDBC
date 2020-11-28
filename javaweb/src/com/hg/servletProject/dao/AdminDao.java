package com.hg.servletProject.dao;

import com.hg.servletProject.entity.Admin;

import java.util.List;

public interface AdminDao {
    public int insert(Admin admin);
    public int  delete(Admin admin);
    public int update(Admin admin);
    public  Admin select(String username);
    public List<Admin> selectAll();
}
