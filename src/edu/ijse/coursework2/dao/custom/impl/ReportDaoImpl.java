/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.coursework2.dao.custom.impl;

import edu.ijse.coursework2.dao.CrudUtil;
import edu.ijse.coursework2.dao.custom.ReportDao;
import edu.ijse.coursework2.dto.RentalDto;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class ReportDaoImpl implements ReportDao {

    @Override
    public ArrayList<RentalDto> getOverdueRentals() throws Exception {
        // Query for items that are ACTIVE but past their due date OR marked OVERDUE
        String sql = "SELECT * FROM rental WHERE rental_status = 'OVERDUE' "
                   + "OR (rental_status = 'ACTIVE' AND end_date < CURDATE())";
        return getList(sql);
    }

    @Override
    public ArrayList<RentalDto> getActiveRentals() throws Exception {
        String sql = "SELECT * FROM rental WHERE rental_status = 'ACTIVE'";
        return getList(sql);
    }

    @Override
    public double getTotalIncome() throws Exception {
        // Sum of all payments + late fees + damage charges
        String sql = "SELECT SUM(amount_paid + additional_payment_amount) FROM rental";
        ResultSet rs = CrudUtil.executeQuery(sql);
        if (rs.next()) {
            return rs.getDouble(1);
        }
        return 0.0;
    }

    // Helper method to map ResultSet to DTO list
    private ArrayList<RentalDto> getList(String sql) throws Exception {
        ArrayList<RentalDto> list = new ArrayList<>();
        ResultSet rs = CrudUtil.executeQuery(sql);
        while (rs.next()) {
            RentalDto dto = new RentalDto();
            dto.setRentalId(rs.getString("rental_id"));
            dto.setEquipmentId(rs.getString("equipment_id"));
            dto.setCustomerId(rs.getString("customer_id"));
            dto.setStartDate(rs.getDate("start_date"));
            dto.setEndDate(rs.getDate("end_date"));
            dto.setRentalStatus(rs.getString("rental_status"));
            list.add(dto);
        }
        return list;
    }
}