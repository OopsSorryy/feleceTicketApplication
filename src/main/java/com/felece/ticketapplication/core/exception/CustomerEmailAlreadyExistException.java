package com.felece.ticketapplication.core.exception;




public class CustomerEmailAlreadyExistException extends RuntimeException {
    public CustomerEmailAlreadyExistException(String message) {
        super(message);
    }
}
