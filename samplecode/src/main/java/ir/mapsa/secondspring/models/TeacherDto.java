package ir.mapsa.secondspring.models;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class TeacherDto extends AbstractDto {
    @Pattern(regexp = "^([a-zA-Z]|\\s){3,20}$")
    private String name;
    @Pattern(regexp = "^([a-zA-Z]|\\s){3,40}$")
    private String family;
    @Pattern(regexp = "^\\d{10}$",message = "کد ملی اشتباه است")
    private String nationalCode;
    private Date employedDate;
    @Pattern(regexp = "^a|b|c$")
    private String level;
    private EducationLevel educationLevel;
    private Gender gender;
}
