package com.shopleft.ecommerce.model;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   

    @Column(name = "full_name")
    private String fullName;

    private String email;
    private String password;
    private LocalDateTime createdAt;

    //constructor
    Customer() {}
    Customer(String fullName, String email, String password, LocalDateTime createdAt) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
    }

    // getters and setter
    public String getFullName() {return fullName;}
    public void setFullName(String fullName) {this.fullName=fullName;}
    
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email=email;}
    
    public LocalDateTime getCreatedAt() {return createdAt;}
    public void setCreatedAt(LocalDateTime createdAt) {this.createdAt=createdAt;}
    
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password=password;}
}
