package com.aplose.digihello.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler (InvalidTownException.class)
    public ResponseEntity<String> handleInvalidTownException(InvalidTownException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler (TownNotFound.class)
    public ResponseEntity<String> handleInvalidTownNotFound(TownNotFound ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
