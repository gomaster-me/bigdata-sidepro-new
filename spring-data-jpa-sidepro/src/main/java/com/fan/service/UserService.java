package com.fan.service;

import com.fan.exception.UserNotFound;
import com.fan.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by fqc on 12/3/16.
 */
public interface UserService {
    void addUser(User user);

    User updateUser(User user) throws UserNotFound;

    User deleteUser(Long id) throws UserNotFound;

    User findUser(Long id);

    List<User> findUsers();

    User findUserByName(String name);

    List<User> findTop2ByPhoneStartingWithAndAddressContainingOrderByIdDesc(String phone, String address);

    List<User> findByPhoneStartingWithAndAddressContainingNoPage(String phone, String address, Sort sort);

    Page<User> getUsersByConditionsWithPage(String phone, String address, Integer pageNo, Integer pageSize);
}
