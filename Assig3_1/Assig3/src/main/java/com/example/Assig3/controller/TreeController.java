package com.example.Assig3.controller;


import com.example.Assig3.model.Auth;
import com.example.Assig3.model.Tree;
import com.example.Assig3.service.AuthService;
import com.example.Assig3.service.TreeService;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

//Omnia Osama Ahmed 1084505
//Maryam Mohammed Ali 1079679
//Nourhan Ahmed Elmehalawy 1078096

@RestController
public class TreeController
{
    private TreeService treeService;
    private AuthService userService;

    public TreeController(TreeService treeService, AuthService userService) {
        super();
        this.treeService = treeService;
        this.userService = userService;
    }



    @PostMapping("/add-tree")
    public ResponseEntity<String> addTree(@ModelAttribute Tree treeDto, Authentication authentication) {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        Auth user = userService.getUserByEmail(userEmail);

        if (user != null) {
            // Convert TreeDto to Tree entity
            Tree tree = new Tree();
            tree.setPlantingDate(treeDto.getPlantingDate());
            tree.setLocation(treeDto.getLocation());
            tree.setPhoto(treeDto.getPhoto());

            // Associate the tree with the user
            tree.setUser(user);

            // Save the tree using your service
            treeService.saveTree(tree);

            // Return a success response
            return ResponseEntity.ok("Tree saved successfully!");
        } else {
            // Return an error response if the user is not found
            return ResponseEntity.badRequest().body("User not found");
        }
    }

    @DeleteMapping("/{treeId}")
    public void deleteTree(@PathVariable Long treeId) {
        treeService.deleteTree(treeId);
    }

    @GetMapping("/User/{userId}")
    public List<String> getTreesByUserId(@PathVariable Long userId) {
        return treeService.getTreesByUserId(userId);
    }

    @PutMapping("/{treeId}")
    public Tree updateTree(@PathVariable Long treeId, @RequestBody Tree updatedTree) {
        return treeService.updateTree(treeId, updatedTree);
    }

}
