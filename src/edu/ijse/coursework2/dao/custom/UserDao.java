/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.coursework2.dao.custom;

import edu.ijse.coursework2.dao.SuperDao;
import edu.ijse.coursework2.entity.UserEntity;

/**
 *
 * @author USER
 */
public interface UserDao extends SuperDao {
    UserEntity findByUsername(String username) throws Exception;
    
}
