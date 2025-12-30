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
public class RentalEntity {
    private String rentalId;
    private String reservationId; // Can be null
    private String equipmentId;
    private String customerId;
    private String branchId;
    private Date startDate;
    private Date endDate;
    private double calculatedRentalAmount;
    private double membershipDiscount;
    private double longRentalDiscount;
    private double finalPayableAmount;
    private double securityDeposit;
    private double amountPaid;
    private String paymentStatus;
    private String rentalStatus;
    private String issuedBy;
    
    // Return & Settlement fields (Initially null/0)
    private Date actualReturnDate;
    private int lateDays;
    private double lateFeeAmount;
    private String damageDescription;
    private double damageCharge;
    private double totalCharges;
    private double refundAmount;
    
    public RentalEntity() {} 
    
    // Constructor specifically for PLACING a new rental (16 arguments)
    public RentalEntity(String rentalId, String reservationId, String equipmentId, String customerId, String branchId, Date startDate, Date endDate, double calculatedRentalAmount, double membershipDiscount, double longRentalDiscount, double finalPayableAmount, double securityDeposit, double amountPaid, String paymentStatus, String rentalStatus, String issuedBy) {
        this.rentalId = rentalId;
        this.reservationId = reservationId;
        this.equipmentId = equipmentId;
        this.customerId = customerId;
        this.branchId = branchId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.calculatedRentalAmount = calculatedRentalAmount;
        this.membershipDiscount = membershipDiscount;
        this.longRentalDiscount = longRentalDiscount;
        this.finalPayableAmount = finalPayableAmount;
        this.securityDeposit = securityDeposit;
        this.amountPaid = amountPaid;
        this.paymentStatus = paymentStatus;
        this.rentalStatus = rentalStatus;
        this.issuedBy = issuedBy;
    }

    public RentalEntity(String rentalId, String reservationId, String equipmentId, String customerId, String branchId, Date startDate, Date endDate, double calculatedRentalAmount, double membershipDiscount, double longRentalDiscount, double finalPayableAmount, double securityDeposit, double amountPaid, String paymentStatus, String rentalStatus, String issuedBy, Date actualReturnDate, int lateDays, double lateFeeAmount, String damageDescription, double damageCharge, double totalCharges, double refundAmount) {
        this.rentalId = rentalId;
        this.reservationId = reservationId;
        this.equipmentId = equipmentId;
        this.customerId = customerId;
        this.branchId = branchId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.calculatedRentalAmount = calculatedRentalAmount;
        this.membershipDiscount = membershipDiscount;
        this.longRentalDiscount = longRentalDiscount;
        this.finalPayableAmount = finalPayableAmount;
        this.securityDeposit = securityDeposit;
        this.amountPaid = amountPaid;
        this.paymentStatus = paymentStatus;
        this.rentalStatus = rentalStatus;
        this.issuedBy = issuedBy;
        this.actualReturnDate = actualReturnDate;
        this.lateDays = lateDays;
        this.lateFeeAmount = lateFeeAmount;
        this.damageDescription = damageDescription;
        this.damageCharge = damageCharge;
        this.totalCharges = totalCharges;
        this.refundAmount = refundAmount;
    }

    public String getRentalId() {
        return rentalId;
    }

    public void setRentalId(String rentalId) {
        this.rentalId = rentalId;
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

    public double getCalculatedRentalAmount() {
        return calculatedRentalAmount;
    }

    public void setCalculatedRentalAmount(double calculatedRentalAmount) {
        this.calculatedRentalAmount = calculatedRentalAmount;
    }

    public double getMembershipDiscount() {
        return membershipDiscount;
    }

    public void setMembershipDiscount(double membershipDiscount) {
        this.membershipDiscount = membershipDiscount;
    }

    public double getLongRentalDiscount() {
        return longRentalDiscount;
    }

    public void setLongRentalDiscount(double longRentalDiscount) {
        this.longRentalDiscount = longRentalDiscount;
    }

    public double getFinalPayableAmount() {
        return finalPayableAmount;
    }

    public void setFinalPayableAmount(double finalPayableAmount) {
        this.finalPayableAmount = finalPayableAmount;
    }

    public double getSecurityDeposit() {
        return securityDeposit;
    }

    public void setSecurityDeposit(double securityDeposit) {
        this.securityDeposit = securityDeposit;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getRentalStatus() {
        return rentalStatus;
    }

    public void setRentalStatus(String rentalStatus) {
        this.rentalStatus = rentalStatus;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public Date getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(Date actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }

    public int getLateDays() {
        return lateDays;
    }

    public void setLateDays(int lateDays) {
        this.lateDays = lateDays;
    }

    public double getLateFeeAmount() {
        return lateFeeAmount;
    }

    public void setLateFeeAmount(double lateFeeAmount) {
        this.lateFeeAmount = lateFeeAmount;
    }

    public String getDamageDescription() {
        return damageDescription;
    }

    public void setDamageDescription(String damageDescription) {
        this.damageDescription = damageDescription;
    }

    public double getDamageCharge() {
        return damageCharge;
    }

    public void setDamageCharge(double damageCharge) {
        this.damageCharge = damageCharge;
    }

    public double getTotalCharges() {
        return totalCharges;
    }

    public void setTotalCharges(double totalCharges) {
        this.totalCharges = totalCharges;
    }

    public double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(double refundAmount) {
        this.refundAmount = refundAmount;
    }

    @Override
    public String toString() {
        return "RentalEntity{" + "rentalId=" + rentalId + ", reservationId=" + reservationId + ", equipmentId=" + equipmentId + ", customerId=" + customerId + ", branchId=" + branchId + ", startDate=" + startDate + ", endDate=" + endDate + ", calculatedRentalAmount=" + calculatedRentalAmount + ", membershipDiscount=" + membershipDiscount + ", longRentalDiscount=" + longRentalDiscount + ", finalPayableAmount=" + finalPayableAmount + ", securityDeposit=" + securityDeposit + ", amountPaid=" + amountPaid + ", paymentStatus=" + paymentStatus + ", rentalStatus=" + rentalStatus + ", issuedBy=" + issuedBy + ", actualReturnDate=" + actualReturnDate + ", lateDays=" + lateDays + ", lateFeeAmount=" + lateFeeAmount + ", damageDescription=" + damageDescription + ", damageCharge=" + damageCharge + ", totalCharges=" + totalCharges + ", refundAmount=" + refundAmount + '}';
    }
    
    
}
