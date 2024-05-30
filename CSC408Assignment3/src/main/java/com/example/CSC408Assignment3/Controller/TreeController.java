package com.example.CSC408Assignment3.Controller;

import com.example.CSC408Assignment3.Service.TreeService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trees")
public class TreeController
{
    private TreeService treeService;

    public TreeController(TreeService treeService) {
        super();
        this.treeService = treeService;
    }
}
