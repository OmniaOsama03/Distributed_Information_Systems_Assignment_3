package com.example.Assig3.repository;

import com.example.Assig3.model.Auth_77_3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Omnia Osama Ahmed 1084505
//Maryam Mohammed Ali 1079679
//Nourhan Ahmed Elmehalawy 1078096

@Repository
public interface AuthRepository_77_3 extends JpaRepository<Auth_77_3, Long> {

    Auth_77_3 findByEmail (String email);
}