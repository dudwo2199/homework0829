package com.kh.homework0809.exception;

import jakarta.persistence.PersistenceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice(basePackages = {"com.kh.homework0809"})
public class ExceptionMonitor {

    @ExceptionHandler(IllegalStateApiException.class)
    public ResponseEntity<Map<String, Object>> IllegalException(final IllegalStateApiException e) {

        e.printStackTrace();

        Map<String, Object> map = new HashMap<>();
        map.put("timestamp", LocalDateTime.now());
        map.put("code", "[" + e.getErrorCode().getDomain() + "]-" + e.getErrorCode().getStatusCode());
        map.put("message", e.getMessage());

        return ResponseEntity
                .badRequest()
                .body(map);
    }

    @ExceptionHandler(PersistenceException.class)
    public ResponseEntity<?> handlePersistenceException(PersistenceException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("DB 제약 조건 위반: " + e.getMessage());
    }
}