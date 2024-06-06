package com.example.Assig3.controller;

import com.example.Assig3.model.Reward_77_3;
import com.example.Assig3.service.RewardService_77_3;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//Omnia Osama Ahmed 1084505
//Maryam Mohammed Ali 1079679
//Nourhan Ahmed Elmehalawy 1078096

@RestController
@RequestMapping("/api/rewards")
public class RewardController_77_3
{
	private RewardService_77_3 rewardService;
	public RewardController_77_3(RewardService_77_3 rewardService) {
	super();
	this.rewardService = rewardService;
	}
	@GetMapping("/{userId}")
	public List<String> getRewardsByUserId(@PathVariable Long userId) {
	return rewardService.getRewardsByUserId(userId);
	}
	}