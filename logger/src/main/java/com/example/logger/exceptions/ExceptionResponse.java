package com.example.logger.exceptions;

import lombok.Data;

@Data
public class ExceptionResponse {
    private Boolean error;
    private String message;

}
