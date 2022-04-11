package com.endava.project.user.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data // @ToString, @EqualsAndHashCode, @Getter/@Setter, @RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name", length = 35, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 25, nullable = false)
    private String lastName;

    @Column(name = "password", length = 64, nullable = false)
    private String password;

    @Column(name = "email", length = 128, nullable = false)
    private String email;

    @Column(name = "phone_number", length = 15, nullable = false)
    private int phoneNumber;

    @Column(name = "age", length = 2)
    private int age;

    @Column(name = "enable")
    private boolean enable;

//    TODO
//    @Column(name = "gender", length = 20, nullable = true)
//    private String gender;

//    TODO
//    private String photos;
//    private LocalDateTime register;

    // create intermediate table
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_role", // table name
            joinColumns = @JoinColumn(name = "user_id"), // foreign key referencing back the entity table
            inverseJoinColumns = @JoinColumn(name = "role_id") // foreign key referencing the target entity
    )

    // I am using a collection for implementing many-to-many between user and role
    private Set<Role> roles = new HashSet<>();

    public User(String firstName, String lastName, String password, String email, int phoneNumber, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public User(String firstName, String lastName, String password, String email, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

}
