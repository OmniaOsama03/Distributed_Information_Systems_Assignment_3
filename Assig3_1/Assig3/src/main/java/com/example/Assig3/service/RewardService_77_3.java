package com.example.Assig3.service;

import com.example.Assig3.model.Reward_77_3;
import org.springframework.http.ResponseEntity;
import java.util.List;

//Omnia Osama Ahmed 1084505
//Maryam Mohammed Ali 1079679
//Nourhan Ahmed Elmehalawy 1078096

public interface RewardService_77_3
{
    public Reward_77_3 generateReward(Long userId);
    List<String> getRewardsByUserId(Long userId);
}
