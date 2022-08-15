package com.example.employ.repository;

import com.example.employ.model.Employee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Long> {
    public Employee findById(int id);

}
