package com.example.demo.Exceptions.Manager;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST)
//    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
//        // Captura excepciones de validación y maneja la respuesta aquí
//        // Puedes obtener los mensajes de error de ex.getBindingResult().getAllErrors()
//
//        return ResponseEntity.badRequest().body("Validation failed: " + ex.getMessage());
//    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
        // Captura excepciones de violación de restricciones de validación aquí
        // Puedes obtener los mensajes de error de ex.getConstraintViolations()
        List<String> cons = ex.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage).toList();

        return ResponseEntity.badRequest().body("Msg: " + cons);
    }
}