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
        User zhangsan = new User("zhangsan", "zhangsan@google.com");
        userService.addUser(zhangsan);
        List<User> users = userService.findUsers();
        users.forEach(System.out::println);

    }

    @Test
    public void updateUser() throws Exception {
        User zhangsan = new User("zhangsan", "zhangsan@google.com");
        User zhangsan1 = userService.findUserByName("zhangsan");
        User user = userService.updateUser(zhangsan1);
        System.out.println(user.getEmail());


    }

    @Test
    public void deleteUser() throws Exception {
        User zhangsan = userService.findUserByName("zhangsan");

        userService.deleteUser(zhangsan.getId());
    }

    @Test
    public void findUser() throws Exception {
        User user = userService.findUser(5L);
        System.out.println(user);
    }

    @Test
    public void findUsers() throws Exception {
        List<User> users = userService.findUsers();
        users.forEach(System.out::println);
    }

    @Test
    public void findUserByName() throws Exception {
        User zhangsan = userService.findUserByName("zhangsan");

        System.out.println(zhangsan.getName());
    }

}