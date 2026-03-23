package com.shopleft.ecommerce.service.impl;

import java.time.LocalDateTime;
import java.util.List;

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
    public void deleteAllCustomers() {
        customerRepository.deleteAll();
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.getReferenceById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        Customer c = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        c.setFullName(customer.getFullName());
        c.setEmail(customer.getEmail());
        c.setCreatedAt(customer.getCreatedAt());
        c.setPassword(customer.getPassword());
        return customerRepository.save(c);
    }
}
