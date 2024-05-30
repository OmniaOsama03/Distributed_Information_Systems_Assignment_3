package com.example.CSC408Assignment3.Model;


import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name="Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;

    @Column
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Tree> trees;
    @Column
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Reward> rewards;

}
