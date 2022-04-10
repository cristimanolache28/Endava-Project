package com.endava.project.medical_services.controller;

import com.endava.project.doctor.entity.Doctor;
import com.endava.project.doctor.service.DoctorService;
import com.endava.project.doctor.service.impl.DoctorServiceImpl;
import com.endava.project.medical_services.entity.MedicalServiceEntity;
import com.endava.project.medical_services.service.impl.MedicalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/services")
public class MedicalServiceController {

    @Autowired
    private MedicalServiceImpl medicalService;
    @Autowired
    private DoctorServiceImpl doctorService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllMedicalServices(Model model) {
        List<MedicalServiceEntity> medicalServicesList = medicalService.getAll();
        model.addAttribute("medicalServicesList", medicalServicesList);
        return "medicalservices/services";
    }

    @GetMapping("/new")
    public String newMedicalService(Model model) {
        List<Doctor> listDoctors = doctorService.findAll();

        MedicalServiceEntity medicalService = new MedicalServiceEntity();
        medicalService.setAvailable(true);

        model.addAttribute("medicalService", medicalService);
        model.addAttribute("listDoctors", listDoctors);

        return "medicalservices/services_form";
    }
}
