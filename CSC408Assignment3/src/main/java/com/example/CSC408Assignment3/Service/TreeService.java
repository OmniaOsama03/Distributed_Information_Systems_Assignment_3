package com.example.CSC408Assignment3.Service;

import com.example.CSC408Assignment3.Model.Tree;

import java.util.List;

public interface TreeService
{
    List<Tree> getTreesByUserId(Long userId);
    Tree saveTree(Tree tree);

    void deleteTree(Long treeId);

    Tree updateTree(Long treeId, Tree updatedTree);

}
