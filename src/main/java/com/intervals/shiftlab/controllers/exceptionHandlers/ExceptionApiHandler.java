package com.intervals.shiftlab.controllers.exceptionHandlers;

import com.intervals.shiftlab.dto.ApiErrorResponse;
import com.intervals.shiftlab.exceptions.IntervalNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionApiHandler {

    @ExceptionHandler(IntervalNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> notFoundException(IntervalNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.I_AM_A_TEAPOT)
                .body(new ApiErrorResponse(exception.getMessage(),HttpStatus.I_AM_A_TEAPOT.value()));
    }
}