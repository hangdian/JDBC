package com.hg.dao;

import com.hg.domain.User;

import java.util.List;

public interface IUserDao {
    public List<User> findAll();
}
