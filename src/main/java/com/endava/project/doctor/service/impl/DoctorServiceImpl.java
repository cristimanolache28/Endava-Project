package com.endava.project.doctor.service.impl;

import com.endava.project.doctor.entity.Doctor;
import com.endava.project.doctor.exception.DoctorNotFoundException;
import com.endava.project.doctor.exception.DoctorsListEmptyException;
import com.endava.project.doctor.repository.DoctorRepository;
import com.endava.project.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Doctor> findAll() {
        List<Doctor> listDoctors = (List<Doctor>) doctorRepository.findAll();
        if(listDoctors.size() <= 0) {
            throw new DoctorsListEmptyException("Doctors list empty.");
        }
        return listDoctors;
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor getDoctor(Integer id) {
        return doctorRepository.findById(id).orElseThrow(() ->
                new DoctorNotFoundException("The doctor with " + id + " not found."));
    }

    @Override
    public void deleteDoctor(Integer id) {
        if (id == null) {
            throw new DoctorNotFoundException("The doctor with " + id + " not found.");
        }
        Doctor doctor = doctorRepository.findById(id).get();
        doctorRepository.delete(doctor);
    }
}
