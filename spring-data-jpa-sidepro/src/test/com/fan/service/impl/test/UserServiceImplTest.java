package com.fan.service.impl.test;

import com.fan.model.User;
import com.fan.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fqc on 12/10/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//@Transactional //加上事务后会每个方法都会提交并回滚.
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void addUser() throws Exception {
        System.out.println("add......");
        User zhangsan = new User("zhangsan", "zhangsan@google.com");
        userService.addUser(zhangsan);
        List<User> users = userService.findUsers();
        users.forEach(System.out::println);
    }

    @Test
    public void updateUser() throws Exception {
        System.out.println("update.......");
        User zhangsan1 = userService.findUserByName("zhangsan");
        zhangsan1.setEmail("baidu-google.com");
        User user = userService.updateUser(zhangsan1);
        System.out.println(user.getEmail());
    }

    @Test
    public void deleteUser() throws Exception {
        System.out.println("delete..........");
        User zhangsan = userService.findUserByName("zhangsan");
        userService.deleteUser(zhangsan.getId());
        userService.findUsers().forEach(System.out::println);
    }

    @Test
    public void findUser() throws Exception {
        System.out.println("findUser......");
        User user = userService.findUser(5L);
        System.out.println(user);
    }

    @Test
    public void findUsers() throws Exception {
        System.out.println("findAll........");
        List<User> users = userService.findUsers();
        users.forEach(System.out::println);
    }

    @Test
    public void findUserByName() throws Exception {
        System.out.println("findByName.....");
        User zhangsan = userService.findUserByName("zhangsan");
        System.out.println(zhangsan.getName());
    }

}