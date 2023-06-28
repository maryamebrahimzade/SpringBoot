package ir.mapsa.secondspring.Converters;

import ir.mapsa.secondspring.models.Teacher;
import ir.mapsa.secondspring.models.TeacherDto;
import org.springframework.stereotype.Service;

@Service
public class TeacherConverter implements BaseConverter<TeacherDto, Teacher> {
    @Override
    public Teacher convertDto(TeacherDto d) {
        Teacher e=new Teacher();
        e.setId(d.getId());
        e.setVersion(d.getVersion());
        e.setName(d.getName());
        e.setFamily(d.getFamily());
        e.setGender(d.getGender());
        e.setLevel(d.getLevel());
        e.setEmployedDate(d.getEmployedDate());
        e.setNationalCode(d.getNationalCode());
        return e;
    }

    @Override
    public TeacherDto convertEntity(Teacher e) {
        TeacherDto d=new TeacherDto();
        d.setId(e.getId());
        d.setVersion(e.getVersion());
        d.setName(e.getName());
        d.setFamily(e.getFamily());
        d.setGender(e.getGender());
        d.setLevel(e.getLevel());
        d.setNationalCode(e.getNationalCode());
        d.setEmployedDate(e.getEmployedDate());
        return d;
    }
}
