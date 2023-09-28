package com.example.user.controllers;

import com.example.user.converters.UserConverter;
import com.example.user.dto.UserDto;
import com.example.user.dto.UserEntryResponseDto;
import com.example.user.models.User;
import com.example.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserController extends BaseController<User, UserDto, UserService> {
    private final UserService service;
    private final UserConverter converter;


    public UserController(UserService service, UserConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @PostMapping("register")
    public UserEntryResponseDto register(@RequestBody UserDto userDto) {

        return service.register(converter.convertDto(userDto));
    }

//    @PostMapping("login")
//    public UserDto login(@RequestBody UserDto userDto) {
//
//        return mapper.toDto(service.login(mapper.toDomain(userDto)));
//    }

    @GetMapping("{id}")
    public UserDto getUser(@PathVariable("id") String id) {
//        return converter.convertEntity(service.getUser(ID.of(id)));
        return null;
    }

    @GetMapping("/me")
    public UserDto getMyInfo() {

        return converter.convertEntity(service.getMyInfo());
    }
}
