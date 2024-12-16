package com.blumbit.gestion.gestiontareas.exception;

import java.util.Date;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blumbit.gestion.gestiontareas.common.dto.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse<String>> handleException(NotFoundException ex, HttpServletRequest request) {
        log.error(ex.getMessage(), ex);
        return new ResponseEntity<>(new ErrorResponse<String>(HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getMessage(), new Date().toString(), request.getRequestURI()),
                new HttpHeaders(),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = { AccessDeniedException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse<String>> handleExceptionAccesDenied(AccessDeniedException ex, HttpServletRequest request) {
        log.error(ex.getMessage(), ex);
        return new ResponseEntity<>(new ErrorResponse<String>(HttpStatus.FORBIDDEN,
                ex.getMessage(), new Date().toString(), request.getRequestURI()),
                new HttpHeaders(),
                HttpStatus.FORBIDDEN);
    }
    
}
