package com.pragma.users.infrastructure.advice;

import com.pragma.users.infrastructure.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity userAlreadyExistException(UserNotFoundException error){
        return ResponseEntity.status(200).body(null);
    }
}
