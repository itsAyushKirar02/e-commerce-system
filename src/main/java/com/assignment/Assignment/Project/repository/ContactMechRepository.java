package com.assignment.Assignment.Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.Assignment.Project.model.ContactMech;

@Repository
public interface ContactMechRepository extends JpaRepository<ContactMech, Integer> {
}
