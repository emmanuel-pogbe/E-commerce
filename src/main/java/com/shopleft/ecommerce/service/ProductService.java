package com.shopleft.ecommerce.service;

import java.util.List;

import com.shopleft.ecommerce.dto.CreateProductRequest;
import com.shopleft.ecommerce.model.Product;

public interface ProductService {
    Product createProduct(Product product);
    Product createProductByAdmin(Long adminId, Long categoryId, Product product);
    Product createProductByAdmin(CreateProductRequest request);
    Product changeProductPrice(Long id, double price);
    void deleteProduct(Product product);
    List<Product> getAllProducts();
    Product getProduct(Long id);
}
