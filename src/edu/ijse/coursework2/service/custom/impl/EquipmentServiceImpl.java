/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.coursework2.service.custom.impl;

import edu.ijse.coursework2.dao.DaoFactory;
import edu.ijse.coursework2.dao.custom.EquipmentDao;
import edu.ijse.coursework2.dto.EquipmentDto;
import edu.ijse.coursework2.entity.EquipmentEntity;
import edu.ijse.coursework2.service.custom.EquipmentService;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentDao equipmentDao = (EquipmentDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.EQUIPMENT);

    @Override
    public String saveEquipment(EquipmentDto dto) throws Exception {
        EquipmentEntity entity = new EquipmentEntity(
                dto.getEquipmentId(),
                dto.getCategoryId(),
                dto.getBranchId(),
                dto.getBrand(),
                dto.getModel(),
                dto.getPurchaseYear(),
                dto.getBasePricePerDay(),
                dto.getSecurityDeposit(),
                dto.getStatus(),
                dto.isIsActive()
        );
        return equipmentDao.save(entity) ? "Equipment saved successfully" : "Failed to save equipment";
    }

    @Override
    public String updateEquipment(EquipmentDto dto) throws Exception {
        EquipmentEntity entity = new EquipmentEntity(
                dto.getEquipmentId(),
                dto.getCategoryId(),
                dto.getBranchId(),
                dto.getBrand(),
                dto.getModel(),
                dto.getPurchaseYear(),
                dto.getBasePricePerDay(),
                dto.getSecurityDeposit(),
                dto.getStatus(),
                dto.isIsActive()
        );
        return equipmentDao.update(entity) ? "Equipment updated successfully" : "Failed to update equipment";
    }

    @Override
    public String deleteEquipment(String equipmentId) throws Exception {
        return equipmentDao.delete(equipmentId) ? "Equipment deleted successfully" : "Failed to delete equipment";
    }

    @Override
    public EquipmentDto searchEquipment(String equipmentId) throws Exception {
        EquipmentEntity entity = equipmentDao.search(equipmentId);
        if (entity != null) {
            return new EquipmentDto(
                    entity.getEquipmentId(),
                    entity.getCategoryId(),
                    entity.getBranchId(),
                    entity.getBrand(),
                    entity.getModel(),
                    entity.getPurchaseYear(),
                    entity.getBasePricePerDay(),
                    entity.getSecurityDeposit(),
                    entity.getStatus(),
                    entity.isIsActive()
            );
        }
        return null;
    }

    @Override
    public ArrayList<EquipmentDto> getAllEquipment() throws Exception {
        ArrayList<EquipmentEntity> entities = equipmentDao.getAll();
        ArrayList<EquipmentDto> dtos = new ArrayList<>();
        for (EquipmentEntity entity : entities) {
            dtos.add(new EquipmentDto(
                    entity.getEquipmentId(),
                    entity.getCategoryId(),
                    entity.getBranchId(),
                    entity.getBrand(),
                    entity.getModel(),
                    entity.getPurchaseYear(),
                    entity.getBasePricePerDay(),
                    entity.getSecurityDeposit(),
                    entity.getStatus(),
                    entity.isIsActive()
            ));
        }
        return dtos;
    }
}