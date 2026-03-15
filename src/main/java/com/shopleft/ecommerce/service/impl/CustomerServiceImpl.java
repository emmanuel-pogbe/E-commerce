package com.shopleft.ecommerce.service.impl;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopleft.ecommerce.model.Customer;
import com.shopleft.ecommerce.repository.CustomerRepository;
import com.shopleft.ecommerce.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        LocalDateTime time = LocalDateTime.now(); // Get current time
        customer.setCreatedAt(time);
        return customerRepository.save(customer);
    }

    @Override
    public Map<String, String> deleteAllCustomers() {
        customerRepository.deleteAll();
        return Map.of("Status","Success");
    }
}
