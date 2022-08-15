package com.example.employ.service;

import com.example.employ.configuration.JWTUtil;
import com.example.employ.dto.LoginRequest;
import com.example.employ.dto.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private JWTUtil jwtUtil;

    private final AuthenticationManager authenticationManager;

    public LoginServiceImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    @Override
    public LoginResponse login(LoginRequest login) {

        System.out.println(login.getUsername()+"      "+login.getPassword());

        Map<String,Object> claims=new HashMap<>();

        try {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        claims.put("userId",login.getUsername());

        String token= jwtUtil.generateJwtToken(claims, login.getUsername());

            System.out.println("JWT Token -- "+token);

            return new LoginResponse("SUCCESS",token,"Login successful", login.getUsername());

        }
        catch (BadCredentialsException e) {
            return new LoginResponse("FAILED",null, "Invalid username or password",null);

        } catch (LockedException e) {
            return new LoginResponse("FAILED",null, "Account is locked",null);

        } catch (DisabledException e) {
            return new LoginResponse("FAILED", null,"Account is disabled",null);

        } catch (AuthenticationException e) {
            return new LoginResponse("FAILED", null,"Authentication failed",null);
        }


    }
}
