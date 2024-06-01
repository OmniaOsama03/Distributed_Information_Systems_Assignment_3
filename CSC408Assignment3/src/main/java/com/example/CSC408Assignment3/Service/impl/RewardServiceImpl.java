package com.example.CSC408Assignment3.Service.impl;

import com.example.CSC408Assignment3.Exception.ResourceNotFoundException;
import com.example.CSC408Assignment3.Model.Reward;
import com.example.CSC408Assignment3.Model.User;
import com.example.CSC408Assignment3.Repository.RewardRepository;
import com.example.CSC408Assignment3.Repository.UserRepository;
import com.example.CSC408Assignment3.Service.RewardService;
import com.example.CSC408Assignment3.Service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;



@Service
public class RewardServiceImpl implements RewardService
{
    private UserRepository userRepository;
    private RewardRepository rewardRepository;

    public RewardServiceImpl(RewardRepository rewardRepository, UserRepository userRepository) {
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

        User user = userRepository.findById(userid).orElseThrow(
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

    @Override
    public List<Reward> getRewardsByUserId(Long userId) {
        return rewardRepository.findByUserId(userId);
    }
}
