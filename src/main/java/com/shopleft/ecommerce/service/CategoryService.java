package com.shopleft.ecommerce.service;

import java.util.List;

import com.shopleft.ecommerce.dto.CreateCategoryRequest;
import com.shopleft.ecommerce.model.Category;

public interface CategoryService {
    Category createCategoryByAdmin(Long adminId, Category category);
    Category createCategoryByAdmin(CreateCategoryRequest request);
    List<Category> getAllCategories();
}
