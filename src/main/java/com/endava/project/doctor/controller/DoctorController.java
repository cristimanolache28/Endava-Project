package com.endava.project.doctor.controller;

import com.endava.project.category.entity.Category;
import com.endava.project.category.service.impl.CategoryServiceImpl;
import com.endava.project.doctor.entity.Doctor;
import com.endava.project.doctor.service.impl.DoctorServiceImpl;
import com.endava.project.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorServiceImpl doctorService;

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllDoctors(Model model) {
        List<Doctor> doctorsList = doctorService.findAll();
        model.addAttribute("doctorsList", doctorsList);
        return "doctors/doctors";
    }

    @GetMapping (value = "/new", produces = MediaType.APPLICATION_JSON_VALUE)
    public String addNewDoctor(Model model) {
        List<Category> listCategories = categoryService.listCategoriesUsedInForm();

        model.addAttribute("listCategories", listCategories);
        model.addAttribute("doctor", new Doctor());

        return "doctors/doctor_form";
    }

    @PostMapping(value = "/save")
    public String saveDoctor(Doctor doctor, RedirectAttributes redirectAttributes) {
        System.out.println(doctor);
        doctorService.saveDoctor(doctor);
        redirectAttributes.addFlashAttribute("message", "Success");
        return "redirect:/doctors";
    }

    @GetMapping(value = "/edit/{id}")
    public String updateDoctor(@PathVariable(name = "id") Integer id, Model model,
                               RedirectAttributes redirectAttributes) {
        Doctor doctor = doctorService.getDoctor(id);
        List<Category> listSpecializations = categoryService.listCategoriesUsedInForm();

        model.addAttribute("doctor", doctor);
        model.addAttribute("listSpecializations", listSpecializations);
        return "doctors/update_doctor";

    }

    @GetMapping(value = "/delete/{id}")
    public String deleteDoctorById(@PathVariable(name = "id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        doctorService.deleteDoctor(id);
        return "redirect:/doctors";
    }

}
