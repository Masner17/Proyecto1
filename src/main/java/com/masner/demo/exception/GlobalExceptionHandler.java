package com.masner.demo.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound (ResourceNotFoundException ex){
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", 404);
        body.put("error", "not found");
        body.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    } 

}

/*Explicación CLARA (esto es muy importante)
@RestControllerAdvice

Escucha errores de toda la aplicación

Evita repetir try/catch en cada controller

 @ExceptionHandler

Dice: cuando pase ESTE error, respondé ASÍ

¿Por qué Map?

Devuelve JSON automáticamente

Fácil de entender

Muy usado en APIs reales */
