/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.coursework2.service.custom;

import edu.ijse.coursework2.dto.ReservationDto;
import edu.ijse.coursework2.service.SuperService;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public interface ReservationService extends SuperService {
    String placeReservation(ReservationDto dto) throws Exception;
    ArrayList<ReservationDto> getAllReservations() throws Exception;
}