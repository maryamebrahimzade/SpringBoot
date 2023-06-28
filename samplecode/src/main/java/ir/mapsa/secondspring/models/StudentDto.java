package ir.mapsa.secondspring.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
public class StudentDto extends AbstractDto  {
    @Pattern(regexp = "^([a-zA-Z]|\\s){3,20}$")
    private String name;
    @Pattern(regexp = "^([a-zA-Z]|\\s){3,40}$")
    private String family;
    @Pattern(regexp = "^\\d{1,3}$")
    private Integer age;
    private Integer passedCourse;
    @Pattern(regexp = "^\\d{10}$")
    private String nationalCode;
    @Pattern(regexp = "^\\d{3}$")
    private String studentId;
    private List<CourseDto> courses;
}
