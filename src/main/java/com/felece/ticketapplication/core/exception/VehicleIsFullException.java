package com.felece.ticketapplication.core.exception;

public class VehicleIsFullException extends RuntimeException {
    public VehicleIsFullException(String message) {
        super(message);
    }
}
