package com.example.employ.helper;

import com.example.employ.model.UserLoginData;
import com.example.employ.repository.UserLoginDataDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    @Bean
    public CommandLineRunner addAdminUser(UserLoginDataDao userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (!userRepository.findByUsername("admin").isPresent()) {
                UserLoginData admin = new UserLoginData();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin"));
                admin.setRole("ROLE_ADMIN");
                userRepository.save(admin);
                System.out.println("Admin user created.");
            } else {
                System.out.println("Admin user already exists.");
            }
        };
    }
}
