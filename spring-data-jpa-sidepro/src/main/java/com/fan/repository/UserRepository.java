package com.fan.repository;

import com.fan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Domain repository for {@link User}
 * Created by fqc on 11/20/16.
 */
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
    //List<User> findByName(String username);

    //    User findByUserName(String name);

    User findByName(String name);
}
