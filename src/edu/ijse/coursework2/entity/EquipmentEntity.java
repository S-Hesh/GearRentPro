/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.coursework2.entity;

/**
 *
 * @author USER
 */
public class EquipmentEntity {
    private String equipmentId;
    private String categoryId;
    private String branchId;
    private String brand;
    private String model;
    private int purchaseYear;
    private double basePricePerDay;
    private double securityDeposit;
    private String status;
    private boolean isActive;

    // Getters and Setters

    public EquipmentEntity() {}

    public EquipmentEntity(String equipmentId, String categoryId, String branchId, String brand, String model, int purchaseYear, double basePricePerDay, double securityDeposit, String status, boolean isActive) {
        this.equipmentId = equipmentId;
        this.categoryId = categoryId;
        this.branchId = branchId;
        this.brand = brand;
        this.model = model;
        this.purchaseYear = purchaseYear;
        this.basePricePerDay = basePricePerDay;
        this.securityDeposit = securityDeposit;
        this.status = status;
        this.isActive = isActive;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPurchaseYear() {
        return purchaseYear;
    }

    public void setPurchaseYear(int purchaseYear) {
        this.purchaseYear = purchaseYear;
    }

    public double getBasePricePerDay() {
        return basePricePerDay;
    }

    public void setBasePricePerDay(double basePricePerDay) {
        this.basePricePerDay = basePricePerDay;
    }

    public double getSecurityDeposit() {
        return securityDeposit;
    }

    public void setSecurityDeposit(double securityDeposit) {
        this.securityDeposit = securityDeposit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "EquipmentEntity{" + "equipmentId=" + equipmentId + ", categoryId=" + categoryId + ", branchId=" + branchId + ", brand=" + brand + ", model=" + model + ", purchaseYear=" + purchaseYear + ", basePricePerDay=" + basePricePerDay + ", securityDeposit=" + securityDeposit + ", status=" + status + ", isActive=" + isActive + '}';
    }
    
    
}
