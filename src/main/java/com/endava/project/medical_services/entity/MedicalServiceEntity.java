package com.endava.project.medical_services.entity;

import com.endava.project.category.entity.Category;
import com.endava.project.doctor.entity.Doctor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data // @ToString, @EqualsAndHashCode, @Getter/@Setter, @RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "medical_services")
public class MedicalServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 35, nullable = false)
    private String name;

    @Column(name= "short_description", length = 500)
    private String shortDescription;

    @Column(name= "full_description", length = 150)
    private String fullDescription;

    @Column(name = "created_time")
    private Date createdTime;

    @Column(name = "updated_time")
    private Date updateTime;

    private boolean available;

    private float cost;

    private float price;

    private float discount;

    // a category can have more medical services
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // a doctor can offers more medical services
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

}
