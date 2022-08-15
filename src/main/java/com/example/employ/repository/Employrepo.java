package com.example.employ.repository;

import com.example.employ.model.Employ;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employrepo extends CrudRepository<Employ , Long> {
    public Employ findById(int id);

}
