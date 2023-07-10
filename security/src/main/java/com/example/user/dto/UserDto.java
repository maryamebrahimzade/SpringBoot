package com.example.user.dto;

import com.example.user.enums.GenderEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto extends BaseDto{
    private String name;
    private GenderEnum gender;
    private String email;
    private String password;
}
