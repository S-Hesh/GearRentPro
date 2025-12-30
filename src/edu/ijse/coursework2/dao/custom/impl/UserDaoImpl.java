/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.coursework2.dao.custom.impl;

import edu.ijse.coursework2.dao.CrudUtil;
import edu.ijse.coursework2.dao.custom.UserDao;
import edu.ijse.coursework2.entity.UserEntity;

import java.sql.ResultSet;

/**
 *
 * @author USER
 */
public class UserDaoImpl implements UserDao {

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
}
