package com.example.Assig3.service;


import com.example.Assig3.Authdto;
import com.example.Assig3.model.Auth;

public interface AuthService
{
    Auth save(Authdto userDto);
    Auth getUserByid(Long userId);
    Auth getUserByEmail(String userEmail);
}
