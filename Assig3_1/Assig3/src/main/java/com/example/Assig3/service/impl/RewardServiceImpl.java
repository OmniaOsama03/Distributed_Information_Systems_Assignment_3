package com.example.Assig3.service.impl;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.example.Assig3.exception.ResourceNotFoundException;
import com.example.Assig3.model.Auth;
import com.example.Assig3.model.Reward;
import com.example.Assig3.repository.AuthRepository;
import com.example.Assig3.repository.RewardRepository;
import com.example.Assig3.service.RewardService;
import org.springframework.stereotype.Service;

@Service
public class RewardServiceImpl implements RewardService
{
    private AuthRepository userRepository;
    private RewardRepository rewardRepository;

    public RewardServiceImpl(RewardRepository rewardRepository, AuthRepository userRepository) {
        super();
        this.userRepository = userRepository;
        this.rewardRepository = rewardRepository;
    }

    private static final List<String> PLANT_RARITIES = Arrays.asList("Common", "Uncommon", "Rare", "Epic", "Legendary");
    private static final List<Integer> POINTS = Arrays.asList(10, 20, 50, 100, 200);

    @Override
    public Reward generateReward(Long userid) {
        // Generate random rarity and corresponding points
        Random random = new Random();
        int index = random.nextInt(PLANT_RARITIES.size());
        String rarity = PLANT_RARITIES.get(index);
        int points = POINTS.get(index);

        Auth user = userRepository.findById(userid).orElseThrow(
                () -> new ResourceNotFoundException("User", "Id", userid));

        // Create new reward
        Reward reward = new Reward();
        reward.setDescription("Tree of rarity: " + rarity);
        reward.setPoints(points);
        reward.setUser(user);

        // Save reward to repository
        rewardRepository.save(reward);

        // Add reward to user's rewards list
        user.getRewards().add(reward);

        return reward;
    }

	/*
	 * @Override public List<Reward_77_3> getRewardsByUserId(Long userId) { return
	 * rewardRepository.findByUserId(userId); }
	 */
    public List<String> getRewardsByUserId(Long userId) {
        List<Reward> allRewards = rewardRepository.findByUserId(userId);
        List<String> rewardInfo = new ArrayList<>();
        
        for (Reward reward : allRewards) {
            String rewardString = "Reward ID: " +  reward.getId() +
                    "Reward Description " + reward.getDescription() +
                    "Reward Points: " + reward.getPoints();

            rewardInfo.add(rewardString);
        }
        
        return rewardInfo;
    }
}
