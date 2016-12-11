package com.fan.service.impl.test;

import com.fan.model.User;
import com.fan.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Test
    public void findTop2OByPhoneStartingWithAndAddressContainingOrderByIdDesc() {
        System.out.println("findTop2OByPhoneStartingWithAndAddressContainingOrderByIdDesc......");
        String phone = "152010";
        String address = "威海路";
        List<User> users = userService.findTop2ByPhoneStartingWithAndAddressContainingOrderByIdDesc(phone, address);
        users.forEach(System.out::println);
    }

    @Test
    public void findByPhoneStartingWithAndAddressContainingNoPage() {
        System.out.println("sort......");
        String phone = "152010";
        String address = "威海路";
        Sort userSort = new Sort(Sort.Direction.ASC, "phone");
        List<User> users = userService.findByPhoneStartingWithAndAddressContainingNoPage(phone, address, userSort);
        users.forEach(System.out::println);
    }

    @Test
    public void getUsersByConditionsWithPage() {
        System.out.println("getUsersByConditionsWithPage......");
//        Page<User> users = userService.getUsersByConditionsWithPage("136", "路", 0, 2);
        /**
         * 分页序号计算公式：(当前页-1)*每页条数+1----> 做第一个编号 然后循环+1;
         如: 假设每页显示6条;
         第一页: (1-1)*6+1 =1  从1开始循环 一直+1到6;
         第二页: (2-1)*6+1 =7  从2开始循环 一直+1到6;
         */
        Page<User> users = userService.getUsersByConditionsWithPage("136", "路", 0, 2);
        System.out.println(String.format("共%s条", users.getTotalElements()));
        System.out.println(String.format("共%s页", users.getTotalPages()));
        System.out.println(String.format("每页需要查询%s条", users.getSize()));
        System.out.println(String.format("第%s页", users.getNumber()));
        System.out.println(String.format("集合%s", users.getContent()));
        System.out.println(String.format("当前页共%s条记录", users.getNumberOfElements()));
        users.forEach(System.out::println);
    }

}