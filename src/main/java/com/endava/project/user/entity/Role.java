package com.endava.project.user.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data // @ToString, @EqualsAndHashCode, @Getter/@Setter, @RequiredArgsConstructor
@NoArgsConstructor
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

    public Role(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
