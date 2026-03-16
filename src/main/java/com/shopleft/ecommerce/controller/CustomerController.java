package com.shopleft.ecommerce.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.shopleft.ecommerce.model.Customer;
import com.shopleft.ecommerce.service.CustomerService;

@RestController
@RequestMapping("api/customer")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = {RequestMethod.POST})
    public ResponseEntity<Customer> newCustomer(@RequestBody Customer c) {
        Customer result = customerService.saveCustomer(c);
        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete-all")
    public ResponseEntity<HttpStatus> deleteAllCustomers() {
        customerService.deleteAllCustomers();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
