package com.example.Assig3.service;


import com.example.Assig3.model.Tree_77_3;

import java.util.List;

//Omnia Osama Ahmed 1084505
//Maryam Mohammed Ali 1079679
//Nourhan Ahmed Elmehalawy 1078096

public interface TreeService_77_3
{
    List<String> getTreesByUserId(Long userId);
    Tree_77_3 saveTree(Tree_77_3 tree);

    void deleteTree(Long treeId);

    Tree_77_3 updateTree(Long treeId, Tree_77_3 updatedTree);

}
