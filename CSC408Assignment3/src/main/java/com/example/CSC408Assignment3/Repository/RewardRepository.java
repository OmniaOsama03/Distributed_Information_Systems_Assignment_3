package com.example.CSC408Assignment3.Repository;

import com.example.CSC408Assignment3.Model.Reward;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RewardRepository extends JpaRepository<Reward, Long> {
    List<Reward> findByUserId(Long userId);
}
