package ir.mapsa.secondspring.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RestExceptionHandle {
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ExceptionResponse> handleException(Exception exception){
//        ExceptionResponse value = new ExceptionResponse();
//        value.setError(true);
//        if(exception instanceof IllegalArgumentException){
//            value.setMessage("داده ورودی اشتباه است");
//        }
//        return ResponseEntity.badRequest().body(value);
//    }
}
