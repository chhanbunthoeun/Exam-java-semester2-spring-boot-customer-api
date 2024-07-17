package com.example.rest_api.repository;

import com.example.rest_api.model.customerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface customerRepository extends JpaRepository<customerModel, Long> {
    // Define custom query methods if needed
}