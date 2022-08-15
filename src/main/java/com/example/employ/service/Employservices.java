package com.example.employ.service;

import com.example.employ.model.Employee;


import java.util.List;

public interface EmployServices {

    public List<Employee> getAllEmployes();

    public Employee getEmploy(Integer employId);

    public Employee addEmploy(Employee employee);

    public Employee updateEmploy(Employee employee, long employId);

    public Employee deleteEmploy(long employId);
}
