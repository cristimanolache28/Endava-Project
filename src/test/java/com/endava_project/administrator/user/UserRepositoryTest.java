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

import java.util.List;

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

    @Test
    public void testGetAllUsers() {
        List<User> listUsers =  userRepository.findAll();
        listUsers.stream()
                .forEach(System.out::println);
    }

    @Test
    public void testGetUserById() {
        User user = userRepository.findById(1).get();
        System.out.println(user);
        assertThat(user).isNotNull();
    }

    @Test
    public void testUpdateUser() {
        User user = userRepository.findById(1).get();
        user.setFirstName("Julian");
        user.setLastName("Ford");
        user.setPassword("newPassword");
        user.setEmail("newEmail@.com");
        user.setPhoneNumber(12321);
        user.setAge(31);
        userRepository.save(user);
    }

    @Test
    public void testDeleteUserById() {
        User user = userRepository.findById(9).get();
        userRepository.delete(user);
    }

    // 1 - administrator, 2 - user, 3 - admin, 4 - seller, 5 - customer
    @Test
    public void testDeleteUserRole() {
        User user = userRepository.findById(8).get();
        Role actualRole = new Role(1);
        user.getRoles().remove(actualRole);
        userRepository.save(user);
    }


}
