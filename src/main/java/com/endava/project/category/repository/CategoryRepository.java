package com.endava.project.category.repository;

import com.endava.project.category.entity.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

// I am using PagingAndSortingRepository becouse it provides me methods to do pagination and sorting records
@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer> {

}
