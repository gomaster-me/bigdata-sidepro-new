package com.fan.service.impl;

import com.fan.exception.UserNotFound;
import com.fan.model.User;
import com.fan.repository.UserRepository;
import com.fan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fqc on 12/3/16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findTop2ByPhoneStartingWithAndAddressContainingOrderByIdDesc(String phone, String address) {
        return userRepository.findTop2ByPhoneStartingWithAndAddressContainingOrderByIdDesc(phone, address);
    }

    @Override
    public List<User> findByPhoneStartingWithAndAddressContainingNoPage(String phone, String address, Sort sort) {
        List<User> users = userRepository.findByPhoneStartingWithAndAddressContaining(phone, address, sort);
        return users;
    }

    @Override
    public Page<User> getUsersByConditionsWithPage(String phone, String address, Integer pageNo, Integer pageSize) {
        Page<User> userPages = userRepository.findByPhoneStartingWithAndAddressContaining(phone, address, new PageRequest(pageNo, pageSize));
        return userPages;
    }

    @Override
    public User updateUser(User user) throws UserNotFound {
        if (user == null) throw new UserNotFound();
        userRepository.save(user);
        return user;
    }

    @Override
    public User deleteUser(Long id) throws UserNotFound {
        User userDelete = userRepository.findOne(id);
        if (userDelete == null) throw new UserNotFound();
        userRepository.delete(id);
        return userDelete;

    }

    @Override
    public User findUser(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByName(String name) {
        return userRepository.findByName(name);
    }
}
