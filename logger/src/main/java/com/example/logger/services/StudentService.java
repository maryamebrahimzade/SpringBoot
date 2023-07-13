package com.example.logger.services;

import com.example.logger.models.Student;
import com.example.logger.repositories.StudentRepository;
import org.springframework.stereotype.Service;


@Service
public class StudentService extends AbstractService<StudentRepository, Student> {

}
