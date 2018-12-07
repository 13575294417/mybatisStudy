package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 根据用户名和密码来查找用户
     * @param username
     * @param password
     * @return
     */
    User queryUserByUsernameAndPassword(@Param("userName") String username, @Param("password") String password);

    /**
     * 查询男性用户，如果输入了姓名，则按照姓名模糊查找
     * @param name
     * @return
     */
    List<User> queryMaleUserByName(@Param("name") String name);
}
