package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class IlegalArgumentExeptionHttp extends ResponseStatusException {
    public IlegalArgumentExeptionHttp(String reason, Throwable cause) {
        super(HttpStatus.BAD_REQUEST, reason, cause);
    }
}
