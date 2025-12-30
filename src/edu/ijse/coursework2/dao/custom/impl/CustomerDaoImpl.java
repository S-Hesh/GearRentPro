/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.coursework2.dao.custom.impl;

import edu.ijse.coursework2.dao.CrudUtil;
import edu.ijse.coursework2.dao.custom.CustomerDao;
import edu.ijse.coursework2.entity.CustomerEntity;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class CustomerDaoImpl implements CustomerDao {

    @Override
    public boolean save(CustomerEntity entity) throws Exception {
        String query = "INSERT INTO customer (customer_id, full_name, nic_passport, contact_no, email, address, membership_level_code) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        return CrudUtil.executeUpdate(query, entity.getCustomerId(), entity.getFullName(), entity.getNicPassport(),
                entity.getContactNo(), entity.getEmail(), entity.getAddress(), entity.getMembershipLevelCode());
    }

    @Override
    public boolean update(CustomerEntity entity) throws Exception {
        String query = "UPDATE customer SET full_name = ?, nic_passport = ?, contact_no = ?, email = ?, address = ?, membership_level_code = ? " +
                "WHERE customer_id = ?";
        return CrudUtil.executeUpdate(query, entity.getFullName(), entity.getNicPassport(), entity.getContactNo(),
                entity.getEmail(), entity.getAddress(), entity.getMembershipLevelCode(), entity.getCustomerId());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM customer WHERE customer_id = ?", id);
    }

    @Override
    public CustomerEntity search(String id) throws Exception {
        ResultSet rs = CrudUtil.executeQuery("SELECT * FROM customer WHERE customer_id = ?", id);
        if (rs.next()) {
            return new CustomerEntity(
                    rs.getString("customer_id"),
                    rs.getString("full_name"),
                    rs.getString("nic_passport"),
                    rs.getString("contact_no"),
                    rs.getString("email"),
                    rs.getString("address"),
                    rs.getString("membership_level_code")
            );
        }
        return null;
    }

    @Override
    public ArrayList<CustomerEntity> getAll() throws Exception {
        ResultSet rs = CrudUtil.executeQuery("SELECT * FROM customer");
        ArrayList<CustomerEntity> customers = new ArrayList<>();
        while (rs.next()) {
            customers.add(new CustomerEntity(
                    rs.getString("customer_id"),
                    rs.getString("full_name"),
                    rs.getString("nic_passport"),
                    rs.getString("contact_no"),
                    rs.getString("email"),
                    rs.getString("address"),
                    rs.getString("membership_level_code")
            ));
        }
        return customers;
    }
}