package com.endava_project.administrator.user;

import com.endava_project.administrator.repository.RoleRepository;
import com.endava_project.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class RoleRepositoryTest {

    @Autowired
    RoleRepository roleRepository;

    @Test
    void testCreateAdministratorRole() {
        Role administratorRole = new Role("Admin", "manage everything");
        Role roleSaved = roleRepository.save(administratorRole);
        assertThat(roleSaved.getId()).isGreaterThan(0);
    }
    @Test
    void testCreateModeratorRole() {
        Role moderatorRole = new Role("Moderator", "manage brands, categories," +
                "products and order");
        Role roleSaved = roleRepository.save(moderatorRole);
        assertThat(roleSaved.getId()).isGreaterThan(0);
    }
    @Test
    void testCreateSellerRole() {
        Role sellerRole = new Role("Seller", "manage product price, customers" +
                "shipping, order and sales report");
        Role roleSaved = roleRepository.save(sellerRole);
        assertThat(roleSaved.getId()).isGreaterThan(0);
    }

    @Test
    void testCreateCustomerRole() {
        Role customerRole = new Role("Customer", "view orders");
        Role savedRole = roleRepository.save(customerRole);
        assertThat(savedRole.getId()).isGreaterThan(0);
    }

    @Test
    void testCreateUserRole() {
        Role userRole = new Role("User", "sign-up, view product");
        Role roleSaved = roleRepository.save(userRole);
        assertThat(roleSaved.getId()).isGreaterThan(0);
    }

}
