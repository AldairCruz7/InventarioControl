package com.inventariocontrol.Entities;

import com.fasterxml.jackson.annotation.JsonView;
import com.inventariocontrol.Utils.Views;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonView(Views.Public.class)
    private UUID id;

    @JsonView(Views.Public.class)
    private String username;

    @JsonView(Views.Public.class)
    private String role;

    @JsonView(Views.Public.class)
    private String email;

    @JsonView(Views.Public.class)
    private String cellphoneNumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "department_id", foreignKey = @ForeignKey(name = "fk_department_id"))
    private DepartmentsEntity department;

    public UserEntity() {}

    public UserEntity(String username, String role, String email, String cellphoneNumber, DepartmentsEntity department) {
        this.username = username;
        this.role = role;
        this.email = email;
        this.cellphoneNumber = cellphoneNumber;
        this.department = department;
    }

    // Getters y Setters
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

    public DepartmentsEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentsEntity department) {
        this.department = department;
    }
}
