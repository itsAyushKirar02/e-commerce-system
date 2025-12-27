package com.assignment.Assignment.Project.repository;

 
import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.Assignment.Project.model.OrderHeader;

public interface OrderHeaderRepository extends JpaRepository<OrderHeader, Integer> {
}
