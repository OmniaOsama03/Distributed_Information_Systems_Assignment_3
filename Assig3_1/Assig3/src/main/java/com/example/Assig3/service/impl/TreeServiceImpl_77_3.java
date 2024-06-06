package com.example.Assig3.service.impl;

import com.example.Assig3.exception.ResourceNotFoundException_77_3;
import com.example.Assig3.model.Auth_77_3;
import com.example.Assig3.model.Reward_77_3;
import com.example.Assig3.model.Tree_77_3;
import com.example.Assig3.repository.TreeRepository_77_3;
import com.example.Assig3.service.AuthService_77_3;
import com.example.Assig3.service.RewardService_77_3;
import com.example.Assig3.service.TreeService_77_3;
import org.antlr.v4.runtime.tree.Tree;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Omnia Osama Ahmed 1084505
//Maryam Mohammed Ali 1079679
//Nourhan Ahmed Elmehalawy 1078096

@Service
public class TreeServiceImpl_77_3 implements TreeService_77_3
{
    private TreeRepository_77_3 treeRepository;
    private AuthService_77_3 userService;
    private RewardService_77_3 rewardService;

    public TreeServiceImpl_77_3(TreeRepository_77_3 treeRepository, AuthService_77_3 userService, RewardService_77_3 rewardService) {
        super();
        this.treeRepository = treeRepository;
        this.userService = userService;
        this.rewardService = rewardService;
    }


    @Override
    public Tree_77_3 saveTree(Tree_77_3 tree) {
        Auth_77_3 user = tree.getUser();
        user.getTrees().add(tree);
        rewardService.generateReward(user.getId());
        return treeRepository.save(tree);
    }

    @Override
    public void deleteTree(Long treeId) {
        Tree_77_3 tree = treeRepository.findById(treeId)
                .orElseThrow(() -> new ResourceNotFoundException_77_3("Tree", "id", treeId));

        treeRepository.delete(tree);
    }

    @Override
    public List<String> getTreesByUserId(Long userId) {
        List<Tree_77_3> allTrees = treeRepository.findByUserId(userId);
        List<String> treeInfo = new ArrayList<>();

        for (Tree_77_3 tree : allTrees) {
            String treeString = "Tree ID: " +  tree.getId() +
                    "Tree Location:  " + tree.getLocation() +
                    "Photo: " + tree.getPhoto();

            treeInfo.add(treeString);
        }

        return treeInfo;
    }

    @Override
    public Tree_77_3 updateTree(Long treeId, Tree_77_3 updatedTree) {
        Tree_77_3 tree = treeRepository.findById(treeId)
                .orElseThrow(() -> new ResourceNotFoundException_77_3("Tree", "id", treeId));

        // Update tree properties
        tree.setPhoto(updatedTree.getPhoto());
        tree.setPlantingDate(updatedTree.getPlantingDate());
        tree.setLocation(updatedTree.getLocation());

        // Save and return the updated tree
        return treeRepository.save(tree);
    }
}
