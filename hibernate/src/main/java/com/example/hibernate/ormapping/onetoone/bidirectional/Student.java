package com.example.hibernate.ormapping.onetoone.bidirectional;

import com.example.hibernate.ormapping.onetoone.unidirectional.StudentGfgDetail;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

@Entity
@Data
@NoArgsConstructor
@Table(name = "student")
public class Student extends BaseEntity {
    private String firstName;
    private String lastName;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_gfg_detail_id")
    private StudentGfgDetail studentGfgDetail;

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", studentGfgDetail=" + studentGfgDetail +
                '}';
    }
}
