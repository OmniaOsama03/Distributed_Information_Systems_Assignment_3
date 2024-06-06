package com.example.Assig3.service;


import com.example.Assig3.Authdto;
import com.example.Assig3.model.Auth_77_3;

//Omnia Osama Ahmed 1084505
//Maryam Mohammed Ali 1079679
//Nourhan Ahmed Elmehalawy 1078096

public interface AuthService_77_3
{
    Auth_77_3 save(Authdto userDto);
    Auth_77_3 getUserByid(Long userId);
    Auth_77_3 getUserByEmail(String userEmail);
}
