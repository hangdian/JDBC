package com.hg.dao;

import com.hg.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * 查询所有
     * 根据id查询
     * 插入一个用户
     * @return
     */

    public User getUserById(@Param("uid") int id);


   // public int  addUser2(Map<String,Object> map);

}
