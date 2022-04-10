package com.endava.project.medical_services.service.impl;

import com.endava.project.medical_services.repository.MedicalServiceRepository;
import com.endava.project.medical_services.entity.MedicalServiceEntity;
import com.endava.project.medical_services.service.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalServiceImpl implements MedicalService {

    @Autowired
    private MedicalServiceRepository medServiceRepo;

    @Override
    public List<MedicalServiceEntity> getAll() {
        return medServiceRepo.findAll();
    }
}
