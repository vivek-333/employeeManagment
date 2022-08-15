package com.example.employ.controller;

import com.example.employ.model.Employ;
import com.example.employ.service.Employservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Employcontroller {

     @Autowired
    private Employservices employservices;

    // GET ALL EMPLOYES
    @GetMapping("/employes")
    public ResponseEntity<List<Employ>> getAllEmployes() {
        List<Employ> list = employservices.getAllEmployes();
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    // GET SINGLE EMPLOY
    @GetMapping("/employ/{employId}")
    public ResponseEntity<Employ> getEmploy(@PathVariable Integer employId) {
        Employ employ=employservices.getEmploy(employId);

        if(employ==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return  ResponseEntity.of(Optional.of(employ));
    }

    // ADD NEW EMPLOY
    @PostMapping("newemploye")
    public ResponseEntity<Employ> addEmploy(@RequestBody Employ employ){
        Employ employe=employservices.addEmploy(employ);
        return ResponseEntity.status(HttpStatus.CREATED).body(employe);
    }

    //UPDATE EMPLOY
    @PutMapping("/updateEmploy/{employId}")
    public Employ updateEmploy(@RequestBody Employ employ, @PathVariable long employId){

        return this.employservices.updateEmploy(employ,employId);

    }

    @DeleteMapping("/deleteemploye/{employId}")
    public void deleteEmploye(@PathVariable long employId){
        this.employservices.deleteEmploy(employId);
    }

}
