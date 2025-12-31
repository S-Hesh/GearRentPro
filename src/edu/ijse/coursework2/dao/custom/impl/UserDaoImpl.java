/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.coursework2.dao.custom.impl;

import edu.ijse.coursework2.dao.CrudUtil;
import edu.ijse.coursework2.dao.custom.UserDao;
import edu.ijse.coursework2.entity.UserEntity;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class UserDaoImpl implements UserDao {

    // --- EXISTING METHOD (For Login) ---
    @Override
    public UserEntity findByUsername(String username) throws Exception {
        ResultSet rs = CrudUtil.executeQuery(
                "SELECT user_id, full_name, username, password_hash, role, branch_id, is_active " +
                        "FROM system_user WHERE username = ?",
                username
        );

        if (!rs.next()) return null;

        return new UserEntity(
                rs.getString("user_id"),
                rs.getString("full_name"),
                rs.getString("username"),
                rs.getString("password_hash"),
                rs.getString("role"),
                rs.getString("branch_id"),
                rs.getInt("is_active") == 1
        );
    }

    // --- NEW METHODS (For User Management) ---

    @Override
    public boolean save(UserEntity entity) throws Exception {
        // We use 'is_active' based on your previous code
        return CrudUtil.executeUpdate("INSERT INTO system_user VALUES(?,?,?,?,?,?,?)",
                entity.getUserId(),
                entity.getFullName(),
                entity.getUsername(),
                entity.getPasswordHash(),
                entity.getRole(),
                entity.getBranchId(),
                entity.isActive() ? 1 : 0 // Convert boolean to int for SQL
        );
    }

    @Override
    public boolean update(UserEntity entity) throws Exception {
        // Update details including full_name
        return CrudUtil.executeUpdate("UPDATE system_user SET full_name=?, username=?, password_hash=?, role=?, branch_id=?, is_active=? WHERE user_id=?",
                entity.getFullName(),
                entity.getUsername(),
                entity.getPasswordHash(),
                entity.getRole(),
                entity.getBranchId(),
                entity.isActive() ? 1 : 0,
                entity.getUserId());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM system_user WHERE user_id=?", id);
    }

    @Override
    public UserEntity search(String id) throws Exception {
        ResultSet rs = CrudUtil.executeQuery("SELECT * FROM system_user WHERE user_id=?", id);
        if (rs.next()) {
            return new UserEntity(
                    rs.getString("user_id"),
                    rs.getString("full_name"),
                    rs.getString("username"),
                    rs.getString("password_hash"),
                    rs.getString("role"),
                    rs.getString("branch_id"),
                    rs.getInt("is_active") == 1
            );
        }
        return null;
    }

    @Override
    public ArrayList<UserEntity> getAll() throws Exception {
        ArrayList<UserEntity> list = new ArrayList<>();
        ResultSet rs = CrudUtil.executeQuery("SELECT * FROM system_user");
        while (rs.next()) {
            list.add(new UserEntity(
                    rs.getString("user_id"),
                    rs.getString("full_name"),
                    rs.getString("username"),
                    rs.getString("password_hash"),
                    rs.getString("role"),
                    rs.getString("branch_id"),
                    rs.getInt("is_active") == 1
            ));
        }
        return list;
    }
}