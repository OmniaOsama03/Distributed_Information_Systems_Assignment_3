package com.example.Assig3.repository;

import com.example.Assig3.model.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<Auth, Long> {

    Auth findByEmail (String email);
}