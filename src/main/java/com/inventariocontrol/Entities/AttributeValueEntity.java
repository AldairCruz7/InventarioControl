package com.inventariocontrol.Entities;

import com.fasterxml.jackson.annotation.JsonView;
import com.inventariocontrol.Utils.Views;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "attribute_values", schema = "inventario")
public class AttributeValueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonView(Views.Detailed.class)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "inventory_id", nullable = false)
    @JsonView(Views.Detailed.class)
    private InventoryEntity inventory;

    @ManyToOne
    @JoinColumn(name = "attribute_id", nullable = false)
    @JsonView(Views.Detailed.class)
    private AttributesEntity attribute;

    @JsonView(Views.Detailed.class)
    @Column(nullable = false, length = 255)
    private String value;

    // Getters y Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public InventoryEntity getInventory() {
        return inventory;
    }

    public void setInventory(InventoryEntity inventory) {
        this.inventory = inventory;
    }

    public AttributesEntity getAttribute() {
        return attribute;
    }

    public void setAttribute(AttributesEntity attribute) {
        this.attribute = attribute;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
