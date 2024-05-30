package com.example.CSC408Assignment3.Service.impl;

import com.example.CSC408Assignment3.Model.Tree;
import com.example.CSC408Assignment3.Model.User;
import com.example.CSC408Assignment3.Repository.TreeRepository;
import com.example.CSC408Assignment3.Service.TreeService;
import com.example.CSC408Assignment3.Exception.ResourceNotFoundException;
import com.example.CSC408Assignment3.Service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeServiceImpl implements TreeService
{
    private TreeRepository treeRepository;
    private UserService userService;

    public TreeServiceImpl(TreeRepository treeRepository, UserService userService) {
        super();
        this.treeRepository = treeRepository;
        this.userService = userService;
    }


    @Override
    public Tree saveTree(Tree tree) {
        // Find the user by ID and unwrap the Optional
        User user = userService.getUserByid(tree.getUser().getId());

        // Set the user for the tree
        tree.setUser(user);

        //Adding tree to user's list of trees
        user.getTrees().add(tree);

        // Save and return the tree
        return treeRepository.save(tree);
    }

    @Override
    public void deleteTree(Long treeId) {
        Tree tree = treeRepository.findById(treeId)
                .orElseThrow(() -> new ResourceNotFoundException("Tree", "id", treeId));

        treeRepository.delete(tree);
    }

    @Override
    public List<Tree> getTreesByUserId(Long userId) {
        return treeRepository.findByUserId(userId);
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
