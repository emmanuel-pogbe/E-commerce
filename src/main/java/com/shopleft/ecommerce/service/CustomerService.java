package com.shopleft.ecommerce.service;



import java.util.Map;

import com.shopleft.ecommerce.model.Customer;


public interface CustomerService {
    Customer saveCustomer(Customer customer);

    Map<String, String> deleteAllCustomers();
}
