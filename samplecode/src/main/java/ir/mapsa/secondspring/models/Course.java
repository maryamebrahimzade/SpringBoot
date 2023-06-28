package ir.mapsa.secondspring.models;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.envers.Audited;

import java.util.List;

@Entity
@Table(name = "course")
@Data
//@Audited
public class Course extends AbstractEntity {
    private String name;
    private String topic;
    private Integer unit;
    @ManyToMany(mappedBy = "courses",cascade = CascadeType.ALL)
    private List<Student> students;
}
