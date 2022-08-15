package com.example.employ.service;

import com.example.employ.repository.UserLoginDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserLoginDataService implements UserDetailsService {

    @Autowired
    private UserLoginDataDao userLoginDataDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userLoginDataDao.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("USer not found"));
    }
}
