/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.coursework2.service.custom;

import edu.ijse.coursework2.dto.UserDto;
import edu.ijse.coursework2.service.SuperService;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public interface UserService extends SuperService {
    String saveUser(UserDto dto) throws Exception;
    String updateUser(UserDto dto) throws Exception;
    String deleteUser(String id) throws Exception;
    ArrayList<UserDto> getAllUsers() throws Exception;
}