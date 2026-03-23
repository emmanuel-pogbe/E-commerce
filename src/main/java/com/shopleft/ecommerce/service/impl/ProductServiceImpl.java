package com.shopleft.ecommerce.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shopleft.ecommerce.dto.CreateProductRequest;
import com.shopleft.ecommerce.model.Category;
import com.shopleft.ecommerce.model.Product;
import com.shopleft.ecommerce.repository.AdminRepository;
import com.shopleft.ecommerce.repository.CategoryRepository;
import com.shopleft.ecommerce.repository.ProductRepository;
import com.shopleft.ecommerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final AdminRepository adminRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, AdminRepository adminRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.adminRepository = adminRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product createProductByAdmin(Long adminId, Long categoryId, Product product) {
        boolean adminExists = adminRepository.existsById(adminId);
        if (!adminExists) {
            throw new RuntimeException("Admin not found");
        }

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        product.setCategory(category);
        return productRepository.save(product);
    }

    @Override
    public Product createProductByAdmin(CreateProductRequest request) {
        Product product = new Product();
        product.setProductName(request.getProductName());
        product.setProductDescription(request.getProductDescription());
        product.setProductPrice(request.getProductPrice());
        product.setIsActive(request.isActive());

        return createProductByAdmin(request.getAdminId(), request.getCategoryId(), product);
    }

    public Product changeProductPrice(Long id, double price){
        Product p = productRepository.findById(id).orElseThrow(()->new RuntimeException());
        p.setProductPrice(price);
        productRepository.save(p);
        return p;
    }
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Product getProduct(Long id) {
        Product p = productRepository.findById(id).orElseThrow(()->new RuntimeException());
        return p;
    }
}