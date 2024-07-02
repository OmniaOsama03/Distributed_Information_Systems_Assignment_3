package com.example.Assig3.service.impl;

import com.example.Assig3.exception.ResourceNotFoundException;
import com.example.Assig3.model.Auth;
import com.example.Assig3.model.Tree;
import com.example.Assig3.repository.TreeRepository;
import com.example.Assig3.service.AuthService;
import com.example.Assig3.service.RewardService;
import com.example.Assig3.service.TreeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Omnia Osama Ahmed 1084505
//Maryam Mohammed Ali 1079679
//Nourhan Ahmed Elmehalawy 1078096

@Service
public class TreeServiceImpl implements TreeService
{
    private TreeRepository treeRepository;
    private AuthService userService;
    private RewardService rewardService;

    public TreeServiceImpl(TreeRepository treeRepository, AuthService userService, RewardService rewardService) {
        super();
        this.treeRepository = treeRepository;
        this.userService = userService;
        this.rewardService = rewardService;
    }


    @Override
    public Tree saveTree(Tree tree) {
        Auth user = tree.getUser();
        user.getTrees().add(tree);
        rewardService.generateReward(user.getId());
        return treeRepository.save(tree);
    }

    @Override
    public void deleteTree(Long treeId) {
        Tree tree = treeRepository.findById(treeId)
                .orElseThrow(() -> new ResourceNotFoundException("Tree", "id", treeId));

        treeRepository.delete(tree);
    }

    @Override
    public List<String> getTreesByUserId(Long userId) {
        List<Tree> allTrees = treeRepository.findByUserId(userId);
        List<String> treeInfo = new ArrayList<>();

        for (Tree tree : allTrees) {
            String treeString = "Tree ID: " +  tree.getId() +
                    "Tree Location:  " + tree.getLocation() +
                    "Photo: " + tree.getPhoto();

            treeInfo.add(treeString);
        }

        return treeInfo;
    }

    @Override
    public Tree updateTree(Long treeId, Tree updatedTree) {
        Tree tree = treeRepository.findById(treeId)
                .orElseThrow(() -> new ResourceNotFoundException("Tree", "id", treeId));

        // Update tree properties
        tree.setPhoto(updatedTree.getPhoto());
        tree.setPlantingDate(updatedTree.getPlantingDate());
        tree.setLocation(updatedTree.getLocation());

        // Save and return the updated tree
        return treeRepository.save(tree);
    }
}
