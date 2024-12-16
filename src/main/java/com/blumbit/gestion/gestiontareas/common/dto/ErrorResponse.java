package com.blumbit.gestion.gestiontareas.common.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse<T> {
    private HttpStatus statusCode;
    private T message;
    private String timestamp;
    private String path;
}
