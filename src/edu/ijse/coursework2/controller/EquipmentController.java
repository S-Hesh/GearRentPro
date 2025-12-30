/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.coursework2.controller;

import edu.ijse.coursework2.dto.EquipmentDto;
import edu.ijse.coursework2.service.custom.EquipmentService;
import edu.ijse.coursework2.service.custom.impl.EquipmentServiceImpl;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class EquipmentController {

    private final EquipmentService equipmentService = new EquipmentServiceImpl();

    // Save equipment
    public String saveEquipment(EquipmentDto dto) throws Exception {
        return equipmentService.saveEquipment(dto);
    }

    // Update equipment
    public String updateEquipment(EquipmentDto dto) throws Exception {
        return equipmentService.updateEquipment(dto);
    }

    // Delete equipment
    public String deleteEquipment(String equipmentId) throws Exception {
        return equipmentService.deleteEquipment(equipmentId);
    }

    // Get all equipment
    public ArrayList<EquipmentDto> getAllEquipment() throws Exception {
        return equipmentService.getAllEquipment();
    }
    
    public EquipmentDto searchEquipment(String id) throws Exception {
        return equipmentService.searchEquipment(id);
    }
}
