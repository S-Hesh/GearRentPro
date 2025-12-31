/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.coursework2.dao.custom;

import edu.ijse.coursework2.dao.CrudDao;
import edu.ijse.coursework2.entity.ReservationEntity;

/**
 *
 * @author USER
 */
public interface ReservationDao extends CrudDao<ReservationEntity, String>{
    
    boolean checkOverlap(String equipmentId, java.util.Date startDate, java.util.Date endDate) throws Exception;
    
}
    