package com.example.logger.controllers;

import com.example.logger.exceptions.ExceptionResponse;
import com.example.logger.exceptions.ServiceException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Properties;

@ControllerAdvice
public class RestExceptionHandle {
    private Properties properties = new Properties();

    @PostConstruct
    public void init() throws IOException {
        properties.load(new FileReader("C:\\\\WorkProjects\\\\IdeaProjects\\\\second-spring\\\\src\\\\main\\\\resources\\\\exceptions_fa_IR.properties", Charset.forName("utf-8")));
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionResponse> handleException(ServiceException exception) {
        ExceptionResponse value = new ExceptionResponse();
        value.setError(true);
        String property = properties.getProperty(exception.getErrorCode());
        if (properties == null) {
            property = properties.getProperty("default");
        }
        value.setMessage(property);
        return ResponseEntity.badRequest().body(value);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionResponse> handleException(RuntimeException exception){
        ExceptionResponse value = new ExceptionResponse();
        value.setError(true);
        value.setMessage(properties.getProperty("unknown"));
        return ResponseEntity.badRequest().body(value);

    }
}
