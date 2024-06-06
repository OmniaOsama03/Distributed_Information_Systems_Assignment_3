package com.example.Assig3.service.impl;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.example.Assig3.exception.ResourceNotFoundException_77_3;
import com.example.Assig3.model.Auth_77_3;
import com.example.Assig3.model.Reward_77_3;
import com.example.Assig3.repository.AuthRepository_77_3;
import com.example.Assig3.repository.RewardRepository_77_3;
import com.example.Assig3.service.RewardService_77_3;
import org.springframework.stereotype.Service;

//Omnia Osama Ahmed 1084505
//Maryam Mohammed Ali 1079679
//Nourhan Ahmed Elmehalawy 1078096

@Service
public class RewardServiceImpl_77_3 implements RewardService_77_3
{
    private AuthRepository_77_3 userRepository;
    private RewardRepository_77_3 rewardRepository;

    public RewardServiceImpl_77_3(RewardRepository_77_3 rewardRepository, AuthRepository_77_3 userRepository) {
        super();
        this.userRepository = userRepository;
        this.rewardRepository = rewardRepository;
    }

    private static final List<String> PLANT_RARITIES = Arrays.asList("Common", "Uncommon", "Rare", "Epic", "Legendary");
    private static final List<Integer> POINTS = Arrays.asList(10, 20, 50, 100, 200);

    @Override
    public Reward_77_3 generateReward(Long userid) {
        // Generate random rarity and corresponding points
        Random random = new Random();
        int index = random.nextInt(PLANT_RARITIES.size());
        String rarity = PLANT_RARITIES.get(index);
        int points = POINTS.get(index);

        Auth_77_3 user = userRepository.findById(userid).orElseThrow(
                () -> new ResourceNotFoundException_77_3("User", "Id", userid));

        // Create new reward
        Reward_77_3 reward = new Reward_77_3();
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
        List<Reward_77_3> allRewards = rewardRepository.findByUserId(userId);
        List<String> rewardInfo = new ArrayList<>();
        
        for (Reward_77_3 reward : allRewards) {
            String rewardString = "Reward ID: " +  reward.getId() +
                    "Reward Description " + reward.getDescription() +
                    "Reward Points: " + reward.getPoints();

            rewardInfo.add(rewardString);
        }
        
        return rewardInfo;
    }
}
