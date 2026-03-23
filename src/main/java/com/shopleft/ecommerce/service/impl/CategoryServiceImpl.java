package com.shopleft.ecommerce.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shopleft.ecommerce.dto.CreateCategoryRequest;
import com.shopleft.ecommerce.model.Category;
import com.shopleft.ecommerce.repository.AdminRepository;
import com.shopleft.ecommerce.repository.CategoryRepository;
import com.shopleft.ecommerce.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final AdminRepository adminRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository, AdminRepository adminRepository) {
        this.categoryRepository = categoryRepository;
        this.adminRepository = adminRepository;
    }

    @Override
    public Category createCategoryByAdmin(Long adminId, Category category) {        
        boolean adminExists = adminRepository.existsById(adminId);
        if (!adminExists) {
            throw new RuntimeException("Admin not found");
        }
        return categoryRepository.save(category);
    }

    @Override
    public Category createCategoryByAdmin(CreateCategoryRequest request) {
        Category category = new Category();
        category.setCategoryName(request.getCategoryName());
        category.setCategoryDescription(request.getCategoryDescription());
        return createCategoryByAdmin(request.getAdminId(), category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
