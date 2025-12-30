/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.coursework2.service.custom.impl;

import edu.ijse.coursework2.dao.DaoFactory;
import edu.ijse.coursework2.dao.custom.EquipmentDao;
import edu.ijse.coursework2.dao.custom.RentalDao;
import edu.ijse.coursework2.db.DBConnection;
import edu.ijse.coursework2.dto.RentalDto;
import edu.ijse.coursework2.entity.RentalEntity;
import edu.ijse.coursework2.service.custom.RentalService;
import java.util.ArrayList;
import java.sql.Connection;

/**
 *
 * @author USER
 */
public class RentalServiceImpl implements RentalService {

    private final RentalDao rentalDao = (RentalDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.RENTAL);
    private final EquipmentDao equipmentDao = (EquipmentDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.EQUIPMENT);

    @Override
    public String placeRental(RentalDto dto) throws Exception {
        Connection connection = null;

        try {
            // 1. Get the connection and disable auto-commit (Start Transaction)
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            // 2. Check if equipment is actually available (Double check safety)
            // Note: In a real app, you might want a specific 'search' check here.
            
            // 3. Prepare Entity
            RentalEntity rentalEntity = new RentalEntity(
                    dto.getRentalId(),
                    dto.getReservationId(),
                    dto.getEquipmentId(),
                    dto.getCustomerId(),
                    dto.getBranchId(),
                    dto.getStartDate(),
                    dto.getEndDate(),
                    dto.getCalculatedRentalAmount(),
                    dto.getMembershipDiscount(),
                    dto.getLongRentalDiscount(),
                    dto.getFinalPayableAmount(),
                    dto.getSecurityDeposit(),
                    dto.getAmountPaid(),
                    dto.getPaymentStatus(),
                    dto.getRentalStatus(),
                    dto.getIssuedBy()
            );

            // 4. Save Rental Data
            boolean isRentalSaved = rentalDao.save(rentalEntity);

            if (isRentalSaved) {
                // 5. Update Equipment Status to "RENTED"
                boolean isEquipmentUpdated = equipmentDao.updateStatus(dto.getEquipmentId(), "RENTED");

                if (isEquipmentUpdated) {
                    // 6. Both succeeded! Commit the transaction.
                    connection.commit();
                    return "Rental placed successfully!";
                } else {
                    // Equipment update failed
                    connection.rollback();
                    return "Failed to update equipment status.";
                }
            } else {
                // Rental save failed
                connection.rollback();
                return "Failed to save rental record.";
            }

        } catch (Exception e) {
            // 7. If any error (SQL or Logic), Rollback everything
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
            return "Error: " + e.getMessage();
        } finally {
            // 8. Always reset auto-commit to true (Standard JDBC practice)
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public ArrayList<RentalDto> getAllRentals() throws Exception {
        ArrayList<RentalEntity> entities = rentalDao.getAll();
        ArrayList<RentalDto> dtos = new ArrayList<>();
        
        for (RentalEntity entity : entities) {
            RentalDto dto = new RentalDto();
            dto.setRentalId(entity.getRentalId());
            dto.setEquipmentId(entity.getEquipmentId());
            dto.setCustomerId(entity.getCustomerId());
            dto.setRentalStatus(entity.getRentalStatus());
            // Map other fields as needed for the table view
            dtos.add(dto);
        }
        return dtos;
    }
    
    @Override
    public String returnRental(RentalDto dto) throws Exception {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            // 1. Prepare Entity with return details
            RentalEntity entity = new RentalEntity();
            entity.setRentalId(dto.getRentalId());
            entity.setActualReturnDate(dto.getActualReturnDate());
            entity.setLateDays(dto.getLateDays());
            entity.setLateFeeAmount(dto.getLateFeeAmount());
            entity.setDamageDescription(dto.getDamageDescription());
            entity.setDamageCharge(dto.getDamageCharge());
            entity.setTotalCharges(dto.getTotalCharges());
            entity.setRefundAmount(dto.getRefundAmount());
            entity.setRentalStatus("RETURNED"); // Close the rental

            // 2. Update the Rental Table
            boolean isRentalUpdated = rentalDao.update(entity);

            if (isRentalUpdated) {
                // 3. Determine new Equipment Status
                // If there is damage, it might go to MAINTENANCE, otherwise AVAILABLE [cite: 197]
                String newStatus = (dto.getDamageCharge() > 0) ? "MAINTENANCE" : "AVAILABLE";

                // 4. Update Equipment Table
                boolean isEquipmentUpdated = equipmentDao.updateStatus(dto.getEquipmentId(), newStatus);

                if (isEquipmentUpdated) {
                    connection.commit();
                    return "Return processed successfully! Status: " + newStatus;
                } else {
                    connection.rollback();
                    return "Failed to update equipment status.";
                }
            } else {
                connection.rollback();
                return "Failed to update rental record.";
            }

        } catch (Exception e) {
            if (connection != null) connection.rollback();
            e.printStackTrace();
            return "Error: " + e.getMessage();
        } finally {
            if (connection != null) connection.setAutoCommit(true);
        }
    }
    
    public RentalDto searchRental(String rentalId) throws Exception {
        RentalEntity entity = rentalDao.search(rentalId);
        if (entity != null) {
            RentalDto dto = new RentalDto();
            dto.setRentalId(entity.getRentalId());
            dto.setEquipmentId(entity.getEquipmentId());
            dto.setCustomerId(entity.getCustomerId());
            dto.setStartDate(entity.getStartDate());
            dto.setEndDate(entity.getEndDate());
            dto.setSecurityDeposit(entity.getSecurityDeposit());
            dto.setRentalStatus(entity.getRentalStatus());
            // Add any other fields you need for the UI
            return dto;
        }
        return null;
    }
}
