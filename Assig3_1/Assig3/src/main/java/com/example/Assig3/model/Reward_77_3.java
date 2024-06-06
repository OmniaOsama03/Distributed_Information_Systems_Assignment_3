package com.example.Assig3.model;

import jakarta.persistence.*;
import lombok.Data;

//Omnia Osama Ahmed 1084505
//Maryam Mohammed Ali 1079679
//Nourhan Ahmed Elmehalawy 1078096

@Data
@Entity
public class Reward_77_3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int points;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Auth_77_3 user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Auth_77_3 getUser() {
        return user;
    }

    public void setUser(Auth_77_3 user) {
        this.user = user;
    }
}
