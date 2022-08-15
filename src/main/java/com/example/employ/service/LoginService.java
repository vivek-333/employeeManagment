package com.example.employ.service;

import com.example.employ.dto.LoginRequest;
import com.example.employ.dto.LoginResponse;

public interface LoginService {
    LoginResponse login(LoginRequest login);
}
