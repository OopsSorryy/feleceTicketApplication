package com.felece.ticketapplication.core.exception;

public class SeatNumberAlreadyTaken extends RuntimeException {
    public SeatNumberAlreadyTaken(String message) {
        super(message);
    }
}
