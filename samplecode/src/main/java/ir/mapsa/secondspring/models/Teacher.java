package ir.mapsa.secondspring.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.envers.Audited;

import java.util.Date;

@Entity
@Table(name = "teacher")
@Data
//@Audited
public class Teacher extends AbstractEntity {
    private String name;
    private String family;
    @Column(unique = true)
    private String nationalCode;
    @Temporal(TemporalType.TIMESTAMP)
    private Date employedDate;
    private String level;
    @Enumerated(EnumType.STRING)
    private EducationLevel educationLevel;
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
