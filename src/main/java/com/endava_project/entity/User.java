package com.endava_project.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
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

    @Column(name = "email", unique = true, length = 128, nullable = false)
    private String email;

    @Column(name = "phone_number", unique = true, length = 15, nullable = false)
    private int phoneNumber;

    @Column(name = "age", length = 2, nullable = true)
    private int age;

    private boolean enable;
//    private String photos;
//    private LocalDateTime register;

    // create intermediate table
    @ManyToMany
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

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", age=" + age +
                ", enable=" + enable +
                ", role = " + roles +
                '}';
    }
}
