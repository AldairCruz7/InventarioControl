package com.inventariocontrol.Entities;

import com.fasterxml.jackson.annotation.JsonView;
import com.inventariocontrol.Utils.Views;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "stock", schema = "inventario")
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonView(Views.Detailed.class)
    private UUID id;

    @JsonView(Views.Detailed.class)
    @Column(name = "qr", length = 100)
    private String qrCode;

    @JsonView(Views.Detailed.class)
    @Column(name = "barcode", length = 100)
    private String barcode;

    @JsonView(Views.Detailed.class)
    @Column(name = "sku", length = 50)
    private String sku;

    @JsonView(Views.Detailed.class)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "registered_date", nullable = false, updatable = false)
    private Date registeredDate;

    @JsonView(Views.Detailed.class)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_updated_date")
    private Date lastUpdatedDate;

    // Relationship with WarehouseEntity in "inventario" schema
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "warehouse_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_stock_warehouse"))
    @JsonView(Views.Detailed.class)
    private WarehouseEntity warehouse;

    // Relationship with InventoryEntity in "inventario" schema
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "inventory_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_stock_inventory"))
    @JsonView(Views.Detailed.class)
    private InventoryEntity inventory;

    // Relationship with SupplierEntity in "inventario" schema
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "supplier_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_stock_supplier"))
    @JsonView(Views.Detailed.class)
    private SupplierEntity supplier;

    // Relationship with UserEntity in "usuario" schema
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "registered_by", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_stock_registered_by"))
    @JsonView(Views.Detailed.class)
    private UserEntity registeredBy;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "updated_by", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_stock_updated_by"))
    @JsonView(Views.Detailed.class)
    private UserEntity updatedBy;

    @PrePersist
    protected void onCreate() {
        this.registeredDate = new Date();
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public WarehouseEntity getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WarehouseEntity warehouse) {
        this.warehouse = warehouse;
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

    public UserEntity getRegisteredBy() {
        return registeredBy;
    }

    public void setRegisteredBy(UserEntity registeredBy) {
        this.registeredBy = registeredBy;
    }

    public UserEntity getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(UserEntity updatedBy) {
        this.updatedBy = updatedBy;
    }
}
