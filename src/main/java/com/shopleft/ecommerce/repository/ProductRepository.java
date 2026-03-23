package com.shopleft.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopleft.ecommerce.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
