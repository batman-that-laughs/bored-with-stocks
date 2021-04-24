package com.stocksproject.couchbasedataadaptor.rest.util;

import com.stocksproject.couchbasedataadaptor.exception.DataNotFoundException;
import com.stocksproject.couchbasedataadaptor.exception.DataValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DataValidationException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    ResponseEntity handleValidationException(DataValidationException validationException, WebRequest webRequest){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationException.getErrorMessage());
    }

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ResponseEntity handleDataNotFoundException(DataNotFoundException dataNotFoundException, WebRequest webRequest){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dataNotFoundException.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    ResponseEntity handleGenericException(Exception exception, WebRequest webRequest){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }
}