package com.shopleft.ecommerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopleft.ecommerce.dto.CreateProductRequest;
import com.shopleft.ecommerce.model.Product;
import com.shopleft.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {    
    private final ProductService productService;
    
    public ProductController(ProductService productService){
        this.productService= productService;
    }

    @PostMapping("/admin/products")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProductByAdmin(request));
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProductDetails(@PathVariable Long productId) {
        return ResponseEntity.ok(productService.getProduct(productId));
    }
}
