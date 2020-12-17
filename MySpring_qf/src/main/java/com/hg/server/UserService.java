package com.hg.server;

import com.hg.entity.User;

import java.util.List;

public interface UserService {
    public List<User> queryUser();
    public  Integer updateUser();
    public Integer saverUser();
    public  Integer deleteUser();
}
