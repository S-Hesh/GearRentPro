/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.coursework2.dao.custom.impl;

import edu.ijse.coursework2.dao.CrudUtil;
import edu.ijse.coursework2.dao.custom.RentalDao;
import edu.ijse.coursework2.entity.RentalEntity;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author USER
 */
public class RentalDaoImpl implements RentalDao{

    @Override
    public boolean save(RentalEntity entity) throws Exception {
        String sql = "INSERT INTO rental (rental_id, reservation_id, equipment_id, customer_id, branch_id, start_date, end_date, "
                   + "calculated_rental_amount, membership_discount_amount, long_rental_discount_amount, final_payable_amount, "
                   + "security_deposit, amount_paid, payment_status, rental_status, issued_by) "
                   + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        return CrudUtil.executeUpdate(sql,
                entity.getRentalId(),
                entity.getReservationId(), // Can be null, CrudUtil handles it if you pass null
                entity.getEquipmentId(),
                entity.getCustomerId(),
                entity.getBranchId(),
                new java.sql.Date(entity.getStartDate().getTime()),
                new java.sql.Date(entity.getEndDate().getTime()),
                entity.getCalculatedRentalAmount(),
                entity.getMembershipDiscount(),
                entity.getLongRentalDiscount(),
                entity.getFinalPayableAmount(),
                entity.getSecurityDeposit(),
                entity.getAmountPaid(),
                entity.getPaymentStatus(),
                entity.getRentalStatus(),
                entity.getIssuedBy()
        );
    }

    @Override
    public boolean update(RentalEntity entity) throws Exception {
        // This is mainly for RETURNS (updating status and return details)
        String sql = "UPDATE rental SET actual_return_date=?, late_days=?, late_fee_amount=?, damage_description=?, "
                   + "damage_charge=?, total_charges=?, refund_amount=?, rental_status=? WHERE rental_id=?";
        
        // Handle nullable date
        java.sql.Date sqlReturnDate = (entity.getActualReturnDate() != null) 
                ? new java.sql.Date(entity.getActualReturnDate().getTime()) : null;

        return CrudUtil.executeUpdate(sql,
                sqlReturnDate,
                entity.getLateDays(),
                entity.getLateFeeAmount(),
                entity.getDamageDescription(),
                entity.getDamageCharge(),
                entity.getTotalCharges(),
                entity.getRefundAmount(),
                entity.getRentalStatus(),
                entity.getRentalId()
        );
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM rental WHERE rental_id=?", id);
    }

    @Override
    public RentalEntity search(String id) throws Exception {
        System.out.println("Searching for ID: " + id); // DEBUG LINE
        String sql = "SELECT * FROM rental WHERE rental_id = ?";
        ResultSet rs = CrudUtil.executeQuery(sql, id);
        
        if (rs.next()) {
            System.out.println("Found in Database!"); // DEBUG LINE
            RentalEntity entity = new RentalEntity();
            entity.setRentalId(rs.getString("rental_id"));
            entity.setEquipmentId(rs.getString("equipment_id"));
            entity.setCustomerId(rs.getString("customer_id"));
            entity.setStartDate(rs.getDate("start_date"));
            entity.setEndDate(rs.getDate("end_date"));
            entity.setSecurityDeposit(rs.getDouble("security_deposit"));
            entity.setRentalStatus(rs.getString("rental_status"));
            
            // Critical for Return Logic:
            entity.setLateDays(rs.getInt("late_days"));
            entity.setLateFeeAmount(rs.getDouble("late_fee_amount"));
            entity.setDamageCharge(rs.getDouble("damage_charge"));
            
            return entity;
        }
        System.out.println("NOT Found in Database."); // DEBUG LINE
        return null;
    }

    @Override
    public ArrayList<RentalEntity> getAll() throws Exception {
        ArrayList<RentalEntity> list = new ArrayList<>();
        ResultSet rs = CrudUtil.executeQuery("SELECT * FROM rental");
        while (rs.next()) {
            RentalEntity entity = new RentalEntity();
            entity.setRentalId(rs.getString("rental_id"));
            entity.setEquipmentId(rs.getString("equipment_id"));
            entity.setCustomerId(rs.getString("customer_id"));
            entity.setRentalStatus(rs.getString("rental_status"));
            // Add minimum required fields for list view
            list.add(entity);
        }
        return list;
    }
}