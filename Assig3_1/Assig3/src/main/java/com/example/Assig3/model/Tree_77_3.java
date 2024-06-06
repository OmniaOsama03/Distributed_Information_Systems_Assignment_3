package com.example.Assig3.model;

import jakarta.persistence.*;
import lombok.Data;


import java.util.Date;

//Omnia Osama Ahmed 1084505
//Maryam Mohammed Ali 1079679
//Nourhan Ahmed Elmehalawy 1078096

@Data
@Entity
public class Tree_77_3 {
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
    private Auth_77_3 user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getPlantingDate() {
        return plantingDate;
    }

    public void setPlantingDate(Date plantingDate) {
        this.plantingDate = plantingDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Auth_77_3 getUser() {
        return user;
    }

    public void setUser(Auth_77_3 user) {
        this.user = user;
    }
}
