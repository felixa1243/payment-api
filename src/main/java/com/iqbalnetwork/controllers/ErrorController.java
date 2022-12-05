package com.iqbalnetwork.controllers;

import com.iqbalnetwork.Models.Response.ErrorResponse;
import com.iqbalnetwork.controllers.exception.NotValidPaymentException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ErrorController {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> handleDataNotFound(NoSuchElementException err) {
        return ResponseEntity.status(404).body(new ErrorResponse("not found"));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException err) {
        List<FieldError> fieldErrors = err.getBindingResult().getFieldErrors();
        List<String> errors = new ArrayList<>();
        for (FieldError error : fieldErrors) {
            errors.add(error.getDefaultMessage());
        }
        return ResponseEntity
                .status(400)
                .body(new ErrorResponse(errors.toString()));
    }

    @ExceptionHandler(NotValidPaymentException.class)
    public ResponseEntity<ErrorResponse> handleException(NotValidPaymentException exception) {
        return ResponseEntity.status(400).body(new ErrorResponse("not valid"));
    }

}
