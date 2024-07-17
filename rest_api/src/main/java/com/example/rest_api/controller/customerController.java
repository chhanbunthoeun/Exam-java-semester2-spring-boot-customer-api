package com.example.rest_api.controller;

import com.example.rest_api.model.customerModel;
import com.example.rest_api.service.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class customerController {
      private customerService cusService = new customerService();
    @Autowired
    public customerController(customerService cusService) {
        this.cusService = cusService;
    }

    @PostMapping
    public customerModel addCustomer(@RequestBody customerModel customer) {
        customerModel customerModel = cusService.addCustomer(customer);
        return customerModel;
    }

    @GetMapping("/{id}")
    public customerModel getCustomerById(@PathVariable Long id) {
        customerModel customer = new customerModel();
        customer = cusService.getCustomerById(id);
        return customer;
    }

    // Endpoint for getting all customers
    @GetMapping
    public List<customerModel> getAllCustomers() {
        List<customerModel> customers = cusService.getAllCustomers();
        return customers;
    }

    // Endpoint for updating a customer by ID
    @PutMapping("/{id}")
    public customerModel updateCustomer(@PathVariable Long id, @RequestBody customerModel updatedCustomer) {
        customerModel customer = cusService.updateCustomer(id, updatedCustomer);
        if(customer != null) {
            return customer;
        }
        return null; // Handle not found case appropriately
    }
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        cusService.deleteCustomer(id);
    }
}
