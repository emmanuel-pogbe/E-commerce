package com.shopleft.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopleft.ecommerce.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
