package com.example.Assig3.repository;

import com.example.Assig3.model.Reward_77_3;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


//Omnia Osama Ahmed 1084505
//Maryam Mohammed Ali 1079679
//Nourhan Ahmed Elmehalawy 1078096

public interface RewardRepository_77_3 extends JpaRepository<Reward_77_3, Long> {
    List<Reward_77_3> findByUserId(Long userId);
}
