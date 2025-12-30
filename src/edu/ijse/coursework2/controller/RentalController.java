/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.coursework2.controller;

import edu.ijse.coursework2.dto.RentalDto;
import edu.ijse.coursework2.service.ServiceFactory;
import edu.ijse.coursework2.service.custom.RentalService;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class RentalController {

    private final RentalService rentalService = (RentalService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.RENTAL);

    public String placeRental(RentalDto dto) throws Exception {
        return rentalService.placeRental(dto);
    }

    public ArrayList<RentalDto> getAllRentals() throws Exception {
        return rentalService.getAllRentals();
    }
}