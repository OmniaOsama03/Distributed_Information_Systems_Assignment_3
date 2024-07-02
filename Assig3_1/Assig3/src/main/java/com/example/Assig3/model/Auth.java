package com.example.Assig3.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String email;//unique
    private String password;
    @Column
    private String role;

    @Column
    private String fullname;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Tree> trees;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Reward> rewards;

    public Auth() {
        super();
    }

    public Auth(String email, String password, String role, String fullname) {
        super();
        this.email = email;
        this.password = password;
        this.role = role;
        this.fullname = fullname;
        this.trees = new ArrayList<>();
        this.rewards = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public List<Tree> getTrees() {
        return trees;
    }

    public void setTrees(List<Tree> trees) {
        this.trees = trees;
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public void setRewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

}
