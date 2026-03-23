package com.shopleft.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_price")
    private double productPrice;

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToOne
    private Category category;

    public Product(){}
    public Product(String productName, String productDescription, double productPrice, Category category, boolean isActive) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.category = category;
        this.isActive = isActive;
    }
    // getters and setters
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getProductName() {return productName;}
    public void setProductName(String productName) {this.productName = productName;}

    public String getProductDescription() {return productDescription;}
    public void setProductDescription(String productDescription) {this.productDescription = productDescription;}

    public double getProductPrice() {return productPrice;}
    public void setProductPrice(double productPrice) {this.productPrice = productPrice;}

    public Category getCategory() {return category;}
    public void setCategory(Category category) {this.category = category;}

    public boolean getIsActive() {return isActive;}
    public void setIsActive(boolean isActive) {this.isActive = isActive;}
}
