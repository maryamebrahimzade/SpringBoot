package ir.mapsa.secondspring.repositories;

import ir.mapsa.secondspring.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
