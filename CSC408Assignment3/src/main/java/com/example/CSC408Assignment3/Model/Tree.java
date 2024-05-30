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

    @Column
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private String photo;
    @Column
    private Date plantingDate;
    @Column
    private String location;

}
