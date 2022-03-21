package com.endava_project.entity;

import com.sun.istack.NotNull;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;


@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 35, nullable = false, unique = true)
    private String name;

    @Column(length = 150, nullable = false)
    private String description;

    // constructor for initialize the both fields (String description is optional)
    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // constructor for initialize just necessary field (String name)
    public Role(String name) {
        this.name = name;
    }

    // constructor asked for Hibernate
    public Role() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
