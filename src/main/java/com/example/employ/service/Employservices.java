package com.example.employ.service;

import com.example.employ.model.Employ;


import java.util.List;

public interface Employservices {

    public List<Employ> getAllEmployes();

    public Employ getEmploy(Integer employId);

    public Employ addEmploy(Employ employ);

    public Employ updateEmploy(Employ employ, long employId);

    public Employ deleteEmploy(long employId);
}
