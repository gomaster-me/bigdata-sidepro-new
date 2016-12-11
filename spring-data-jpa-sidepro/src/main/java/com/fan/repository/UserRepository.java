package com.fan.repository;

import com.fan.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Domain repository for {@link User}
 * Created by fqc on 11/20/16.
 */
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

    List<User> findTop2ByPhoneStartingWithAndAddressContainingOrderByIdDesc(String phone, String address);

    List<User> findByPhoneStartingWithAndAddressContaining(String phone, String address, Sort sort);

    Page<User> findByPhoneStartingWithAndAddressContaining(String phone, String address, Pageable user);


}
