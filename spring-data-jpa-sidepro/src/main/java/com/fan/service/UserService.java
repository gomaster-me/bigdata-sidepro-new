package com.fan.service;

import com.fan.exception.UserNotFound;
import com.fan.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fqc on 12/3/16.
 */
public interface UserService {
    public void addUser(User user);

    public User updateUser(User user) throws UserNotFound;

    public User deleteUser(int id) throws UserNotFound;

    public User findUser(int id);

    public List<User> findUsers();
}
