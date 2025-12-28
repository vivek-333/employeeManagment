package com.example.employ.service;

import com.example.employ.model.Employee;
import com.example.employ.model.UserLoginData;
import com.example.employ.repository.EmployeeDao;
import com.example.employ.repository.UserLoginDataDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployServices {



    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserLoginDataDao userLoginDataDao;

    // get all employes
    @Override
    public List<Employee> getAllEmployes() {
        List<Employee> list=(List<Employee>)this.employeeDao.findAll();
        return list;
    }

    // get employee by id
    @Override
    public Employee getEmploy(Integer employId) {
        Employee employee =null;
       try {
           this.employeeDao.findById(employId);


       } catch (Exception e) {
           e.printStackTrace();
       }
        return employee;
    }

    // add new employee
    @Override
    public Employee addEmploy(Employee employee) {
        Employee newEmployee = employeeDao.save(employee);

        UserLoginData loginData=new UserLoginData();
        loginData.setUsername(employee.getEmail());
        loginData.setPassword(passwordEncoder.encode("admin"));
        loginData.setRole("ADMIN");

        userLoginDataDao.save(loginData);

        return newEmployee;
    }

    // update employee
    @Override
    public Employee updateEmploy(Employee employee, long employId) {
        Employee existing= employeeDao.findById(employId).orElse(null);
        existing.setId(employId);

        this.employeeDao.save(employee);
        return employee;
    }

    @Override
    public Employee deleteEmploy(long employId) {
        this.employeeDao.deleteById(employId);
        return null;
    }

}
