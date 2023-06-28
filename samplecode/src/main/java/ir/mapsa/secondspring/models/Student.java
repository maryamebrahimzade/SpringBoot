package ir.mapsa.secondspring.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.Audited;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="STUDENT")
@Data
//@Audited
public class Student extends AbstractEntity  {
    private String name;
    private String family;
    private Integer age;
    private Integer passedCourse;
    @Column(unique = true)
    private String nationalCode;
    @Column(unique = true)
    private String studentId;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Course> courses;
}
