package com.example.user.converters;

import com.example.user.models.User;
import com.example.user.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserConverter extends BaseConverter<UserDto, User> {

}
