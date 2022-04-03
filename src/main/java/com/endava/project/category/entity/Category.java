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

    @Column(name = "specialization", length = 30, unique = true, nullable = false)
    private String Specialization;

    @Column(name = "alias", length = 30, nullable = false)
    private String alias;

    @Column(name = "available")
    private boolean available;

    @Column(name = "description", length = 500)
    private String description;

    // Category can have a parent
    @OneToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

    // Category can have some children
    @OneToMany(mappedBy = "parent")
    private Set<Category> children = new HashSet<>();



}
