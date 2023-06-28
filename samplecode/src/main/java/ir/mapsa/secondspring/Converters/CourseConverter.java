package ir.mapsa.secondspring.Converters;

import ir.mapsa.secondspring.models.Course;
import ir.mapsa.secondspring.models.CourseDto;
import org.springframework.stereotype.Service;

@Service
public class CourseConverter implements BaseConverter<CourseDto, Course> {

    @Override
    public Course convertDto(CourseDto d)  {
        Course e = new Course();
        e.setId(d.getId());
        e.setVersion(d.getVersion());
        e.setName(d.getName());
        e.setTopic(d.getTopic());
        e.setUnit(d.getUnit());
        return e;
    }

    @Override
    public CourseDto convertEntity(Course e) {
        CourseDto d = new CourseDto();
        d.setId(e.getId());
        d.setVersion(e.getVersion());
        d.setName(e.getName());
        d.setTopic(e.getTopic());
        d.setUnit(e.getUnit());
        return d;
    }

}
