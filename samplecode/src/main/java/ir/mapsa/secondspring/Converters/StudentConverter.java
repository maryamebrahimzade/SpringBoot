package ir.mapsa.secondspring.Converters;

import ir.mapsa.secondspring.models.Student;
import ir.mapsa.secondspring.models.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentConverter implements BaseConverter<StudentDto, Student> {
    @Autowired
    private CourseConverter courseConverter;
    @Override
    public Student convertDto(StudentDto d) {
        Student e=new Student();
        e.setId(d.getId());
        e.setVersion(d.getVersion());
        e.setName(d.getName());
        e.setFamily(d.getFamily());
        e.setAge(d.getAge());
        e.setNationalCode(d.getNationalCode());
        e.setPassedCourse(d.getPassedCourse());
        e.setStudentId(d.getStudentId());
        e.setCourses(courseConverter.covertDto(d.getCourses()));
        return e;
    }

    @Override
    public StudentDto convertEntity(Student e) {
        StudentDto d=new StudentDto();
        d.setId(e.getId());
        d.setVersion(e.getVersion());
        d.setName(e.getName());
        d.setFamily(e.getFamily());
        d.setAge(e.getAge());
        d.setNationalCode(e.getNationalCode());
        d.setPassedCourse(e.getPassedCourse());
        d.setStudentId(e.getStudentId());
        d.setCourses(courseConverter.convertEntity(e.getCourses()));
        return d;
    }
}
