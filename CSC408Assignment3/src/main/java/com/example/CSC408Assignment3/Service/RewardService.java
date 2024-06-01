package com.example.CSC408Assignment3.Service;

import com.example.CSC408Assignment3.Model.Reward;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RewardService
{
    public Reward generateReward(Long userId);
    List<Reward> getRewardsByUserId(Long userId);
}
