package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    User queryUserById(Long id);
    /**
     * 查询全部用户
     * @return
     */
    List<User> queryAll();
    /**
     * 添加用户
     * @param user
     */
    void insertUser(User user);
    /**
     * 修改用户
     * @param user
     */
    void updateUser(User user);
    /**
     * 根据ID删除用户
     * @param id
     */
    void deleteUserById(Long id);

}
