/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.coursework2.service.custom;

import edu.ijse.coursework2.dto.CustomerDto;
import edu.ijse.coursework2.service.SuperService;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public interface CustomerService extends SuperService {
    String saveCustomer(CustomerDto dto) throws Exception;
    String updateCustomer(CustomerDto dto) throws Exception;
    String deleteCustomer(String customerId) throws Exception;
    CustomerDto searchCustomer(String customerId) throws Exception;
    ArrayList<CustomerDto> getAllCustomers() throws Exception;
}
