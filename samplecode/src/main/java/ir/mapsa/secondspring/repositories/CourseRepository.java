package ir.mapsa.secondspring.repositories;

import ir.mapsa.secondspring.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
    
}
