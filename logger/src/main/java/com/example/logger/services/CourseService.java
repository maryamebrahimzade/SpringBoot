package com.example.logger.services;

import com.example.logger.models.Course;
import com.example.logger.repositories.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService extends AbstractService<CourseRepository, Course> {
}
