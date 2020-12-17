package com.qf.dao;

import com.qf.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> queryUsers();
    public Integer insertUser(User user);
    public Integer updateUser(User user);
    public Integer deleteUser(Integer id);
}
