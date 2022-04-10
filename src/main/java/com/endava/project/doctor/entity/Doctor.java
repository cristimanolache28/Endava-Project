package com.endava.project.doctor.entity;

import com.endava.project.category.entity.Category;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data // @ToString, @EqualsAndHashCode, @Getter/@Setter, @RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first name", length = 25, nullable = false, unique = true)
    private String firstName;

    @Column(name = "last name", length = 25, nullable = false, unique = true)
    private String lastName;

    @Column(name = "age", length = 2, nullable = false)
    private int age;

    @Column(name = "experience", length = 2, nullable = false)
    private int experience;

    @ManyToMany
    @JoinTable (
            name = "doctors_categories",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();

    public Doctor(Integer id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }
}
