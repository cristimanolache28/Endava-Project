package com.endava_project.administrator.user;

import com.endava_project.administrator.repository.UserRepository;
import com.endava_project.entity.Role;
import com.endava_project.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
// Don't replace the application default DataSource.
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
// Whether the test-managed transaction should be rolled back after the test method has completed.
//@Rollback(false)
// As of Spring Framework 4.2, @Commit can be used as direct replacement for @Rollback(false).
@Commit
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser() {
        Role addAdminRole = entityManager.find(Role.class, 1);
        User userX = new User("Luis", "Cooper", "luispassword", "luiz-cooper@yahoo.com", 5214412);
        userX.addRole(addAdminRole);

        User savedUser = userRepository.save(userX);
        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testCreateUserWithTwoRoles() {
        User userY = new User("Dan", "Show", "danshowpassword", "dan-show@gmai.com", 1234123);

        Role moderatorRole = new Role(1); // add moderator role
        Role sellerRole = new Role(4); // add seller role

        userY.addRole(moderatorRole);
        userY.addRole(sellerRole);

        User savedUser = userRepository.save(userY);
        assertThat(savedUser.getId()).isGreaterThan(0);
    }
}
