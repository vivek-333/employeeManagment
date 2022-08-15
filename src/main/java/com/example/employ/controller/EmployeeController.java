package com.example.employ.controller;

import com.example.employ.model.Employee;
import com.example.employ.service.EmployServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")

public class EmployeeController {

    @Autowired
    private EmployServices employservices;

    // GET ALL EMPLOYES
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> list = employservices.getAllEmployes();
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    // GET SINGLE EMPLOY
    @GetMapping("/employee/{employId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer employId) {
        Employee employee =employservices.getEmploy(employId);

        if(employee ==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return  ResponseEntity.of(Optional.of(employee));
    }

    // ADD NEW EMPLOY
    @PostMapping("newEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee employe=employservices.addEmploy(employee);

        return ResponseEntity.status(HttpStatus.CREATED).body(employe);
    }

    //UPDATE EMPLOY
    @PutMapping("/updateEmployee/{employeeId}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable long employId){

        return this.employservices.updateEmploy(employee,employId);

    }

    @DeleteMapping("/deleteEmployee/{employeeId}")
    public void deleteEmployee(@PathVariable long employeeId){
        this.employservices.deleteEmploy(employeeId);
    }

}
