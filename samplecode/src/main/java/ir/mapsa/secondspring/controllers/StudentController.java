package ir.mapsa.secondspring.controllers;

import ir.mapsa.secondspring.Converters.StudentConverter;
import ir.mapsa.secondspring.models.Student;
import ir.mapsa.secondspring.models.StudentDto;
import ir.mapsa.secondspring.services.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController extends AbstractController<Student, StudentDto> {

}
