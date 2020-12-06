package com.hg.dao;

import com.hg.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {
    @Select("select * from user")
    public List<User> findAll();
}
