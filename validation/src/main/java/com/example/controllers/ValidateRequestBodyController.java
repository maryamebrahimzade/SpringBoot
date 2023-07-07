package com.example.controllers;

import com.example.dto.Input;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ValidateRequestBodyController {
    @PostMapping("/validateBody")
    public void validateBody(@Valid @RequestBody Input input) throws Exception {
        System.out.println("valid");
    }
}
