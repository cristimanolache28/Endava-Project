package com.endava.project.medical_services.repository;

import com.endava.project.medical_services.entity.MedicalServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalServiceRepository extends JpaRepository<MedicalServiceEntity, Integer> {
}
