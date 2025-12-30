/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.coursework2.dao.custom;

import edu.ijse.coursework2.dao.CrudDao;
import edu.ijse.coursework2.entity.EquipmentEntity;

/**
 *
 * @author USER
 */

public interface EquipmentDao extends CrudDao<EquipmentEntity, String> {
    
    public boolean updateStatus(String equipmentId, String status) throws Exception;
 
}
     