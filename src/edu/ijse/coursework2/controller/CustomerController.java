/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.coursework2.controller;

import edu.ijse.coursework2.dto.CustomerDto;
import edu.ijse.coursework2.service.custom.CustomerService;
import edu.ijse.coursework2.service.custom.impl.CustomerServiceImpl;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class CustomerController {

    private final CustomerService customerService = new CustomerServiceImpl();

    public String saveCustomer(CustomerDto dto) throws Exception {
        return customerService.saveCustomer(dto);
    }

    public String updateCustomer(CustomerDto dto) throws Exception {
        return customerService.updateCustomer(dto);
    }

    public String deleteCustomer(String customerId) throws Exception {
        return customerService.deleteCustomer(customerId);
    }

    public CustomerDto searchCustomer(String customerId) throws Exception {
        return customerService.searchCustomer(customerId);
    }

    public ArrayList<CustomerDto> getAllCustomers() throws Exception {
        return customerService.getAllCustomers();
    }
}