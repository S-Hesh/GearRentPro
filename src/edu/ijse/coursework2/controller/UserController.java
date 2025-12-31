/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.coursework2.controller;


import edu.ijse.coursework2.dto.UserDto;
import edu.ijse.coursework2.service.ServiceFactory;
import edu.ijse.coursework2.service.custom.UserService;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class UserController {
    
    // Get the USER Service from the Factory
    private final UserService userService = (UserService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.USER);

    public String saveUser(UserDto dto) throws Exception {
        return userService.saveUser(dto);
    }

    public String updateUser(UserDto dto) throws Exception {
        return userService.updateUser(dto);
    }

    public String deleteUser(String userId) throws Exception {
        return userService.deleteUser(userId);
    }

    public ArrayList<UserDto> getAllUsers() throws Exception {
        return userService.getAllUsers();
    }
}