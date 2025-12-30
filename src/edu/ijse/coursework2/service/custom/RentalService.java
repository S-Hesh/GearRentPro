/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.coursework2.service.custom;

import edu.ijse.coursework2.dto.RentalDto;
import edu.ijse.coursework2.service.SuperService;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public interface RentalService extends SuperService {
    // The big transaction method
    String placeRental(RentalDto rentalDto) throws Exception;
    
    // Standard getters
    ArrayList<RentalDto> getAllRentals() throws Exception;
}