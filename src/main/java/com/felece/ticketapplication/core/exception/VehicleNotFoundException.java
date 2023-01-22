package com.felece.ticketapplication.core.exception;


import com.felece.ticketapplication.model.Vehicle;

public class VehicleNotFoundException extends RuntimeException {
    public VehicleNotFoundException(String message) {
        super(message);
    }
}
