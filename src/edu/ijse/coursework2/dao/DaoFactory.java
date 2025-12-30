/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.coursework2.dao;

import edu.ijse.coursework2.dao.custom.impl.CustomerDaoImpl;
import edu.ijse.coursework2.dao.custom.impl.EquipmentDaoImpl;
import edu.ijse.coursework2.dao.custom.impl.RentalDaoImpl;
import edu.ijse.coursework2.dao.custom.impl.ReservationDaoImpl;
import edu.ijse.coursework2.dao.custom.impl.UserDaoImpl;
//import edu.ijse.coursework2.dao.custom.ItemDaoImpl;
/**
 *
 * @author USER
 */
public class DaoFactory {

    private static DaoFactory daoFactory;

    private DaoFactory() {}

    public static DaoFactory getInstance() {
        if (daoFactory == null) daoFactory = new DaoFactory();
        return daoFactory;
    }

    public SuperDao getDao(DaoTypes type) {
        switch (type) {
            case USER:
                return new UserDaoImpl();
            case CUSTOMER:
                return new CustomerDaoImpl();
            case EQUIPMENT:
                return new EquipmentDaoImpl();
            case RESERVATION:
                return new ReservationDaoImpl();
            case RENTAL:
                return new RentalDaoImpl();
                
            //case ITEM:
            //   return new ItemDaoImpl();
            // Add other cases for more DAOs as needed
            default:
                throw new AssertionError("Unknown DAO type: " + type);
        }
    }

    public enum DaoTypes {
        USER , CUSTOMER , EQUIPMENT , RESERVATION, RENTAL
    }
}

