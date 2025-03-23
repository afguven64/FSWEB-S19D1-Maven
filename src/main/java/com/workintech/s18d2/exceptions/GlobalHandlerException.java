package com.workintech.s18d2.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalHandlerException {

    @ExceptionHandler
    public ResponseEntity<PlantErrorResponse> handleException(PlantException exception) {

        log.error("Runtime Error");
        PlantErrorResponse errorResponse = new PlantErrorResponse(exception.getStatus().value(), exception.getMessage(), System.currentTimeMillis())  ;
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<PlantErrorResponse> handleException(Exception e) {
        log.error("Error: {}", e.getMessage());
        PlantErrorResponse errorResponse = new PlantErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                e.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
