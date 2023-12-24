package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class OptimisticLockingFailureExceptionHttp extends ResponseStatusException {
    public OptimisticLockingFailureExceptionHttp(String msg, Throwable cause) {
        super(HttpStatus.CONFLICT, "Unexpected Concurrency error", cause);
    }
}
