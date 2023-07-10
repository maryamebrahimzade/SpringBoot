package com.example.user.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@AllArgsConstructor
@Getter
public enum GenderEnum {
    NOT_SET("Not Set", 0),
    MALE("Male", 1),
    FEMALE("Female", 2),
    OTHER("Other", 3);

    private String label;
    private int value;
}
