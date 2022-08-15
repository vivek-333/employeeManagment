package com.example.employ.repository;

import com.example.employ.model.UserLoginData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserLoginDataDao extends JpaRepository<UserLoginData,Long> {

    Optional<UserLoginData> findByUsername(String username);
}
