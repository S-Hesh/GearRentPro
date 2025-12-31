/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.coursework2.service.custom.impl;

import edu.ijse.coursework2.dao.DaoFactory;
import edu.ijse.coursework2.dao.custom.RentalDao;
import edu.ijse.coursework2.dao.custom.ReservationDao;
import edu.ijse.coursework2.dto.ReservationDto;
import edu.ijse.coursework2.entity.ReservationEntity;
import edu.ijse.coursework2.service.custom.ReservationService;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class ReservationServiceImpl implements ReservationService {

    private final ReservationDao reservationDao = (ReservationDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.RESERVATION);
    private final RentalDao rentalDao = (RentalDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.RENTAL);

    @Override
    public String placeReservation(ReservationDto dto) throws Exception {
        // 1. Check if Equipment exists in Rentals (Active)
        if (rentalDao.checkOverlap(dto.getEquipmentId(), dto.getStartDate(), dto.getEndDate())) {
            return "Unavailable: Item is currently RENTED during these dates.";
        }

        // 2. Check if Equipment exists in Reservations (Pending)
        if (reservationDao.checkOverlap(dto.getEquipmentId(), dto.getStartDate(), dto.getEndDate())) {
            return "Unavailable: Item is ALREADY RESERVED during these dates.";
        }

        // 3. If clear, Save it
        ReservationEntity entity = new ReservationEntity(
                dto.getReservationId(),
                dto.getEquipmentId(),
                dto.getCustomerId(),
                dto.getBranchId(),
                dto.getStartDate(),
                dto.getEndDate(),
                "PENDING", // Initial status
                dto.getCreatedBy()
        );

        return reservationDao.save(entity) ? "Reservation Placed Successfully!" : "Failed to place reservation.";
    }

    @Override
    public ArrayList<ReservationDto> getAllReservations() throws Exception {
        // Basic list for the table
        // You might need to add getAll() to ReservationDaoImpl if it's missing
        return new ArrayList<>(); 
    }
}
