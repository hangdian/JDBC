package com.hg.dao;

import com.hg.domain.QueryVo;
import com.hg.domain.User;

import java.util.List;

public interface IUserDao {
    public List<User> findAll();
    public void saveUser(User user);
    public void updateUser(User user);
    public void deleteUser(Integer userId);
    public User findById(Integer userId);

    /**
     * 模糊查询
     * @param username
     * @return
     */
    public List<User> findByName(String username);

    /**
     * 总用户数
     * @return
     */
    public int findTotal();

    /**
     * 根据queryvo中的查询条件查询
     * @param vo
     * @return
     */
    public  List<User> findUserByVo(QueryVo vo);




}
