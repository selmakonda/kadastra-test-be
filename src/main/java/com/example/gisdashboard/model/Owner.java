package com.example.gisdashboard.model;

import jakarta.persistence.*;

@Entity
@Table(name = "owners", schema = "gis-test")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "personal_id", nullable = false, unique = true)
    private String personalId;

    @Column(nullable = false, unique = true)
    private String username;  // for login

    @Column(nullable = false)
    private String password;  // hashed password

    // Constructors
    public Owner() {}

    public Owner(String fullName, String personalId, String username, String password) {
        this.fullName = fullName;
        this.personalId = personalId;
        this.username = username;
        this.password = password;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
