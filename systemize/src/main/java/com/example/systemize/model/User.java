package com.example.systemize.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name="dummytabletest")
public class User {
    @Id
    private long id;

    private String username;
    private String passwordHash;
}