/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.coursework2.service.custom.impl;

import edu.ijse.coursework2.dao.DaoFactory;
import edu.ijse.coursework2.dao.custom.UserDao;
import edu.ijse.coursework2.dto.UserDto;
import edu.ijse.coursework2.entity.UserEntity;
import edu.ijse.coursework2.service.custom.UserService;
import edu.ijse.coursework2.util.PasswordUtil; // Ensure you have this util from Login
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class UserServiceImpl implements UserService {
    
    private final UserDao userDao = (UserDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.USER);

    @Override
    public String saveUser(UserDto dto) throws Exception {
        if (userDao.search(dto.getUserId()) != null) return "Error: User ID already exists.";
        
        // Hash the password before saving!
        String hashedPass = PasswordUtil.sha256Hex(dto.getPassword());
        
        UserEntity entity = new UserEntity(
                dto.getUserId(), 
                dto.getFullName(), 
                dto.getUsername(), 
                hashedPass, 
                dto.getRole(), 
                dto.getBranchId(), 
                true // Default to active
        );
        return userDao.save(entity) ? "User Saved Successfully" : "Failed to Save User";
    }

    @Override
    public String updateUser(UserDto dto) throws Exception {
        UserEntity entity = userDao.search(dto.getUserId());
        if (entity != null) {
            entity.setFullName(dto.getFullName());
            entity.setUsername(dto.getUsername());
            entity.setRole(dto.getRole());
            entity.setBranchId(dto.getBranchId());
            
            // Only update password if a new one is typed (simple logic)
            if (dto.getPassword() != null && !dto.getPassword().isEmpty()) {
                entity.setPasswordHash(PasswordUtil.sha256Hex(dto.getPassword()));
            }
            
            return userDao.update(entity) ? "User Updated Successfully" : "Failed to Update User";
        }
        return "Error: User Not Found";
    }

    @Override
    public String deleteUser(String id) throws Exception {
        return userDao.delete(id) ? "User Deleted Successfully" : "Failed to Delete User";
    }

   @Override
    public ArrayList<UserDto> getAllUsers() throws Exception {
        ArrayList<UserEntity> entities = userDao.getAll();
        ArrayList<UserDto> dtos = new ArrayList<>();
        
        for (UserEntity e : entities) {
            // YOU MUST USE THE LONG CONSTRUCTOR HERE
            // If you use the short one, 'username' will be null!
            dtos.add(new UserDto(
                    e.getUserId(), 
                    e.getFullName(), 
                    e.getUsername(),    // <--- Ensure this is passed
                    e.getPasswordHash(), 
                    null,               // Email (pass null if not in entity)
                    e.getRole(), 
                    e.getBranchId(),
                    e.isActive()
            ));
        }
        return dtos;
    }
}