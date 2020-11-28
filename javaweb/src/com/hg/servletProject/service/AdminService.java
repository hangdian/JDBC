package com.hg.servletProject.service;

import com.hg.servletProject.entity.Admin;

import java.util.List;

public interface AdminService {
    public Admin login(String username,String password);
    public List<Admin> showAllAdmin();
}
