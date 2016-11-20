package com.fan.repository;

import com.fan.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by fqc on 11/20/16.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findByName(String name);

}
