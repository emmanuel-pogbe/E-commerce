package com.shopleft.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "category_description")
    private String categoryDescription;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    // Constructors
    public Category() {}
    public Category(String categoryName, String categoryDescription) {
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }
    
    // getters and setters
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    
    public String getCategoryName() {return categoryName;}
    public void setCategoryName(String categoryName) {this.categoryName = categoryName;}

    public String getCategoryDescription() {return categoryDescription;}
    public void setCategoryDescription(String categoryDescription) {this.categoryDescription = categoryDescription;}

    public List<Product> getProducts() {return products;}
    public void setProducts(List<Product> products) {this.products = products;}   
}
