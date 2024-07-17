package com.example.rest_api.service;

import com.example.rest_api.model.customerModel;
import com.example.rest_api.repository.customerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class customerService {
    @Autowired
    private customerRepository cusRepository;

    public customerModel addCustomer(customerModel customer) {
        return cusRepository.save(customer);
    }

    public customerModel getCustomerById(Long id) {
        Optional<customerModel> optionalCustomer = cusRepository.findById(id);
        return optionalCustomer.orElse(null);
    }

    public List<customerModel> getAllCustomers() {
        return cusRepository.findAll();
    }

    public customerModel updateCustomer(Long id, customerModel updatedCustomer) {
        Optional<customerModel> optionalCustomer = cusRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            updatedCustomer.setId(id);
            return cusRepository.save(updatedCustomer);
        }
        return null; // Handle not found case appropriately
    }
    public void deleteCustomer(Long id) {
        cusRepository.deleteById(id);
    }
}
