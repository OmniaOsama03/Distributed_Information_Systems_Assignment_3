package com.example.Assig3.service.impl;

import com.example.Assig3.Authdto;
import com.example.Assig3.exception.ResourceNotFoundException;
import com.example.Assig3.model.Auth;
import com.example.Assig3.repository.AuthRepository;
import com.example.Assig3.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImpl implements AuthService
{
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthRepository userRepository;

    @Override
    public Auth save(Authdto userDto) {
        Auth user = new Auth(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword())  , userDto.getRole(), userDto.getFullname());
        return userRepository.save(user);
    }

    @Override
    public Auth getUserByid(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User", "Id", id));
    }

    @Override
    public Auth getUserByEmail(String userEmail) {
        return userRepository.findByEmail(userEmail);
    }
}
