package ir.mapsa.secondspring.services;

import ir.mapsa.secondspring.models.Course;
import ir.mapsa.secondspring.repositories.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService extends AbstractService<CourseRepository, Course> {
}
