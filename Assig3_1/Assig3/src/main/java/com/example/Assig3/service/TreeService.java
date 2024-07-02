package com.example.Assig3.service;


import com.example.Assig3.model.Tree;

import java.util.List;

//Omnia Osama Ahmed 1084505
//Maryam Mohammed Ali 1079679
//Nourhan Ahmed Elmehalawy 1078096

public interface TreeService
{
    List<String> getTreesByUserId(Long userId);
    Tree saveTree(Tree tree);

    void deleteTree(Long treeId);

    Tree updateTree(Long treeId, Tree updatedTree);

}
