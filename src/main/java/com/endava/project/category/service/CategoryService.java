package com.endava.project.category.service;


import com.endava.project.category.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Iterable<Category> listCategoriesUsedInForm();

    void listSubCategory(List<Category> listCategoriesForm, Category parent, int subLevel);

    Category save(Category category);

    Category update(Integer id);

    void delete(Integer id);

}
