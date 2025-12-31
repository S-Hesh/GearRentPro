/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.coursework2.controller;

import edu.ijse.coursework2.dao.DaoFactory;
import edu.ijse.coursework2.dao.custom.ReportDao;
import edu.ijse.coursework2.dto.RentalDto;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class ReportController {
    
    private final ReportDao reportDao = (ReportDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.REPORT);

    public ArrayList<RentalDto> getOverdueRentals() throws Exception {
        return reportDao.getOverdueRentals();
    }

    public ArrayList<RentalDto> getActiveRentals() throws Exception {
        return reportDao.getActiveRentals();
    }
    
    public double getTotalIncome() throws Exception {
        return reportDao.getTotalIncome();
    }
}