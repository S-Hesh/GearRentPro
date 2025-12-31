/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.coursework2.dao.custom.impl;

import edu.ijse.coursework2.dao.CrudUtil;
import edu.ijse.coursework2.dao.custom.ReservationDao;
import edu.ijse.coursework2.entity.ReservationEntity;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class ReservationDaoImpl implements ReservationDao {

    @Override
    public boolean save(ReservationEntity entity) throws Exception {
        String sql = "INSERT INTO reservation (reservation_id, equipment_id, customer_id, branch_id, start_date, end_date, status, created_by) VALUES (?,?,?,?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql,
                entity.getReservationId(),
                entity.getEquipmentId(),
                entity.getCustomerId(),
                entity.getBranchId(),
                new java.sql.Date(entity.getStartDate().getTime()),
                new java.sql.Date(entity.getEndDate().getTime()),
                entity.getStatus(),
                entity.getCreatedBy()
        );
    }

    @Override
    public boolean update(ReservationEntity entity) throws Exception {
        return CrudUtil.executeUpdate("UPDATE reservation SET status=? WHERE reservation_id=?", entity.getStatus(), entity.getReservationId());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("UPDATE reservation SET status='CANCELLED' WHERE reservation_id=?", id);
    }

    @Override
    public ReservationEntity search(String id) throws Exception {
        return null; // Implement if needed
    }

    @Override
    public ArrayList<ReservationEntity> getAll() throws Exception {
        return new ArrayList<>(); // Implement if needed
    }
    
    @Override
    public boolean checkOverlap(String equipmentId, java.util.Date startDate, java.util.Date endDate) throws Exception {
        String sql = "SELECT COUNT(*) FROM reservation WHERE equipment_id = ? "
                   + "AND status != 'CANCELLED' " // Ignore cancelled ones
                   + "AND (? < end_date AND ? > start_date)";
        
        java.sql.Date sDate = new java.sql.Date(startDate.getTime());
        java.sql.Date eDate = new java.sql.Date(endDate.getTime());
        
        java.sql.ResultSet rs = CrudUtil.executeQuery(sql, equipmentId, sDate, eDate);
        if (rs.next()) {
            return rs.getInt(1) > 0; // Returns true if count > 0 (Overlap found)
        }
        return false;
    }
}