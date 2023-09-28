package com.example.hibernate.ormapping.onetoone.unidirectional;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class Student extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_gfg_detail_id")
    private StudentGfgDetail studentGfgDetail;

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
