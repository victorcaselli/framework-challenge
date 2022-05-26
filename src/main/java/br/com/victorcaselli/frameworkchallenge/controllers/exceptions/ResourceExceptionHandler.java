package br.com.victorcaselli.frameworkchallenge.controllers.exceptions;

import br.com.victorcaselli.frameworkchallenge.controllers.exceptions.model.StandardError;
import br.com.victorcaselli.frameworkchallenge.services.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<StandardError> discipleNotFound(IllegalArgumentException iae, HttpServletRequest request){
        return ResponseEntity.ok().body(StandardError.builder()
                .timestamp(Timestamp.valueOf(LocalDateTime.now()).getTime())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Client-side Error")
                .message(iae.getMessage())
                .path(request.getServletPath())
                .build());
    }


    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<StandardError> discipleNotFound(UserNotFoundException unfe, HttpServletRequest request){
        return ResponseEntity.ok().body(StandardError.builder()
                .timestamp(Timestamp.valueOf(LocalDateTime.now()).getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .error("Not Found")
                .message(unfe.getMessage())
                .path(request.getServletPath())
                .build());
    }
}
