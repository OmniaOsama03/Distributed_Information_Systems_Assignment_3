package com.example.CSC408Assignment3.Controller;

import com.example.CSC408Assignment3.Model.Tree;
import com.example.CSC408Assignment3.Service.TreeService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trees")
public class TreeController
{
    private TreeService treeService;

    public TreeController(TreeService treeService) {
        super();
        this.treeService = treeService;
    }
    @PostMapping
    public Tree addTree(@RequestBody Tree tree) {
        return treeService.saveTree(tree);
    }

    @DeleteMapping("/{treeId}")
    public void deleteTree(@PathVariable Long treeId) {
        treeService.deleteTree(treeId);
    }

    @GetMapping("/User/{userId}")
    public List<Tree> getTreesByUserId(@PathVariable Long userId) {
        return treeService.getTreesByUserId(userId);
    }

    @PutMapping("/{treeId}")
    public Tree updateTree(@PathVariable Long treeId, @RequestBody Tree updatedTree) {
        return treeService.updateTree(treeId, updatedTree);
    }

}
