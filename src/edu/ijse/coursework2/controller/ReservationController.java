/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.coursework2.controller;

import edu.ijse.coursework2.dto.ReservationDto;
import edu.ijse.coursework2.service.ServiceFactory;
import edu.ijse.coursework2.service.custom.ReservationService;

/**
 *
 * @author USER
 */
public class ReservationController {
    private final ReservationService service = (ReservationService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.RESERVATION);

    public String placeReservation(ReservationDto dto) throws Exception {
        return service.placeReservation(dto);
    }
}
