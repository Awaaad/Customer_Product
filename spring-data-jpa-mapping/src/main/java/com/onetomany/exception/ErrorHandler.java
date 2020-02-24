package com.onetomany.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ErrorHandler {
    private Error buildError(Exception ex, int status) {
        return new Error(ex.getMessage(), ex.getClass().getCanonicalName(), status);
    }

    ResponseEntity<Error> unHandledException(Exception ex, WebRequest request) {
        int status = 500;
        Error error = buildError(ex, status);
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(CustomerNotFound.class)
    ResponseEntity<Error> JobNotFoundException(Exception ex, WebRequest request){
        int status = 200;
        Error error = buildError(ex,status);
        return ResponseEntity.status(status).body(error);
    }

}
