package com.inventariocontrol.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String username;
    private String role;
    private String password;

    @Column(unique=true)
    private String email;

    @Column(unique=true, nullable=false, length=10)
    private String cellphoneNumber;

    public UserEntity() {
    }

    public UserEntity (String username, String role, String password, String email, String cellphoneNumber) {
        this.username = username;
        this.role = role;
        this.password = password;
        this.email = email;
        this.cellphoneNumber = cellphoneNumber;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }
}
