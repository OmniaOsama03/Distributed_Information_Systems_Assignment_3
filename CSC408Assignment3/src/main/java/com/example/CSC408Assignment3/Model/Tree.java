package com.example.CSC408Assignment3.Model;

import jakarta.persistence.*;
import lombok.Data;


import java.util.Date;

@Data
@Entity
public class Tree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String photo;

    @Column(nullable = false)
    private Date plantingDate;

    @Column(nullable = false)
    private String location;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
