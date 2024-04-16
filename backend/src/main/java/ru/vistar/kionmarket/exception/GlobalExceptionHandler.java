package ru.vistar.kionmarket.exception;

import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<?> handleResourceNotFoundException(RuntimeException e){
        Map<String,Object> responseBody = new HashMap<>();
        responseBody.put("exception",e.getClass().getSimpleName());
        responseBody.put("message",e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
    }

    @ExceptionHandler({ResourceAlreadyExistsException.class})
    public ResponseEntity<?> handleResourceAlreadyExistsException(RuntimeException e){
        Map<String,Object> responseBody = new HashMap<>();
        responseBody.put("exception",e.getClass().getSimpleName());
        responseBody.put("message",e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

    @ExceptionHandler({JwtException.class})
    public ResponseEntity<?> handleJwtException(RuntimeException e){
        Map<String,Object> responseBody = new HashMap<>();
        responseBody.put("exception",e.getClass().getSimpleName());
        responseBody.put("message",e.getMessage());

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(responseBody);
    }
}
