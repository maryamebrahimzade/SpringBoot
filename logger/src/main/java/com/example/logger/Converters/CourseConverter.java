package com.example.logger.Converters;

import com.example.logger.models.Course;
import com.example.logger.models.CourseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseConverter extends BaseConverter<CourseDto, Course> {


}
