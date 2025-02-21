package com.inventariocontrol.Entities;

import com.fasterxml.jackson.annotation.JsonView;
import com.inventariocontrol.Utils.Views;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "attribute_unit", schema = "inventario")
public class AttributeUnitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonView(Views.Detailed.class)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "attribute_id", nullable = false)
    @JsonView(Views.Detailed.class)
    private AttributesEntity attribute;

    @ManyToOne
    @JoinColumn(name = "unit_id", nullable = false)
    @JsonView(Views.Detailed.class)
    private UnitEntity unit;

    // Getters y Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public AttributesEntity getAttribute() {
        return attribute;
    }

    public void setAttribute(AttributesEntity attribute) {
        this.attribute = attribute;
    }

    public UnitEntity getUnit() {
        return unit;
    }

    public void setUnit(UnitEntity unit) {
        this.unit = unit;
    }
}
