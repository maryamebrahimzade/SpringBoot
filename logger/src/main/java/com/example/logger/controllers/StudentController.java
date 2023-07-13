package com.example.logger.controllers;

import com.example.logger.models.Student;
import com.example.logger.models.StudentDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController extends AbstractController<Student, StudentDto> {

}
