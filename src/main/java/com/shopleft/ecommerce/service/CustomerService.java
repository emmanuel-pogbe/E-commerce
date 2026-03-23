package com.shopleft.ecommerce.service;


import java.util.List;

import com.shopleft.ecommerce.model.Customer;


public interface CustomerService {
    Customer saveCustomer(Customer customer);

    void deleteAllCustomers();

    Customer getCustomer(Long id);

    List<Customer> getAllCustomers();

    Customer updateCustomer(Long id, Customer customer);

}
