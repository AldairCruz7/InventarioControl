package com.inventariocontrol.Entities;

import com.fasterxml.jackson.annotation.JsonView;
import com.inventariocontrol.Utils.Views;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "inventory_suppliers", schema = "inventario")
public class InventorySupplierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonView(Views.Detailed.class)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "inventory_id", nullable = false)
    @JsonView(Views.Detailed.class)
    private InventoryEntity inventory;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    @JsonView(Views.Detailed.class)
    private SupplierEntity supplier;

    @JsonView(Views.Detailed.class)
    @Column(precision = 10, scale = 2)
    private BigDecimal price;

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

    public SupplierEntity getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierEntity supplier) {
        this.supplier = supplier;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
