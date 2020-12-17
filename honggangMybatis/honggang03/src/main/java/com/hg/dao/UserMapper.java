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

    public User getUserById(int id);
           List<User> getUserByList(Map<String ,Integer> map);


   // public int  addUser2(Map<String,Object> map);

}
