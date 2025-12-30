/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.coursework2.service.custom.impl;


import edu.ijse.coursework2.dao.DaoFactory;
import edu.ijse.coursework2.dao.custom.CustomerDao;
import edu.ijse.coursework2.dto.CustomerDto;
import edu.ijse.coursework2.entity.CustomerEntity;
import edu.ijse.coursework2.service.custom.CustomerService;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerDao = (CustomerDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.CUSTOMER);

    @Override
    public String saveCustomer(CustomerDto dto) throws Exception {
        CustomerEntity entity = new CustomerEntity(
                dto.getCustomerId(), 
                dto.getFullName(), 
                dto.getNicPassport(),  // Added nic_passport
                dto.getContactNo(), 
                dto.getEmail(), 
                dto.getAddress(), 
                dto.getMembershipLevelCode()
        );
        return customerDao.save(entity) ? "Customer saved successfully" : "Failed to save customer";
    }

    @Override
    public String updateCustomer(CustomerDto dto) throws Exception {
        CustomerEntity entity = new CustomerEntity(dto.getCustomerId(), 
                dto.getFullName(), 
                dto.getNicPassport(),  // Added nic_passport
                dto.getContactNo(), 
                dto.getEmail(), 
                dto.getAddress(), 
                dto.getMembershipLevelCode());
        return customerDao.update(entity) ? "Success" : "Failed to update customer";
    }

    @Override
    public String deleteCustomer(String customerId) throws Exception {
        return customerDao.delete(customerId) ? "Success" : "Failed to delete customer";
    }

    @Override
    public CustomerDto searchCustomer(String customerId) throws Exception {
        CustomerEntity entity = customerDao.search(customerId);
        if (entity != null) {
            return new CustomerDto(entity.getCustomerId(), entity.getFullName(),entity.getNicPassport(),
                    entity.getContactNo(), entity.getEmail(), entity.getAddress(), entity.getMembershipLevelCode());
        }
        return null;
    }

    @Override
    public ArrayList<CustomerDto> getAllCustomers() throws Exception {
        ArrayList<CustomerEntity> entities = customerDao.getAll();
        ArrayList<CustomerDto> dtos = new ArrayList<>();
        
        for (CustomerEntity entity : entities) {
            // FIX: Added entity.getMembershipLevelCode() to the end
            dtos.add(new CustomerDto(
                entity.getCustomerId(), 
                entity.getFullName(),
                entity.getNicPassport(),
                entity.getContactNo(), 
                entity.getEmail(), 
                entity.getAddress(),
                entity.getMembershipLevelCode() 
            ));
        }
        return dtos;
    }
}
