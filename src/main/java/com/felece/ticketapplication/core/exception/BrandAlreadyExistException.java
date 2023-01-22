package com.felece.ticketapplication.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class BrandAlreadyExistException extends RuntimeException {
    public BrandAlreadyExistException(String message) {
        super(message);
    }
}
