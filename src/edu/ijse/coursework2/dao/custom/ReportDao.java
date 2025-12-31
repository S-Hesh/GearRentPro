/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.coursework2.dao.custom;

import edu.ijse.coursework2.dao.SuperDao;
import edu.ijse.coursework2.dto.RentalDto;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public interface ReportDao extends SuperDao {
    ArrayList<RentalDto> getOverdueRentals() throws Exception;
    ArrayList<RentalDto> getActiveRentals() throws Exception;
    double getTotalIncome() throws Exception;
}