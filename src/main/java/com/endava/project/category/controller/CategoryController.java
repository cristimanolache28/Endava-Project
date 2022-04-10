package com.endava.project.category.controller;

import com.endava.project.category.entity.Category;
import com.endava.project.category.exception.CategoryNotFoundException;
import com.endava.project.category.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping
    public String getCategoriesList(Model model) {
        List<Category> listCategories = categoryService.findAll();
        model.addAttribute("listCategories", listCategories);
        return "categories/categories";
    }

    @GetMapping(value = "/new")
    public String addNewCategory(Model model) {
        List<Category> listCategories = (List<Category>) categoryService.listCategoriesUsedInForm();
        model.addAttribute("listCategories",listCategories);
        model.addAttribute("category", new Category());
        return "categories/category_form";
    }

    @PostMapping("/save")
    public String saveCategory(Category category) {
        categoryService.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/edit/{id}")
    public String updateCategory(@PathVariable(name = "id") Integer id,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {
        try{
            Category category = categoryService.update(id);
            List<Category> listCategories = categoryService.listCategoriesUsedInForm();
            model.addAttribute("category", category);
            model.addAttribute("listCategories", listCategories);

            return "categories/update_user";
        } catch (CategoryNotFoundException ex) {
            redirectAttributes.addFlashAttribute("message", "Category with id " + id + " not found.");
            return "redirect:/categories";
        }
    }

    @GetMapping ("/delete/{id}")
    public String deleteCategoryById(@PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "Category deleted.");
        categoryService.delete(id);
        return "redirect:/categories";
    }

}
