package com.example.Assig3.service.impl;

import com.example.Assig3.Authdto;
import com.example.Assig3.exception.ResourceNotFoundException_77_3;
import com.example.Assig3.model.Auth_77_3;
import com.example.Assig3.repository.AuthRepository_77_3;
import com.example.Assig3.service.AuthService_77_3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//Omnia Osama Ahmed 1084505
//Maryam Mohammed Ali 1079679
//Nourhan Ahmed Elmehalawy 1078096

@Service
public class AuthServiceImpl_77_3 implements AuthService_77_3
{
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthRepository_77_3 userRepository;

    @Override
    public Auth_77_3 save(Authdto userDto) {
        Auth_77_3 user = new Auth_77_3(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword())  , userDto.getRole(), userDto.getFullname());
        return userRepository.save(user);
    }

    @Override
    public Auth_77_3 getUserByid(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException_77_3("User", "Id", id));
    }

    @Override
    public Auth_77_3 getUserByEmail(String userEmail) {
        return userRepository.findByEmail(userEmail);
    }
}
