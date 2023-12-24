package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class IdNotIsLongExceptionHttp extends ResponseStatusException {
    public IdNotIsLongExceptionHttp(Throwable cause) {
        super(HttpStatus.BAD_REQUEST, "Driver ID must be a number", cause);
    }
}
