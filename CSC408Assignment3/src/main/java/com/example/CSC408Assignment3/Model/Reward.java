package com.example.CSC408Assignment3.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Reward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int points;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
