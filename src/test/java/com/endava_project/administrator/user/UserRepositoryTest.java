package com.endava_project.administrator.user;

import com.endava_project.administrator.repository.UserRepository;
import com.endava_project.entity.Role;
import com.endava_project.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser() {
        Role addAdminRole = entityManager.find(Role.class, 1);
        entityManager.find(Role.class, 1);
        User userX = new User("Manoalche", "Cristi", "password", "cristimanoalche@gmail.com", 321412);
        userX.addRole(addAdminRole);

        User savedUser = userRepository.save(userX);
        assertThat(savedUser.getId()).isGreaterThan(0);
    }
}
