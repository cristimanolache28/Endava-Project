package com.endava.project.category.service.impl;

import com.endava.project.category.entity.Category;
import com.endava.project.category.repository.CategoryRepository;
import com.endava.project.category.service.CategoryService;
import com.endava.project.user.exception.EmptyListFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        List<Category> listCategories = (List<Category>) categoryRepository.findAll();
//        if (listCategories.size() <= 0) {
//            throw new EmptyListFoundException("List is empty.");
//        }
        return listCategories;
    }
}
