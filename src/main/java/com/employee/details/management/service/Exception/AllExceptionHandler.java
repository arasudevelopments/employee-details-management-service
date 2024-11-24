package com.employee.details.management.service.Exception;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AllExceptionHandler {


    Logger logger = LogManager.getLogger(AllExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleNullPointerException(Exception exception){
        logger.error(exception.getStackTrace());
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.CONFLICT);
    }
}
