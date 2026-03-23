package com.shopleft.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopleft.ecommerce.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
