package com.endava.project.category.service.impl;

import com.endava.project.category.entity.Category;
import com.endava.project.category.exception.CategoryNotFoundException;
import com.endava.project.category.repository.CategoryRepository;
import com.endava.project.category.service.CategoryService;
import com.endava.project.user.exception.EmptyListFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        List<Category> listCategories = (List<Category>) categoryRepository.findAll();
        if (listCategories.size() <= 0) {
            throw new EmptyListFoundException("List is empty.");
        }
        return listCategories;
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Integer id) {
//        return categoryRepository.findById(id).get();
        return categoryRepository.findById(id).orElseThrow(
                () -> new CategoryNotFoundException("Category with id " + id + " not found"));
    }

    @Override
    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> listCategoriesUsedInForm() {
        List<Category> listCategoriesForm = new ArrayList<>();

        Iterable<Category> categories = categoryRepository.findAll();

        for (Category category : categories) {
            if (category.getParent() == null) {
                listCategoriesForm.add(new Category(category.getSpecialization()));

                Set<Category> children = category.getChildren();

                for (Category subCategory : children) {
                    String name = "--" + subCategory.getSpecialization();
                    listCategoriesForm.add(Category.copyIdAndName(subCategory.getId(), name));
                    listSubCategory(listCategoriesForm, subCategory, 1);
                }
            }
        }
        return listCategoriesForm;
    }

    @Override
    public void listSubCategory(List<Category> listCategoriesForm, Category parent, int subLevel) {
        int newSubLevel = subLevel + 1;
        Set<Category> children = parent.getChildren();
        for (Category subCategory : children) {
            String name ="";
            for (int i = 0; i < newSubLevel; i++) {
                name += "--";
            }
            name += subCategory.getSpecialization();
//            listCategoriesForm.add(new Category(name));
            listCategoriesForm.add(Category.copyIdAndName(subCategory.getId(), name));
            listSubCategory(listCategoriesForm, subCategory, newSubLevel);
        }
    }
}
