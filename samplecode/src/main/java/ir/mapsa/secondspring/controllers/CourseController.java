package ir.mapsa.secondspring.controllers;

import ir.mapsa.secondspring.models.Course;
import ir.mapsa.secondspring.models.CourseDto;
import ir.mapsa.secondspring.repositories.CourseRepository;
import ir.mapsa.secondspring.services.CourseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController extends AbstractController<Course, CourseDto> {
}
