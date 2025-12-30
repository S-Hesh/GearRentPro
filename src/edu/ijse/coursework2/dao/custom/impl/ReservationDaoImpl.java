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
}