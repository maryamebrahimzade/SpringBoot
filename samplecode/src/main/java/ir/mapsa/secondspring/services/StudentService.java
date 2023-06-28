package ir.mapsa.secondspring.services;

import ir.mapsa.secondspring.models.Student;
import ir.mapsa.secondspring.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends AbstractService<StudentRepository, Student> {
}
