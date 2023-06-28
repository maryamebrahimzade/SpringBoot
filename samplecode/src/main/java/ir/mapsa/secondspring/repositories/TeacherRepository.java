package ir.mapsa.secondspring.repositories;

import ir.mapsa.secondspring.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
