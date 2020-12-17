package com.hg.dao;

import com.hg.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     * 查询所有
     * 根据id查询
     * 插入一个用户
     * @return
     */

  @Select("select * from user")
    List<User> getUser();




}
