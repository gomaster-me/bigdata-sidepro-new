import com.fan.Application;
import com.fan.model.User;
import com.fan.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by fqc on 12/3/16.
 */
@RunWith(SpringRunner.class)
public class TestUser {


    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByUsernameShouldReturnUser() {
        List<User> users = this.userRepository.findAll();
        Assert.notEmpty(users, "ok");
    }


}
