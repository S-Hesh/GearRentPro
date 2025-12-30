/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.coursework2.service.custom.impl;

import edu.ijse.coursework2.dao.DaoFactory;
import edu.ijse.coursework2.dao.custom.UserDao;
import edu.ijse.coursework2.dto.UserDto;
import edu.ijse.coursework2.entity.UserEntity;
import edu.ijse.coursework2.service.custom.AuthService;
import edu.ijse.coursework2.util.PasswordUtil;

/**
 *
 * @author USER
 */
public class AuthServiceImpl implements AuthService {

    private final UserDao userDao = (UserDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.USER);
    
    @Override
    public UserDto login(String username, String password) throws Exception {
        if (username == null || username.isBlank()) throw new IllegalArgumentException("Username required");
        if (password == null || password.isBlank()) throw new IllegalArgumentException("Password required");

        UserEntity user = userDao.findByUsername(username.trim());
        if (user == null) throw new IllegalArgumentException("Invalid username or password");
        if (!user.isActive()) throw new IllegalArgumentException("User disabled");

        String inputHash = PasswordUtil.sha256Hex(password);
        if (!inputHash.equalsIgnoreCase(user.getPasswordHash())) {
            throw new IllegalArgumentException("Invalid username or password");
        }

        return new UserDto(user.getUserId(), user.getFullName(), user.getRole(), user.getBranchId());
    }
}