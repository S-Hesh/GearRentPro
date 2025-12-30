/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.coursework2.service.custom;

import edu.ijse.coursework2.dto.EquipmentDto;
import edu.ijse.coursework2.service.SuperService;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public interface EquipmentService extends SuperService {
    String saveEquipment(EquipmentDto dto) throws Exception;
    String updateEquipment(EquipmentDto dto) throws Exception;
    String deleteEquipment(String equipmentId) throws Exception;
    EquipmentDto searchEquipment(String equipmentId) throws Exception;
    ArrayList<EquipmentDto> getAllEquipment() throws Exception;
}