package com.endava.project.category.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "specialization", length = 45,  nullable = false)
    private String specialization;

    @Column(name = "available")
    private boolean available;

    @Column(name = "description", length = 700)
    private String description;

    // Category can have a parent
    @OneToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

    // Category can have some children
    @OneToMany(mappedBy = "parent")
    private Set<Category> children = new HashSet<>();

    public Category(String specialization) {
        this.specialization = specialization;
    }

    public Category(Integer id, String specialization) {
        this.id = id;
        this.specialization = specialization;
    }

    public static Category copyIdAndName(Category category) {
        Category copyCategory = new Category();
        copyCategory.setId(category.getId());
        copyCategory.setSpecialization(category.getSpecialization());
        return copyCategory;
    }

    public static Category copyIdAndName(Integer id, String name) {
        Category copyCategory = new Category();
        copyCategory.setId(id);
        copyCategory.setSpecialization(name);
        return copyCategory;
    }
}
