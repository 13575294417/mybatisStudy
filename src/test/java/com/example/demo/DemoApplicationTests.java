package com.example.demo;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private UserDao userDAO;

    @Test
    public void testQueryUserById() {
        // 测试根据id查询
        User user = userDAO.queryUserById(13L);
        System.out.println(user);
    }

    @Test
    public void testQueryAll() {
        // 测试查询全部
        List<User> list = userDAO.queryAll();
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void testInsertUser() {
        // 测试添加用户
        User user = new User();
        user.setAge(16);
        user.setBirthday(new Date());
        user.setName("杨颖");
        user.setPassword("123456");
        user.setSex(2);// 2代表女性
        user.setUserName("xiaoyingying");

        // 插入用户
        userDAO.insertUser(user);
        System.out.println(user);
;    }

    @Test
    public void testUpdateUser() {
        // 测试修改用户
        // 先查询一个用户
        User user = userDAO.queryUserById(13L);
        user.setAge(100);
        // 修改用户
        userDAO.updateUser(user);
        System.out.println(user);
    }

    @Test
    public void testDeleteUserById() {
        // 测试删除
        userDAO.deleteUserById(13L);
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        User zhangsan = userDAO.queryUserByUsernameAndPassword("zhangsan", "123456");
        System.out.println(zhangsan);
    }

    @Test
    public void queryMaleUserByName() {
        List<User> users = userDAO.queryMaleUserByName("三");

        for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
            User user = iterator.next();
            System.out.println(user);
        }
    }

    @Test
    public void queryAllUserAndSort() {
        List<User> users = userDAO.queryAllUserAndSort(2);
        for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
            User user =  iterator.next();
            System.out.println(user);
        }
    }

    @Test
    public void queryUserByNameAndAge() {
        List<User> users = userDAO.queryUserByNameAndAge(null, null);
        for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
            User user =  iterator.next();
            System.out.println(user);
        }
    }

    @Test
    public void update() {
        User user = new User();
        user.setId(null);
        user.setAge(19);
        user.setName(null);
        int update = userDAO.update(user);
        System.out.println(update);
    }

    @Test
    public void queryUserByIds() {
        List<Long> ids = new ArrayList<>();
//        ids.add(1L);
        List<User> users = userDAO.queryUserByIds(ids);
        for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
            User user = iterator.next();
            System.out.println(user);
        }
    }
}


