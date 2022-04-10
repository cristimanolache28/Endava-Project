package com.endava.project.doctor.repository;

import com.endava.project.doctor.entity.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.List;

@Repository
public interface DoctorRepository extends PagingAndSortingRepository<Doctor, Integer> {

//    Long countById(Integer id);
//
//    Doctor findByName(String name);

//    @Query("select doctor from Doctor doctor where doctor.firstName like %?1%")
//    public Page<Doctor> findAll(String keyword, Pageable pageable);

//    @Query("select new Doctor(doctor.id, doctor.firstName) from Doctor doctor order by doctor.firstName asc")
//    public List<Doctor> findAll();
}
