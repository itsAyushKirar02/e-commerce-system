package com.assignment.Assignment.Project.repository;

 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.Assignment.Project.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    
}
