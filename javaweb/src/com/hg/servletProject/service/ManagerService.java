package com.hg.servletProject.service;

import com.hg.servletProject.entity.Manager;

public interface ManagerService {
    public Manager login(String username,String password);
}
