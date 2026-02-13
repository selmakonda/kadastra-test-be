package com.example.gisdashboard.model;

import jakarta.persistence.*;

@Entity
@Table(name = "owners", schema = "gis-test")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String personalId;

    // getters & setters
}
