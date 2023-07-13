package com.example.logger.controllers;

import com.example.logger.models.Course;
import com.example.logger.models.CourseDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController extends AbstractController<Course, CourseDto> {
}
