package com.inventariocontrol.Entities;

import com.fasterxml.jackson.annotation.JsonView;
import com.inventariocontrol.Utils.DataType;
import com.inventariocontrol.Utils.Views;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table (name = "attributes", schema = "inventario")
public class AttributesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonView(Views.Detailed.class)
    private UUID id;

    @JsonView(Views.Detailed.class)
    @Column(nullable = false, length = 100)
    private String name;

    @JsonView(Views.Detailed.class)
    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @JsonView(Views.Detailed.class)
    @Column(name = "data_type", nullable = false)
    private DataType dataType;

    @ManyToOne
    @JoinColumn(name = "category_id")
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

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
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
