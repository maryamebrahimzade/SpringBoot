package com.example.logger.Converters;

import com.example.logger.models.Student;
import com.example.logger.models.StudentDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentConverter extends BaseConverter<StudentDto,Student>{
}
