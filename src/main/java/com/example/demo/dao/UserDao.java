package com.example.demo.dao;

import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sun.management.Agent;

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

    /**
     * 查询所有用户，传递参数orderType，如果值为0，按照年龄升序排序，如果为1则按照年龄降序排序，否则按照ID排序
     * @param orderType
     * @return
     */
    List<User> queryAllUserAndSort(@Param("orderType") Integer orderType);

    /**
     * 查询所有用户，如果有姓名不为空，则按照姓名模糊查找；如果年龄也不为空，则还要满足年龄小于指定年龄
     * @param name
     * @param age
     * @return
     */
    List<User> queryUserByNameAndAge(@Param("name") String name,@Param("age") Integer age);

    /**
     * 修改用户信息，如果某字段为null，则不修改这个字段
     * @param user
     */
    int update(User user);

    /**
     * 根据多个ID查询用户
     * @param ids
     * @return
     */
    List<User> queryUserByIds(@Param("ids") List<Long> ids);

    /**
     * 查询订单的同时，查询出订单所属用户
     * @param orderNumber
     * @return
     */
    Order queryOrderAndNumberByOrderNumber(@Param("orderNumber") String orderNumber);

    /**
     * 查询订单，并且查询出所有订单详情及所属用户
     * @param orderNumber
     * @return
     */
    Order queryOrderWithUserAndOrderDetailByOrderNumber(@Param("orderNumber") String orderNumber);

    /**
     * 查询订单，查询出所属用户，并且查询出订单的详情，及订单详情中的对应的商品
     * @param orderDetailId
     * @return
     */
    Order queryOrderWithUserAndOrderDetailsAndItemByOrderNumber(@Param("orderNumber") String orderDetailId);

    /**
     * 通过select嵌套，查询订单的同时，查询出订单所属用户
     * @param orderNumber
     * @return
     */
    Order queryBySelect(@Param("orderNumber") String orderNumber);

    /**
     * 批量修改用户sql语句
     * @param list
     */
    void batchUpdate(@Param("list") List<User> list);
}
