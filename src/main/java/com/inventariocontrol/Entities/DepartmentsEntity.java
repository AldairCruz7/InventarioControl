package com.inventariocontrol.Entities;

import com.fasterxml.jackson.annotation.JsonView;
import com.inventariocontrol.Utils.Views;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "departments")
public class DepartmentsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonView(Views.Detailed.class) // Solo mostrar en vista detallada
    private UUID id;

    @JsonView(Views.Detailed.class)
    private String name;

    @JsonView(Views.Detailed.class)
    private String description;

    @JsonView(Views.Detailed.class)
    private Boolean active;

    // Getters y setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
