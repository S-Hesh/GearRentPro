/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.coursework2.controller;

import edu.ijse.coursework2.dto.UserDto;
import edu.ijse.coursework2.service.ServiceFactory;
import edu.ijse.coursework2.service.custom.AuthService;

/**
 *
 * @author USER
 */
public class LoginController {

    private final AuthService authService = (AuthService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.AUTH);

    public UserDto login(String username, String password) throws Exception {
        return authService.login(username, password);
    }
}
