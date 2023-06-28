package ir.mapsa.secondspring.models;

import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CourseDto extends AbstractDto {
    @Pattern(regexp = "^(\\w|\\s){3,40}$")
    private String name;
    @Pattern(regexp = "^([a-zA-Z]|\\s){3,40}$")
    private String topic;
//    @Pattern(regexp = "^\\d$")
    private Integer unit;
}
