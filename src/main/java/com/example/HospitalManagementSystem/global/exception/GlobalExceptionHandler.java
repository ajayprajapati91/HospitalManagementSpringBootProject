package com.example.HospitalManagementSystem.global.exception;

import com.example.HospitalManagementSystem.customizedException.DonorNotFoundException;
import com.example.HospitalManagementSystem.customizedException.UserNotFoundException;
import com.example.HospitalManagementSystem.exception.Response;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(RuntimeException.class )
    public ResponseEntity<Response> runTimeException(RuntimeException ex, HttpServletRequest req){
        Response res = new Response();

        res.setMessage(ex.getMessage());
        res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        res.setDateTime(LocalDateTime.now());
        res.setPath(req.getRequestURI());

        return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class )
    public ResponseEntity<Response> userNotFoundException(UserNotFoundException ex, HttpServletRequest req){
        Response res = new Response();

        res.setMessage(ex.getMessage());
        res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        res.setDateTime(LocalDateTime.now());
        res.setPath(req.getRequestURI());

        return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DonorNotFoundException.class )
    public ResponseEntity<Response> donorNotFoundException(DonorNotFoundException ex, HttpServletRequest req){
        Response res = new Response();

        res.setMessage(ex.getMessage());
        res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        res.setDateTime(LocalDateTime.now());
        res.setPath(req.getRequestURI());

        return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
