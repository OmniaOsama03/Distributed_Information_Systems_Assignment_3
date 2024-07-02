package com.example.Assig3.controller;

import com.example.Assig3.service.RewardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/api/rewards")
public class RewardController
{
	private RewardService rewardService;
	public RewardController(RewardService rewardService) {
	super();
	this.rewardService = rewardService;
	}
	@GetMapping("/{userId}")
	public List<String> getRewardsByUserId(@PathVariable Long userId) {
	return rewardService.getRewardsByUserId(userId);
	}
	}