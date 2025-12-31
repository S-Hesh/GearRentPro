/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.coursework2.service;

import edu.ijse.coursework2.service.custom.impl.AuthServiceImpl;
import edu.ijse.coursework2.service.custom.impl.RentalServiceImpl;
import edu.ijse.coursework2.service.custom.impl.ReservationServiceImpl;
import edu.ijse.coursework2.service.custom.impl.UserServiceImpl;

/**
 *
 * @author USER
 */
public class ServiceFactory {

    private static ServiceFactory serviceFactory;

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        if (serviceFactory == null) serviceFactory = new ServiceFactory();
        return serviceFactory;
    }

    public SuperService getService(ServiceType type) {
        switch (type) {
            case AUTH:
                return new AuthServiceImpl();
            case RENTAL:
                return new RentalServiceImpl();
            case RESERVATION:
                return new ReservationServiceImpl();
            case USER:
                return new UserServiceImpl();
            default:
                throw new AssertionError("No Service for type: " + type);
        }
    }

    public enum ServiceType {
        AUTH , RENTAL , RESERVATION ,USER
    }
}