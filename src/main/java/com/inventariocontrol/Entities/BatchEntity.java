package com.inventariocontrol.Entities;

import com.fasterxml.jackson.annotation.JsonView;
import com.inventariocontrol.Utils.Views;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "batches")
public class BatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonView(Views.Detailed.class)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "inventory_id", nullable = false, foreignKey = @ForeignKey(name = "fk_batch_inventory"))
    @JsonView(Views.Detailed.class)
    private InventoryEntity inventory;

    @JsonView(Views.Detailed.class)
    @Column(nullable = false)
    private Integer quantity;

    @JsonView(Views.Detailed.class)
    @Temporal(TemporalType.DATE)
    @Column(name = "entry_date", nullable = false, updatable = false)
    private Date entryDate;

    @JsonView(Views.Detailed.class)
    @Temporal(TemporalType.DATE)
    @Column(name = "expiration_date", nullable = true)
    private Date expirationDate;

    @PrePersist
    protected void onCreate() {
        this.entryDate = new Date(); // Set entry date to current date by default
    }

    // Getters and Setters
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
