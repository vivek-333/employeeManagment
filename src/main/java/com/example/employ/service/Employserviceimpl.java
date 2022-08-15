package com.example.employ.service;

import com.example.employ.model.Employ;
import com.example.employ.repository.Employrepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Employserviceimpl implements Employservices{



    @Autowired
    private Employrepo employrepo;

    // get all employes
    @Override
    public List<Employ> getAllEmployes() {
        List<Employ> list=(List<Employ>)this.employrepo.findAll();
        return list;
    }

    // get employee by id
    @Override
    public Employ getEmploy(Integer employId) {
        Employ employ=null;
       try {
           this.employrepo.findById(employId);


       } catch (Exception e) {
           e.printStackTrace();
       }
        return employ;
    }

    // add new employee
    @Override
    public Employ addEmploy(Employ employ) {
        Employ newEmploy=employrepo.save(employ);
        
        return newEmploy;
    }

    // update employee
    @Override
    public Employ updateEmploy(Employ employ, long employId) {
        Employ existing=employrepo.findById(employId).orElse(null);
        existing.setId(employId);

        this.employrepo.save(employ);
        return employ;
    }

    @Override
    public Employ deleteEmploy(long employId) {
        this.employrepo.deleteById(employId);
        return null;
    }

}
