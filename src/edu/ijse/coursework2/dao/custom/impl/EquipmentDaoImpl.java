/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.coursework2.dao.custom.impl;

import edu.ijse.coursework2.dao.CrudUtil;
import edu.ijse.coursework2.dao.custom.EquipmentDao;
import edu.ijse.coursework2.entity.EquipmentEntity;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author USER
 */
public class EquipmentDaoImpl implements EquipmentDao {

    @Override
    public boolean save(EquipmentEntity entity) throws Exception {
        String query = "INSERT INTO equipment (equipment_id, category_id, branch_id, brand, model, purchase_year, " +
                "base_price_per_day, security_deposit, status, is_active) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return CrudUtil.executeUpdate(query, entity.getEquipmentId(), entity.getCategoryId(), entity.getBranchId(),
                entity.getBrand(), entity.getModel(), entity.getPurchaseYear(), entity.getBasePricePerDay(),
                entity.getSecurityDeposit(), entity.getStatus(), entity.isIsActive());
    }

    @Override
    public boolean update(EquipmentEntity entity) throws Exception {
        String query = "UPDATE equipment SET category_id = ?, branch_id = ?, brand = ?, model = ?, purchase_year = ?, " +
                "base_price_per_day = ?, security_deposit = ?, status = ?, is_active = ? WHERE equipment_id = ?";
        return CrudUtil.executeUpdate(query, entity.getCategoryId(), entity.getBranchId(), entity.getBrand(),
                entity.getModel(), entity.getPurchaseYear(), entity.getBasePricePerDay(), entity.getSecurityDeposit(),
                entity.getStatus(), entity.isIsActive(), entity.getEquipmentId());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM equipment WHERE equipment_id = ?", id);
    }

    @Override
    public EquipmentEntity search(String id) throws Exception {
        ResultSet rs = CrudUtil.executeQuery("SELECT * FROM equipment WHERE equipment_id = ?", id);
        if (rs.next()) {
            return new EquipmentEntity(
                    rs.getString("equipment_id"),
                    rs.getString("category_id"),
                    rs.getString("branch_id"),
                    rs.getString("brand"),
                    rs.getString("model"),
                    rs.getInt("purchase_year"),
                    rs.getDouble("base_price_per_day"),
                    rs.getDouble("security_deposit"),
                    rs.getString("status"),
                    rs.getBoolean("is_active")
            );
        }
        return null;
    }

    @Override
    public ArrayList<EquipmentEntity> getAll() throws Exception {
        ResultSet rs = CrudUtil.executeQuery("SELECT * FROM equipment");
        ArrayList<EquipmentEntity> equipmentList = new ArrayList<>();
        while (rs.next()) {
            equipmentList.add(new EquipmentEntity(
                    rs.getString("equipment_id"),
                    rs.getString("category_id"),
                    rs.getString("branch_id"),
                    rs.getString("brand"),
                    rs.getString("model"),
                    rs.getInt("purchase_year"),
                    rs.getDouble("base_price_per_day"),
                    rs.getDouble("security_deposit"),
                    rs.getString("status"),
                    rs.getBoolean("is_active")
            ));
        }
        return equipmentList;
    }
    
    @Override
    public boolean updateStatus(String equipmentId, String status) throws Exception {
        return CrudUtil.executeUpdate("UPDATE equipment SET status = ? WHERE equipment_id = ?", status, equipmentId);
    }
}