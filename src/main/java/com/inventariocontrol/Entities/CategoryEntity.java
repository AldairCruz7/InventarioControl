package com.inventariocontrol.Entities;

import com.fasterxml.jackson.annotation.JsonView;
import com.inventariocontrol.Utils.Views;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "category",  schema = "inventario")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonView(Views.Detailed.class)
    private UUID id;

    @JsonView(Views.Detailed.class)
    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @JsonView(Views.Detailed.class)
    @Column(columnDefinition = "TEXT")
    private String description;

    @JsonView(Views.Detailed.class)
    @Column(nullable = false)
    private Boolean active = true;

    // Relación jerárquica de categorías (Categoría Padre)
    @ManyToOne
    @JoinColumn(name = "parent_category_id")
    @JsonView(Views.Detailed.class)
    private CategoryEntity parentCategory;

    // Relación bidireccional para obtener subcategorías
    @OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CategoryEntity> subcategories;

    // Relación con productos del inventario
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InventoryEntity> inventoryItems;

    // Getters and Setters
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

    public CategoryEntity getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(CategoryEntity parentCategory) {
        this.parentCategory = parentCategory;
    }

    public List<CategoryEntity> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<CategoryEntity> subcategories) {
        this.subcategories = subcategories;
    }

    public List<InventoryEntity> getInventoryItems() {
        return inventoryItems;
    }

    public void setInventoryItems(List<InventoryEntity> inventoryItems) {
        this.inventoryItems = inventoryItems;
    }
}
