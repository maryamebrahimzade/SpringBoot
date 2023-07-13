package com.example.logger.controllers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class LoggerAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerAspect.class);
    private ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    public void init() {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

   /* @Around("within(com.example.logger.controllers.AbstractController+)")
    public Object logger(ProceedingJoinPoint proceedingJoinPoint) {
        Signature signature = proceedingJoinPoint.getSignature();
        LOGGER.info("Method called: " + signature.getName());
        String args = Arrays.stream(proceedingJoinPoint.getArgs())
                .map(i -> {
                    try {
                        return objectMapper.writeValueAsString(i);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.joining("\n"));
        LOGGER.info("Arg is: " + args);
        Object value;
        try {
            value = proceedingJoinPoint.proceed();
            LOGGER.info("Returned: " + value);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return value;
    }*/

    //Convert multiple logs to one log
    public Object logger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Signature signature = proceedingJoinPoint.getSignature();
        LogModel logModel = new LogModel();
        logModel.setMethodName(signature.getName());
        logModel.setRequest(proceedingJoinPoint.getArgs());
        Object value;
        try {
            value = proceedingJoinPoint.proceed();
            if (value != null) {
                logModel.setResponse(value);
            }
            LOGGER.info("Success req/res is :" + objectMapper.writeValueAsString(logModel));
        } catch (Throwable e) {
            //Convert Exception to String
            StringWriter writer = new StringWriter();
            PrintWriter printWriter = new PrintWriter(writer);
            e.printStackTrace(printWriter);
            writer.close();
            printWriter.close();
            logModel.setErrorTrace(writer.toString());
            LOGGER.error("Failure req/res is :"+objectMapper.writeValueAsString(logModel));
            throw e;
        }
        return value;
    }
}

@Data
class LogModel {
    private String methodName;
    private Object request;
    private Object response;
    private String errorTrace;
}
