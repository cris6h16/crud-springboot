package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class DriverNotFoundExceptionHttp extends ResponseStatusException {
    public DriverNotFoundExceptionHttp() {
        super(HttpStatus.NOT_FOUND, "Driver not found");
    }
}
