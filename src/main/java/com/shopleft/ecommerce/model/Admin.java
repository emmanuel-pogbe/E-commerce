package com.shopleft.ecommerce.model;

import jakarta.persistence.*;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "admin_name")
    private String adminName;

    @Column(name = "admin_secret")
    private String adminSecret;

    public Admin() {}
    public Admin(String adminName, String adminSecret) {
        this.adminName = adminName;
        this.adminSecret = adminSecret;
    }
    // getters and setters
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getAdminName() {return adminName;}
    public void setAdminName(String adminName) {this.adminName = adminName;}

    public String getAdminSecret() {return adminSecret;}
    public void setAdminSecret(String adminSecret) {this.adminSecret = adminSecret;}
}
