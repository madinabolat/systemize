package com.example.peachacademy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class User {
    @Id
    private Long id;

    private String username;
    private String passwordHash;
}
