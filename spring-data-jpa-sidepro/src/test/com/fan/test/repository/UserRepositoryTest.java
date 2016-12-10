package com.fan.test.repository;

import com.fan.model.User;
import com.fan.model.VehicleIdentificationNumber;
import com.fan.repository.UserRepository;
import com.fan.service.UserService;
import com.fan.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by fqc on 12/4/16.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    private static final VehicleIdentificationNumber VIN = new VehicleIdentificationNumber(
            "00000000000000000");
    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private UserService userService;

    /*@Test
    public void findUserByNameShouldReturnUser() {
        this.testEntityManager.persist(new User("kobe", VIN));
        User kobe = userRepository.findByName("kobe");
        //User kobe = userService.findUserByName("kobe");
        assertThat(kobe.getName().equals("kobe"));
        assertThat(kobe.getVin()).isEqualTo(VIN);
    }

    @Test
    public void findUserByNameNotFoundShouldReturnNull() {
        this.testEntityManager.persist(new User("james", VIN));
        User user = userRepository.findByName("james2");
        assertThat(user).isNull();
    }*/
}
