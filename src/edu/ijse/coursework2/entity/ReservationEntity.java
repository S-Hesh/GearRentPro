/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.coursework2.entity;

import java.util.Date;

/**
 *
 * @author USER
 */
public class ReservationEntity {
    private String reservationId;
    private String equipmentId;
    private String customerId;
    private String branchId;
    private Date startDate;
    private Date endDate;
    private String status;
    private String createdBy;

    public ReservationEntity() {
    }   

    public ReservationEntity(String reservationId, String equipmentId, String customerId, String branchId, Date startDate, Date endDate, String status, String createdBy) {
        this.reservationId = reservationId;
        this.equipmentId = equipmentId;
        this.customerId = customerId;
        this.branchId = branchId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.createdBy = createdBy;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "ReservationEntity{" + "reservationId=" + reservationId + ", equipmentId=" + equipmentId + ", customerId=" + customerId + ", branchId=" + branchId + ", startDate=" + startDate + ", endDate=" + endDate + ", status=" + status + ", createdBy=" + createdBy + '}';
    }
    
    
}
