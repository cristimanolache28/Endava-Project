package com.endava.project.doctor.service;

import com.endava.project.doctor.entity.Doctor;

import java.util.List;

public interface DoctorService {

    List<Doctor> findAll();

    Doctor saveDoctor(Doctor doctor);

    Doctor getDoctor(Integer id);

    void deleteDoctor(Integer id);
}
