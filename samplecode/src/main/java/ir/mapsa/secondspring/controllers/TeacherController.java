package ir.mapsa.secondspring.controllers;

import ir.mapsa.secondspring.models.Teacher;
import ir.mapsa.secondspring.models.TeacherDto;
import ir.mapsa.secondspring.services.TeacherService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController extends AbstractController<Teacher, TeacherDto> {
}
