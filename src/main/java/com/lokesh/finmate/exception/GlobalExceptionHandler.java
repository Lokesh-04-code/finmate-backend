package com.lokesh.finmate.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handle(RuntimeException ex) {

        return ResponseEntity.status(400).body(Map.of(
                "title", "Validation Failed",
                "message", ex.getMessage(),
                "stackTrace", ex.getStackTrace()
        ));
    }

    @ExceptionHandler(SecurityException.class)
    public ResponseEntity<?> handleUnauthorized(SecurityException ex) {

        return ResponseEntity.status(401).body(Map.of(
                "title", "Unauthorized",
                "message", ex.getMessage(),
                "stackTrace", ex.getStackTrace()
        ));
    }



}


