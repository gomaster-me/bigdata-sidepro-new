package com.fan.repository;

import com.fan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by fqc on 11/20/16.
 */
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findByName(String name);

}
