package com.example.Assig3.service;

import com.example.Assig3.model.Reward;

import java.util.List;

public interface RewardService
{
    public Reward generateReward(Long userId);
    List<String> getRewardsByUserId(Long userId);
}
