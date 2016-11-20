package com.fan.repository;

import com.fan.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by fqc on 11/20/16.
 */
@Component
public class DataInitialization implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new User("kobe01", "baidu.com"));
        userRepository.save(new User("kobe02", "baidu02.com"));
        userRepository.save(new User("kobe03", "baidu03.com"));
        userRepository.save(new User("kobe04", "baidu04.com"));
        userRepository.save(new User("kobe05", "baidu05.com"));

        List<User> users = userRepository.findAll();
        users.forEach(user -> System.out.println(user));
        users.forEach(System.out::println);

    }

    public List<User> helloWorld() {
        userRepository.save(new User("HelloWorld", "HelloWorld@tianmaying.com"));
        List<User> users = userRepository.findAll();
        users.forEach(System.out::println);
        return users;
    }
}
