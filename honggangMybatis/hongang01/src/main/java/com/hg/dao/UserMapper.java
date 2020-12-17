package com.hg.dao;

import com.hg.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     * 查询所有
     * 根据id查询
     * 插入一个用户
     * @return
     */
    public List<User> getUserList();
    public User getUserById(int id);
    public int addUser(User user);
    public int updateUser(User user);
    public int deleteUser(int id);


   // public int  addUser2(Map<String,Object> map);

}
