package com.shopleft.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopleft.ecommerce.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
