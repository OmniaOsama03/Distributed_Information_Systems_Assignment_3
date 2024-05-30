package com.example.CSC408Assignment3.Repository;

import com.example.CSC408Assignment3.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    //User findByUsername(String username);
}
