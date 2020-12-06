package com.hg.dao;

import com.hg.domain.QueryVo;
import com.hg.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {
    //@Select("select *from user")
    public List<User> findAll();
    public User       findById(Integer userId);
    public int        saveUser(User user);
    public int        updateUser(User user);
    public int        deleteUser(Integer userID);
    public  List<User> findByName(String username);
    public int          findTotal();
    public List<User>   findByVo(QueryVo vo);
    public List<User>   findByUser(User user);
    public List<User>   findInIds(QueryVo vo);

}
