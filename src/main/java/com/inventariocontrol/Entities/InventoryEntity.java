package com.inventariocontrol.Entities;

import com.fasterxml.jackson.annotation.JsonView;
import com.inventariocontrol.Utils.Views;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "inventory",  schema = "inventario")
public class InventoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonView(Views.Detailed.class)
    private UUID id;

    @JsonView(Views.Detailed.class)
    @Column(nullable = false, length = 255)
    private String name;

    @JsonView(Views.Detailed.class)
    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @JsonView(Views.Detailed.class)
    private CategoryEntity category;

    @JsonView(Views.Detailed.class)
    @Column(nullable = false)
    private Boolean active = true;

    // Getters y Setters
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

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
