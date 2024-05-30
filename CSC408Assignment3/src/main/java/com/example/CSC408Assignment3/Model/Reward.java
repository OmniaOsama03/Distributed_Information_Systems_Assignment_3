package com.example.CSC408Assignment3.Model;

import jakarta.persistence.*;

@Entity
public class Reward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column
    private int points;

    //Thinking:
    //@Column
    //@OneToOne
    //@JoinColumn(name = "tree_id")
    //Tree tree;
}
