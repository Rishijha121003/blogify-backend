package com.blogify.user_service.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<Map<String, Object>> accountNotFound (AccountNotFoundException a) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", java.time.LocalDateTime.now());
        body.put("error", "USER_NOT_FOUND");
        body.put("message", a.getMessage());
        return ResponseEntity.status(404).body(body);
    }
    @ExceptionHandler(WrongPasswordException.class)
    public ResponseEntity<Map<String, Object>> wrongPassword (WrongPasswordException a) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", java.time.LocalDateTime.now());
        body.put("error", "WRONG_PASSWORD");
        body.put("message", a.getMessage());
        return ResponseEntity.status(500).body(body);
    }
}
