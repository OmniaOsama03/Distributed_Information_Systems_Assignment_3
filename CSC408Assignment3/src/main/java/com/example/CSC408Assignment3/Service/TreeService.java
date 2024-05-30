package com.example.CSC408Assignment3.Service;

import com.example.CSC408Assignment3.Model.Tree;

import java.util.List;

public interface TreeService
{
    List<Tree> getTreesByUserId(long userId);
}
